package com.atanas.web.repositories;

import com.atanas.web.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Integer>
{
  //SQL Query SELECT * from USERS where user_id = ?
  UserEntity findByUserId(Integer userId);

  //SQL Query SELECT * from USERS where first_name = ? AND last_name = ? ORDER BY created_on
  UserEntity findByFirstNameAndLastNameOrderByCreatedOn(String firstName, String lastName);

  UserEntity findByUsername(String username);

  //SQL Query INSERT INTO USERS VALUES(..., ..., ...)
  @Override
  UserEntity save(UserEntity userEntity);
}
