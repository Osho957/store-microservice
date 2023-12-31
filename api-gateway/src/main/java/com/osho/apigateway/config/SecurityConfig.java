package com.osho.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
     @Bean
    public SecurityWebFilterChain springSecurityWebFilterChain(ServerHttpSecurity serverHttpSecurity){
         serverHttpSecurity
                 .csrf(ServerHttpSecurity.CsrfSpec::disable)
                 .authorizeExchange(exchange -> exchange.pathMatchers("/eureka/**")
                         .permitAll()
                         .anyExchange()
                         .authenticated())
                 .oauth2ResourceServer(oauth2 -> oauth2
                         .jwt(withDefaults()));
         return serverHttpSecurity.build();
     }
}
