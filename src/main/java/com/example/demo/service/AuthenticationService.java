package com.example.demo.service;

import com.example.demo.dto.request.AuthenticationRequest;
import com.example.demo.dto.request.VerifyRequest;
import com.example.demo.dto.response.AuthenticationResponse;
import com.example.demo.dto.response.VerifyResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.experimental.NonFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.StringJoiner;

import static com.example.demo.exception.ErrorCode.USER_NOT_AUTH;


@Service
public class AuthenticationService {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    UserRepository userRepository;

    @NonFinal
    @Value("${jwt.apiKeyToken}")
    protected String API_KEY_TOKEN;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public VerifyResponse verify(VerifyRequest request)
            throws JOSEException, ParseException {
        var token = request.getToken();
        JWSVerifier verifier = new MACVerifier(API_KEY_TOKEN);
        SignedJWT signedJWT = SignedJWT.parse(token);
        var expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        var verify = signedJWT.verify(verifier);
        return VerifyResponse.builder()
                .valid(verify && expirationTime.after(new Date()))
                .build();
    }

    public VerifyResponse logout(VerifyRequest request)
            throws JOSEException, ParseException {
        var token = request.getToken();
        JWSVerifier verifier = new MACVerifier(API_KEY_TOKEN);
        SignedJWT signedJWT;
        try {
            signedJWT = SignedJWT.parse(token);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid token format", e);
        }
        var expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        var verify = signedJWT.verify(verifier);
        if (!verify || expirationTime.before(new Date())) {
            throw new RuntimeException("Token không hợp hệ hoặc hết hạn");
        }
        return VerifyResponse.builder()
                .valid(false)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userRepository.findByName(request.getName())
                .orElseThrow(
                        () -> new RuntimeException(USER_NOT_AUTH.getMessage()));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!authenticated) {
            throw new RuntimeException(USER_NOT_AUTH.getMessage());
        }
        var token = generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

    private String generateToken(User name) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(name.getName())
                .issuer("http://localhost:8080")
                .expirationTime(new Date(System.currentTimeMillis() + 3600 * 1000))
                .claim("scope", buildScope(name))
                .build();
        Payload payload = new Payload(String.valueOf(claimsSet));
        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(API_KEY_TOKEN.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildScope(User user) {
        StringJoiner stringJoiner = new StringJoiner("");
        if (!CollectionUtils.isEmpty(user.getRoles())) {
            user.getRoles().forEach(stringJoiner::add);
        }
        return stringJoiner.toString().trim();
    }
}
