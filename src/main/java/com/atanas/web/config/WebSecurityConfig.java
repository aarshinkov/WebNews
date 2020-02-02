package com.atanas.web.config;

import com.atanas.web.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.password.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.authorizeRequests()
            .antMatchers("/greetMe").authenticated()
            .antMatchers("/loops").anonymous()
            .and()
            .formLogin()
            .loginPage("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .logout()
            .logoutSuccessUrl("/login")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .and()
            .httpBasic();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception
  {
//    auth.inMemoryAuthentication()
//            .withUser("user1").password("{noop}user1pass").roles("USER")
//            .and()
//            .withUser("admin1").password("{noop}admin1pass").roles("ADMIN", "USER");
    auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
  }

}
