package com.springboot.beckend.security;


import java.util.Arrays;
import java.util.List;
import jakarta.servlet.DispatcherType;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.springboot.beckend.jwt.JwtAuthenticationEntryPoint;
import com.springboot.beckend.jwt.JwtAuthenticationFilter;

import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthenticationFilter jwtRequestFilter;

    public WebSecurityConfig(
        JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
        JwtAuthenticationFilter jwtRequestFilter) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtRequestFilter = jwtRequestFilter;
    }

      private static final String[] PERMIT_URL_ARRAY = {
        /* swagger v3 */
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/",
        "/**"
        
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

      http.csrf().disable()
          .cors();
     
        http.authorizeHttpRequests(request -> request 
                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll() 
                .dispatcherTypeMatchers(DispatcherType.INCLUDE).permitAll() 
                // .requestMatchers(PERMIT_URL_ARRAY).permitAll()  
                // .requestMatchers(HttpMethod.POST).authenticated()
                // .requestMatchers(HttpMethod.PATCH).authenticated()
                // .requestMatchers(HttpMethod.DELETE).authenticated()
                .anyRequest().permitAll()  
        );
       

        http.exceptionHandling( exceptionHandling -> exceptionHandling
          .authenticationEntryPoint(jwtAuthenticationEntryPoint) 
        );

        http.sessionManagement(session -> session 
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Spring Security가 HttpSession을 생성하지 않으며 세션과 관련된 어떤 상태도 저장하지 않도록합니다.
        );

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        //해당 코드는 스프링 시큐리티 필터 체인에 JWT 인증 필터를 등록합니다. jwtRequestFilter는 필터 체인에 추가하려는 사용자 정의 필터입니다. 이는 Filter 인터페이스를 구현하며, 클라이언트가 보낸 JSON Web Token (JWT)을 유효성 검사하는 역할을 합니다.
          
          
        return http.getOrBuild(); //HttpSecurity 객체를 리턴합니다.
    }

    /* CORS */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
        AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationEventPublisher authenticationEventPublisher //인증인가에관한 이벤트를 발생
            (ApplicationEventPublisher applicationEventPublisher) {
        return new DefaultAuthenticationEventPublisher(applicationEventPublisher);
    }


}
