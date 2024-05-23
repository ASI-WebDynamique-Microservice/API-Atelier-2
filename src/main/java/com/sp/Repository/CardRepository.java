package com.sp.Repository;

import com.sp.Entity.Card;
import com.sp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByUser(User user);
    List<Card> findByIsForSellTrue();
}
