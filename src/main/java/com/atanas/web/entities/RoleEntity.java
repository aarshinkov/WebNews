package com.atanas.web.entities;

import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity implements Serializable
{
  @Id
  @Column(name = "rolename")
  private String rolename;
  
  @Column(name = "display_name")
  private String displayName;
  
  @Column(name = "descr")
  private String description;

  public String getRolename()
  {
    return rolename;
  }

  public void setRolename(String rolename)
  {
    this.rolename = rolename;
  }

  public String getDisplayName()
  {
    return displayName;
  }

  public void setDisplayName(String displayName)
  {
    this.displayName = displayName;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}
