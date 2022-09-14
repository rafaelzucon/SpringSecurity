package com.api.pcj18sb273.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { //WebSecurityConfigurerAdapter is Deprecated in Java 18!!!

    final UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                //.anyRequest().permitAll(); // permitAll() permite todas as requisições, não é feita autenticação
                .anyRequest().authenticated() // com authenticated() as requisições são, obrigatoriamente, autenticadas
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        // AUTENTICAÇÃO EM MEMÓRIA
//        auth.inMemoryAuthentication()
//                .withUser("asdrubal")
//                .password(passwordEncoder().encode("06081976"))
//                .roles("ADMIN");

        // AUTENTICAÇÃO EM BANCO DE DADOS (Criar endpoint para cadastro de usuários)
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
