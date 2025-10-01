package com.example.session07.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private SessionFilterChain sessionFilterChain;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/auth/**").permitAll();
                    auth.anyRequest().hasRole("ADMIN");
                })
                //  cấu hình chính sách quản lý phiên (session) cho ứng dụng , STATELESS ko lưu trữ trạng thái phiên đăng nhập, yêu cầu được xử lý độc lập và không có thông tin về phiên trước đó
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Dòng này vô hiệu hóa bảo vệ CSRF (Cross-Site Request Forgery),Bỏ qua bảo vệ CSRF, thường là cần thiết trong các ứng dụng không sử dụng session và khi sử dụng các phương thức xác thực khác.
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(sessionFilterChain, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
