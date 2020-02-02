package com.atanas.web.entities;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable, UserDetails
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer userId;

  @NotEmpty(message = "Email must not be empty")
  @Size(max = 200)
  @Column(name = "email")
  private String email;

  @NotEmpty(message = "Username must not be empty")
  @Size(max = 60, message = "Username must be between {min} and {max}")
  @Column(name = "username")
  private String username;

  @NotEmpty(message = "Password must not be empty")
  @Size(max = 100)
  @Column(name = "password")
  private String password;

  @NotEmpty(message = "First name must not be empty")
  @Size(max = 80)
  @Column(name = "first_name")
  private String firstName;

  @NotEmpty(message = "Last name must not be empty")
  @Size(max = 80)
  @Column(name = "last_name")
  private String lastName;

  @Column(name = "created_on")
  private Date createdOn = new Date();

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rolename"))
  private List<RoleEntity> roles = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities()
  {
    List<GrantedAuthority> authorities = new ArrayList();

    for (RoleEntity role : roles)
    {
      authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRolename())); // ROLE_USER, ROLE_ADMIN
    }

    return authorities;
  }

  @Override
  public boolean isAccountNonExpired()
  {
    return true;
  }

  @Override
  public boolean isAccountNonLocked()
  {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired()
  {
    return true;
  }

  @Override
  public boolean isEnabled()
  {
    return true;
  }

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

  public Date getCreatedOn()
  {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn)
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
