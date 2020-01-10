package com.atanas.web.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.authorizeRequests()
            .antMatchers("/greetMe").authenticated()
            .antMatchers("/loops").anonymous()
            .and()
            .formLogin()
            .and()
            .logout();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.inMemoryAuthentication()
            .withUser("user1").password("{noop}user1pass").roles("USER")
            .and()
            .withUser("admin1").password("{noop}admin1pass").roles("ADMIN", "USER");
  }

}
