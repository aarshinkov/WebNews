package com.atanas.web.repositories;

import com.atanas.web.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface RolesRepository extends JpaRepository<RoleEntity, String>
{
  RoleEntity findByRolename(String rolename);
}
