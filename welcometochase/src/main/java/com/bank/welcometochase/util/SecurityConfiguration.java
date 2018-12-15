package com.bank.welcometochase.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/employee").hasRole("EMPLOYEE")
                .antMatchers("/employee/*").hasRole("EMPLOYEE")
                .antMatchers("/manager-home").hasRole("MANAGER")
                .antMatchers("/manage*").hasRole("MANAGER")
                .anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("emp").password("abc").roles("EMPLOYEE").build());
        manager.createUser(users.username("man").password("abc").roles("MANAGER").build());
        return manager;
    }

}
