package com.atanas.web.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.atanas.web")
public class MvcCoreConfig implements WebMvcConfigurer
{
  
}
