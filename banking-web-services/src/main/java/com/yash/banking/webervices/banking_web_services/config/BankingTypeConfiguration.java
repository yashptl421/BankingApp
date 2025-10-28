package com.yash.banking.webervices.banking_web_services.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class BankingTypeConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.csrf(csrf -> csrf.disable());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
  @Bean
  public ModelMapper modelMapper() {
      ModelMapper modelMapper = new ModelMapper();
      return modelMapper;
  }
    @Bean("restTemplate30s")
    public RestTemplate restTemplate30s(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofSeconds(30)) // Connection timeout
                .setReadTimeout(Duration.ofSeconds(30))    // Read timeout
                .build();
    }
}
