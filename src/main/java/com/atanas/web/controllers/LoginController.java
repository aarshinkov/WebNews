package com.atanas.web.controllers;

import com.atanas.web.entities.*;
import javax.validation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController
{
  @GetMapping(value = "/signup")
  public String prepareSignup(Model model)
  {
    UserEntity userEntity = new UserEntity();
    model.addAttribute("user", userEntity);

    return "login/signup";
  }

  @PostMapping(value = "/signup")
  public String signup(@ModelAttribute("user") @Valid UserEntity user, BindingResult bindingResult,
          Model model)
  {
    if (bindingResult.hasErrors())
    {
      return "login/signup";
    }

    System.out.println(user.getEmail());
    System.out.println(user.getUsername());
    System.out.println(user.getPassword());
    System.out.println(user.getFirstName());
    System.out.println(user.getLastName());
    return "redirect:/";
  }
}
