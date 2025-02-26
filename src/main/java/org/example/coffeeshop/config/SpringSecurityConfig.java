package org.example.coffeeshop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/**", "/home", "/about", "/blog", "/blog-details", "/contact",
                                "/faq", "/index", "/loginPage", "/menu", "/projects",
                                "/services", "/shop", "/shop-details", "/single-service", "/team", "/css/**", "/js/**",
                                "/img/**", "/webfonts/**", "/fonts/**", "/webfonts/**", "/comment/**", "/features/**",
                                "/gallery/**", "/icon/**", "/logo/**", "/shop/**", "/slider", "/team/**", "/testimonial/**", "/static/**", "/bg").permitAll()
                        .anyRequest().authenticated()
                )

                .formLogin(login -> login
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/contact", true)
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}