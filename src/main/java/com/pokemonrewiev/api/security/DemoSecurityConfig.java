package com.pokemonrewiev.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
public class DemoSecurityConfig {

    private CustomUserDetailService customUserDetailService;

    @Autowired
    public DemoSecurityConfig(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/api/tum-yasaklar").permitAll()
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
        );

        // use HTTP Basic Authentication
        //HTTP Basic Authentication'ın kullanılacağını belirtir. İstemciden kullanıcı adı ve şifre ile kimlik doğrulama istenecektir.
        httpSecurity.httpBasic(Customizer.withDefaults());

        //disable CSRF (cross site request forgery)
        // in general not rquired for stateless REST ApIs that use POST, PUT, DELETE, and or PATCH
        httpSecurity.csrf(csrf -> csrf.disable());
                //.exceptionHandling()
                //.authenticationEntryPoint(jwtAuthEntryPoint)
                //.and()
                //.sessionManagement()
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter(){
        return new JWTAuthenticationFilter();
    }

}
