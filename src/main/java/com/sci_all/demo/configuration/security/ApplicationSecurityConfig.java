package com.sci_all.demo.configuration.security;

import com.sci_all.demo.configuration.security.filters.UserAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

    @Autowired
    private AuthenticationManager userAuthManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        UserAuthenticationFilter userAuthenticationFilter = new UserAuthenticationFilter();
        userAuthenticationFilter.setAuthenticationManager(userAuthManager);
        userAuthenticationFilter.setFilterProcessesUrl("/user/login");

        http.csrf(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        /* FILTERS */
        http.addFilter(userAuthenticationFilter);

        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/user/**").permitAll();
        });

        return http.httpBasic(Customizer.withDefaults()).build();
    }

}
