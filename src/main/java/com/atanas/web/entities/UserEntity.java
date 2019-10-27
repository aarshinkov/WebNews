package com.atanas.web.entities;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable
{
  @Id
  @GeneratedValue
  @Column(name = "user_id")
  private Integer userId;
  
  @Column(name = "email")
  private String email;
  
  @Column(name = "username")
  private String username;
  
  @Column(name = "password")
  private String password;
  
  @Column(name = "first_name")
  private String firstName;
  
  @Column(name = "last_name")
  private String lastName;
  
  @Column(name = "created_on")
  private Timestamp createdOn;
  
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rolename"))
  private List<RoleEntity> roles = new ArrayList<>();

  public Integer getUserId()
  {
    return userId;
  }

  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
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

  public Timestamp getCreatedOn()
  {
    return createdOn;
  }

  public void setCreatedOn(Timestamp createdOn)
  {
    this.createdOn = createdOn;
  }

  public List<RoleEntity> getRoles()
  {
    return roles;
  }

  public void setRoles(List<RoleEntity> roles)
  {
    this.roles = roles;
  }
}
