package com.example.demo.controller;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.AuthenticationRequest;
import com.example.demo.dto.request.VerifyRequest;
import com.example.demo.dto.response.AuthenticationResponse;
import com.example.demo.dto.response.VerifyResponse;
import com.example.demo.service.AuthenticationService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/auth")
@JsonInclude(JsonInclude.Include.NON_NULL)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .code(200)
                .message("Success")
                .result(result)
                .build();
    }

    @PostMapping("/verify")
    ApiResponse<VerifyResponse> verify(@RequestBody VerifyRequest request) throws ParseException, JOSEException {
        var result = authenticationService.verify(request);
        return ApiResponse.<VerifyResponse>builder()
                .code(200)
                .message("Success")
                .result(result)
                .build();
    }

}
