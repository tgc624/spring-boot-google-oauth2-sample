package com.oauth2google.sample;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    public void configure(HttpSecurity http) throws Exception {
		http
        .antMatcher("/**")
        .authorizeRequests()
        .antMatchers("/")
        .permitAll()
        .anyRequest()
        .authenticated();
		http.oauth2Login().defaultSuccessUrl("/login-success", true);
		http.logout().permitAll().logoutSuccessUrl("/logout-success");
		http.cors().disable();
		http.csrf().disable();

    }


}
