package com.atanas.web.services;

import com.atanas.web.entities.*;
import org.springframework.security.core.userdetails.*;

public interface UserService extends UserDetailsService
{
  void saveUser(UserEntity user);
}
