package com.atanas.web.exceptions;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@ControllerAdvice
public class GlobalExceptionHandler
{
  @ExceptionHandler(NoHandlerFoundException.class)
  public String handler404(NoHandlerFoundException ex)
  {
    return "redirect:/404";
  }
}
