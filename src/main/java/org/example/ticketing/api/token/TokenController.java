package org.example.ticketing.api.token;

import org.example.ticketing.api.token.dto.TokenResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class TokenController {
    @PostMapping("/{userId}/token")
    public TokenResponse issueToken(
            @PathVariable Long userId
    ) {
        return new TokenResponse("token");
    }
}
