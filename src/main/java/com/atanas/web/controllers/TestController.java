package com.atanas.web.controllers;

import com.atanas.web.entities.*;
import com.atanas.web.repositories.*;
import com.atanas.web.test.*;
import java.util.*;
import javax.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController
{
  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

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

  // WebNews/greet/John/Doe
  @GetMapping(value = "/greet/{firstName}/{lastName}")
  public String greet(@PathVariable(name = "lastName") String last, @PathVariable(name = "firstName") String first, Model model)
  {
    model.addAttribute("firstName", first);
    model.addAttribute("lastName", last);

    return "test/greetMe";
  }

  @GetMapping(value = "/test/dummyRegister")
  public String prepareDummyRegister()
  {
    return "test/dummyRegister";
  }

  @PostMapping(value = "/test/register")
  public String dummyRegister(@RequestParam(value = "email") String email,
          @RequestParam(value = "password") String password,
          @RequestParam(value = "firstName") String firstName,
          @RequestParam(value = "age") Integer age, Model model)
  {
    model.addAttribute("email", email);
    model.addAttribute("password", password);
    model.addAttribute("firstName", firstName);
    model.addAttribute("age", age);

    return "test/registered";
  }

  @GetMapping(value = "/test/registerPerson")
  public String prepareRegisterPerson(Model model)
  {
    model.addAttribute("person", new Person());

    return "test/personRegister";
  }

  @PostMapping(value = "/test/registerPerson")
  public String registerPerson(@Valid Person person, BindingResult bindingResult, Model model)
  {
    if (bindingResult.hasErrors())
    {
      System.out.println("bindingResult: " + bindingResult.getAllErrors());
      return "test/personRegister";
    }

    System.out.println("Username: " + person.getUsername());
    System.out.println("First name: " + person.getFirstName());
    System.out.println("Last name: " + person.getLastName());
    System.out.println("Age: " + person.getAge());

    return "redirect:/";
  }

  @GetMapping(value = "/test/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public UserEntity getUser(@RequestParam("userId") Integer userId)
  {
    return usersRepository.findByUserId(userId);
  }

  @GetMapping(value = "/templateTest")
  public String templateTest()
  {
    return "test/templateTest";
  }

  @GetMapping(value = "/test/encode/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String encodePassword(@PathVariable("password") String password)
  {
    return passwordEncoder.encode(password);
  }
}
