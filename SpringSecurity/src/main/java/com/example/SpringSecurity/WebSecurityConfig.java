package com.example.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 
		@Autowired
	    UserDetailsService userDetailsService;
		
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	 auth.inMemoryAuthentication()
	            .withUser("user")
	            .password("password")
	            .roles("USER");
	       
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.authorizeRequests()
	                .antMatchers("/login").hasAnyRole("USER")
	                .antMatchers("/").permitAll()
	                .and().formLogin()
	                .defaultSuccessUrl("/user", true)
	    			.and().logout()
	    	        .logoutSuccessUrl("/");
	    }

	    @Bean
	    public PasswordEncoder getPasswordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }
}