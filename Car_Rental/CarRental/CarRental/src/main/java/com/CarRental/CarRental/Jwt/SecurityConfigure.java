package com.CarRental.CarRental.Jwt;

import com.CarRental.CarRental.Services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigure {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public AuthenticationManager
    authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers(
                        "/authenticate",
                        "/bookCar",
                        "/add_user","/getUserBookings/{userId}",
                        "/getAdminCars/{id}","/getAdminBookings/{id}",
                        "/addCar","/getAllCars","/getSearchedList"
                )
                .permitAll().
                anyRequest().authenticated();
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}
