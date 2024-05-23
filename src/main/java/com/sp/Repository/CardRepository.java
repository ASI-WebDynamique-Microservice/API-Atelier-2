package com.sp.Repository;

import com.sp.Entity.Card;
import com.sp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByUser(User user);
    List<Card> findByIsForSellTrue();
    List<Card> findByIsForSell(boolean forSall);
    List<Card> findByIsForSellAndUserId(boolean forSall, Long userId);
}