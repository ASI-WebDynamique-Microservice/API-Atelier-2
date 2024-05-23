package com.sp.Repository;

import com.sp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User findByLogin(String login);
    Optional<User> findByToken(String token);
}

