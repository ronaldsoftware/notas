package edu.pe.utp.notas.controller;

import edu.pe.utp.notas.dto.TokenRequest;
import edu.pe.utp.notas.dto.TokenResponse;
import edu.pe.utp.notas.dto.UserRequest;
import edu.pe.utp.notas.enums.ApiResponseCode;
import edu.pe.utp.notas.model.User;
import edu.pe.utp.notas.service.AuthService;
import edu.pe.utp.notas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.AuthenticationException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/token/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequest user) {
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario Registrado");
    }

    @PostMapping("/token")
    public ResponseEntity<TokenResponse> authenticateUser(@RequestBody TokenRequest tokenRequest) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(authService.login(tokenRequest));
        } catch (AuthenticationException e) {
            throw new RuntimeException(String.valueOf(ApiResponseCode.INVALID_CREDENTIALS));
        }

    }
}
