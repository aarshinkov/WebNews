package com.atanas.web.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ErrorController
{
  @GetMapping(value = "/404")
  public String error404()
  {
    return "error/404";
  }
}
