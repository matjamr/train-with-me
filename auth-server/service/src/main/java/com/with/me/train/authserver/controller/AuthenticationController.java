package com.with.me.train.authserver.controller;

import com.with.me.train.authserver.model.request.AuthenticationRequest;
import com.with.me.train.authserver.model.response.AuthenticationResponse;
import com.with.me.train.authserver.model.request.RegisterRequest;
import com.with.me.train.authserver.service.impl.JwtAuthenticateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final JwtAuthenticateService jwtAuthenticateService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(jwtAuthenticateService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
            ) throws Exception {
        return ResponseEntity.ok(jwtAuthenticateService.authenticate(request));
    }

    @RequestMapping("/google")
    public ResponseEntity<?> googleAuth(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
