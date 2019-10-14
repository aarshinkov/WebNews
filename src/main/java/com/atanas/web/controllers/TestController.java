package com.atanas.web.controllers;

import java.util.*;
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

  @GetMapping(value = "/dynamicText")
  public String dynamicText(Model model)
  {
    String greeting = "Hello, <hr> Atanas";
    Date date = new Date();
    
    model.addAttribute("greeting", greeting);
    model.addAttribute("now", date);
    
    return "test/dynamic";
  }
}
