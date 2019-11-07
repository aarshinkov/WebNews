package com.atanas.web.services;

import com.atanas.web.entities.*;
import com.atanas.web.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class UserServiceImpl implements UserService
{
  @Autowired
  private UsersRepository usersRepository;
  
  @Override
  public void saveUser(UserEntity user)
  {
    usersRepository.save(user);
  }
}
