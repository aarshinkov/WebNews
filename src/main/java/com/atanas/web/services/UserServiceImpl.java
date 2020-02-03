package com.atanas.web.services;

import com.atanas.web.entities.*;
import com.atanas.web.repositories.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

@Service
public class UserServiceImpl implements UserService
{
  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private RolesRepository rolesRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void saveUser(UserEntity user)
  {
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    List<RoleEntity> roles = new ArrayList();

    RoleEntity role = rolesRepository.findByRolename("USER");

    roles.add(role);

    user.setRoles(roles);

    usersRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
  {
    UserEntity userEntity = usersRepository.findByUsername(username);

    List<GrantedAuthority> roles = new ArrayList();

    for (RoleEntity role : userEntity.getRoles())
    {
      roles.add(new SimpleGrantedAuthority("ROLE_" + role.getRolename()));
    }

    return new User(userEntity.getUsername(), userEntity.getPassword(), roles);
  }
}
