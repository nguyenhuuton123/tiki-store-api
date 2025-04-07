package com.codegym.tikistore.repository;

import com.codegym.tikistore.entitiy.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
