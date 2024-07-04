package org.example.ticketing.api.user;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.api.user.dto.UserRequest;
import org.example.ticketing.api.user.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/{userId}/balance")
    public UserResponse getBalance(
            @PathVariable Long userId
    ) {
        return new UserResponse(10000L);
    }

    @PostMapping("/{userId}/balance")
    public ResponseEntity<Void> chargeBalance(
            @PathVariable Long userId,
            @RequestBody UserRequest userRequest
    ) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}