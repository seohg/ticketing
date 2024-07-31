package org.example.ticketing.interfaces.presentation.token;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.application.token.useCase.TokenUseCase;
import org.example.ticketing.domain.token.model.Token;
import org.example.ticketing.interfaces.presentation.token.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tag(name = "Token", description = "대기열 토큰 관련 API")
public class TokenController {

    private final TokenUseCase tokenUseCase;

    @Operation(summary = "토큰발급", description = "대기열 토큰 발급", responses = {
        @ApiResponse(responseCode = "200", description = "유저 토큰 반환", content =
            @Content(schemaProperties = {
                    @SchemaProperty(name = "token", schema = @Schema(type = "string", description = "토큰")),
                    @SchemaProperty(name = "status", schema = @Schema(type = "status", description = "토큰 상태")),
                    @SchemaProperty(name = "waitNumber", schema = @Schema(type = "long", description = "대기번호"))
            })
        )
    })
    @PostMapping("/{userId}/token")
    public ResponseEntity<TokenResponse> issueToken(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(tokenUseCase.issueToken(userId));
    }

    @Operation(summary = "토큰조회", description = "유저의 대기열 토큰 조회", responses = {
            @ApiResponse(responseCode = "200", description = "유저 토큰 반환", content =
            @Content(schemaProperties = {
                    @SchemaProperty(name = "token", schema = @Schema(type = "string", description = "토큰")),
                    @SchemaProperty(name = "status", schema = @Schema(type = "status", description = "토큰 상태")),
                    @SchemaProperty(name = "waitNumber", schema = @Schema(type = "long", description = "대기번호"))
            })
            )
    })
    @GetMapping("/{userId}/token")
    public ResponseEntity<TokenResponse> getWaitToken(
            @RequestHeader(required = false, name = "Authorization") String token
    ) {
        return ResponseEntity.ok(tokenUseCase.getToken(token));
    }
}
