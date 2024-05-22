package com.sp.Repository;

import com.sp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    User findByLogin(String login);
    Optional<User> findByToken(String token);
}

