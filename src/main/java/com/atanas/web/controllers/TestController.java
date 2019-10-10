package com.atanas.web.controllers;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController
{
  @GetMapping(value = "/testModel")
  public String testModel(Model model)
  {
    String name = "Atanas";
    int a = 4;

    model.addAttribute("myName", name);
    model.addAttribute("number", a);

    return "test/testModel";
  }
}
