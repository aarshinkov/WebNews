package com.atanas.web.controllers;

import com.atanas.web.entities.*;
import com.atanas.web.services.*;
import javax.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController
{
  @Autowired
  private UserService userService;

  @GetMapping(value = "/login")
  public String prepareLogin(Model model)
  {
    model.addAttribute("globalMenu", "login");

    return "login/login";
  }

  @GetMapping(value = "/signup")
  public String prepareSignup(Model model)
  {
    UserEntity userEntity = new UserEntity();
    model.addAttribute("user", userEntity);
    model.addAttribute("globalMenu", "signup");

    return "login/signup";
  }

  @PostMapping(value = "/signup")
  public String signup(@ModelAttribute("user") @Valid UserEntity user, BindingResult bindingResult,
          Model model)
  {
    if (bindingResult.hasErrors())
    {
      model.addAttribute("globalMenu", "signup");
      return "login/signup";
    }

    userService.saveUser(user);

    return "redirect:/";
  }
}
