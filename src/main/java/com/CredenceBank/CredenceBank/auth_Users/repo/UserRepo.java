package com.CredenceBank.CredenceBank.auth_Users.repo;

import com.CredenceBank.CredenceBank.auth_Users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User , Long> {
    Optional<User> findByEmail(String email);
}
