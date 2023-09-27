
package com.app.ordertableweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/databasetable").permitAll()
                .antMatchers("/databasetable/**").permitAll()
                .antMatchers("/sandbox").permitAll()
                .antMatchers("/sandbox/**").permitAll()
                .antMatchers("/account").permitAll()
                .antMatchers("/account/**").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/signup/**").permitAll()
                .antMatchers("/managebooking").hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/managebooking/**").hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/usersession").permitAll()
                .antMatchers("/usersession/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .anyRequest().authenticated() // Require authentication for any other request
                .and()
            .formLogin()
                .loginPage("/login") // Use /fancy-login as the login page
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and()
            .csrf()
                .disable(); // Disable CSRF protection
        return http.build();
    }
}

