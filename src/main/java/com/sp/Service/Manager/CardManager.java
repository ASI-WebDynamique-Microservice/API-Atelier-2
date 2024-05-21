package com.sp.Service.Manager;

import com.sp.Entity.Card;
import com.sp.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CardManager {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAllCarte() {
        return cardRepository.findAll();
    }
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }
}
