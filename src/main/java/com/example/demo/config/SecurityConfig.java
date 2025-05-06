package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final String[] WHITELISTED_URLS = {
            "/api/users",
            "/api/auth/**",
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, WHITELISTED_URLS).permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
//        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(
//                jwt -> jwt.decoder()
//        ));
        return http.build();
    }

//    @Bean
//    JwtDecoder jwtDecoder() {
//      NimbusJwtDecoder nimbusJwtDecoder = NimbusJwtDecoder.withSecretKey(
//              new SecretKeySpec("your-secret-key".getBytes(), "HmacSHA
//    }
}