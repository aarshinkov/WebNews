package com.atanas.web.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController
{
  @GetMapping(value = "/")
  public String home()
  {
    return "home";
  }
}
