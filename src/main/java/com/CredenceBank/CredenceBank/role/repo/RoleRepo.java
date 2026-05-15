package com.CredenceBank.CredenceBank.role.repo;

import com.CredenceBank.CredenceBank.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//Repository म्हणजे: Database access layer
//Controller → Service → Repository → Database
public interface RoleRepo extends JpaRepository<Role , Long>
{
    Optional<Role> findByName(String name);
}
