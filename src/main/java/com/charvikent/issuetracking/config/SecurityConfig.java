
package com.charvikent.issuetracking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

 @Autowired 
 private UserDetailsService userDetailsService;
 
 @Override
 public void configure(AuthenticationManagerBuilder auth) throws Exception {    
	 auth.userDetailsService(userDetailsService);
	 //.passwordEncoder(passwordencoder());
 } 
 
 @Override
 protected void configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests()
	  .antMatchers("/dept").access("hasRole('ROLE_ADMIN')")
	  .antMatchers("/kporg").access("hasRole('ROLE_ADMIN')")
	  .antMatchers("/desig").access("hasRole('ROLE_ADMIN')")
	  .antMatchers("/orgDept").access("hasRole('ROLE_ADMIN')")
	  .antMatchers("/cate").access("hasRole('ROLE_ADMIN')")
	  .antMatchers("/employee").access("hasRole('ROLE_ADMIN')")
	  .antMatchers("/dashBoard").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	  .antMatchers("/task").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	  .anyRequest().permitAll()  //dashboard,task
  .and()
    .formLogin().loginPage("/login")
    .usernameParameter("username").passwordParameter("password")
    .defaultSuccessUrl("/dashBoard")
    .and()
    .logout()
    .logoutSuccessUrl("/") 
   .and()
   .exceptionHandling().accessDeniedPage("/403")
  .and()
    .csrf().disable();
 }
 
 @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }
}