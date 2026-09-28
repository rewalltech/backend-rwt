package backend.api.controller;

import backend.api.dto.LoginRequest;
import backend.api.dto.LoginResponse;
import backend.api.security.JwtService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtService jwtService;

    @Value("${ADMIN_EMAIL}")
    private String adminEmail;

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        if (!adminEmail.equals(request.getEmail())
                || !adminPassword.equals(request.getSenha())) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("E-mail ou senha inválidos.");
        }

        String token = jwtService.gerarToken(adminEmail);

        return ResponseEntity.ok(
                new LoginResponse(token)
        );
    }
}