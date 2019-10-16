package com.atanas.web.test;

import javax.validation.constraints.*;

public class Person
{
  @NotNull
  @Size(min = 2, max = 20, message = "Wrong size. Size must be between {min} and {max}")
  private String username;
  
  @NotNull
  @Size(min = 2, max = 30)
  private String firstName;
  
  @NotNull
  @Size(min = 2, max = 20)
  private String lastName;
  
  @NotNull(message = "This field MUST NOT be null!!")
  @Min(0)
  @Max(120)
  private Integer age;

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public Integer getAge()
  {
    return age;
  }

  public void setAge(Integer age)
  {
    this.age = age;
  }
}
