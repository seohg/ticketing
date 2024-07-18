package org.example.ticketing.interfaces.presentation.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.application.user.UserBalanceUseCase;
import org.example.ticketing.interfaces.presentation.user.dto.UserBalanceRequest;
import org.example.ticketing.interfaces.presentation.user.dto.UserBalanceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "사용자 잔액 관련 API")
@RequiredArgsConstructor
public class UserController {
    private final UserBalanceUseCase userBalanceUseCase;

    @Operation(summary = "잔액 조회", description = "잔액 조회", responses = {
            @ApiResponse(responseCode = "200", description = "유저 잔액 리턴")
        }
    )
    @GetMapping("/{userId}/balance")
    public ResponseEntity<UserBalanceResponse> getBalance(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(userBalanceUseCase.getUserBalance(userId));
    }

    @Operation(summary = "잔액 충전", description = "잔액 충전", responses = {
            @ApiResponse(responseCode = "200", description = "잔액 충전 성공 여부 리턴")
        }
    )
    @PostMapping("/{userId}/balance")
    public ResponseEntity<Void> chargeBalance(
            @PathVariable Long userId,
            @RequestBody UserBalanceRequest userRequest
    ) {
        userBalanceUseCase.chargeUserBalance(userId, userRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}