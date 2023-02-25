package com.with.me.train.authserver.config;

import com.with.me.train.authserver.service.impl.GoogleOauth2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JWTAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final GoogleOauth2Service googleOauth2Service;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .cors()
                .and()
                    .csrf()
                    .disable()
                .formLogin().permitAll()
                .loginPage("/login")
                    .usernameParameter("email")
                    .passwordParameter("pass")
                    .defaultSuccessUrl("/list")
                .and()
                .authorizeHttpRequests()
                    .requestMatchers("/api/v1/auth/**").permitAll()
                    .requestMatchers("/api/v1/auth/authenticate").permitAll()
                    .requestMatchers("/", "/login", "/oauth/**").permitAll()
                .anyRequest()
                    .authenticated()
                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .oauth2ResourceServer().jwt()
                .and().and()
                    .authenticationProvider(authenticationProvider)
                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//                .oauth2Login()
//                    .loginPage("/login")
//                    .userInfoEndpoint()
//                    .userService(googleOauth2Service)
//                .and()
//                .successHandler((request, response, authentication) -> {
//
//                    GoogleOAuth2User oauthUser = (GoogleOAuth2User) authentication.getPrincipal();
//
//                    googleOauth2Service.processOAuthPostLogin(oauthUser.getEmail());
//
//                    response.sendRedirect("/list");
//                });

        return httpSecurity.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
