//package com.webApi.MyWebApi.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())  // Disable CSRF for REST APIs
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/public/**").permitAll()  // Public URLs
//                        .anyRequest().authenticated()  // Secure everything else
//                )
//                .formLogin()  // You can replace formLogin with custom authentication mechanism
//                .and()
//                .httpBasic();  // HTTP Basic authentication (deprecated, consider alternatives like JWT)
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        var user = User.withUsername("user")
//                .password(passwordEncoder().encode("password"))  // Encode the password
//                .roles("USER")
//                .build();
//
//        var admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();  // Use BCrypt to encode passwords
//    }
//}
