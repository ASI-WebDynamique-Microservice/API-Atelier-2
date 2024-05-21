package com.sp.Service;

import com.sp.Entity.Card;
import com.sp.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAllCarte() {
        return cardRepository.findAll();
    }
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

}
