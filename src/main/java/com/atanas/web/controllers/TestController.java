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

  @GetMapping(value = "/conditionals")
  public String conditionals(Model model)
  {
    int min = 0;
    int max = 100;

    int number = (int) (Math.random() * ((max - min) + 1)) + min;

    String personName = "Jane";

    model.addAttribute("randomNumber", number);
    model.addAttribute("name", personName);

    return "test/conditionals";
  }

  @GetMapping(value = "/loops")
  public String loops(Model model)
  {
    List<String> names = new ArrayList<>();
    names.add("John");
    names.add("Jane");
    names.add("Stefany");
    names.add("Atanas");
    names.add("Vicky");

    model.addAttribute("namesList", names);

    return "test/loops";
  }

  @GetMapping(value = "/greetMe")
  public String greetMe(@RequestParam(value = "firstName", defaultValue = "Jane") String first, @RequestParam(value = "lastName", required = false) String last, Model model)
  {
    model.addAttribute("firstName", first);
    model.addAttribute("lastName", last);
    
    return "test/greetMe";
  }
}
