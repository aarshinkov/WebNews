package com.atanas.web.config;

import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.atanas.web")
public class MvcCoreConfig implements WebMvcConfigurer
{
  @Bean
  public PasswordEncoder passwordEncoder()
  {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    return passwordEncoder;
  }
}
