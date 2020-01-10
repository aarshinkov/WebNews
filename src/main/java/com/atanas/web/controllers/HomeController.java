package com.atanas.web.controllers;

import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  @GetMapping(value = "/")
  public String home(Model model)
  {
    log.debug("In home method");
    log.error("Some error");

    model.addAttribute("globalMenu", "home");

    return "home";
  }
}
