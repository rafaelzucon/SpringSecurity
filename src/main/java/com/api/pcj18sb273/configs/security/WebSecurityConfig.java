package com.api.pcj18sb273.configs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { //WebSecurityConfigurerAdapter is Deprecated in Java 18!!!

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                //.anyRequest().permitAll(); // permitAll() permite todas as requisições, não é feita autenticação
                .anyRequest().authenticated(); // com authenticated() as requisições são, obrigatoriamente, autenticadas
    }
}
