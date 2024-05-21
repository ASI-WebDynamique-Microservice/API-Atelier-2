package com.sp.Service;

import com.sp.DTO.CardFormDTO;
import com.sp.Entity.Card;
import com.sp.Service.Manager.CardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CardService {

    @Autowired
    private CardManager cardManager;
    public Card newcard(CardFormDTO cardForm) {
        Card card = new Card(
                cardForm.getName(),
                cardForm.getDescription(),
                cardForm.getImage(),
                cardForm.getFamily(),
                cardForm.getAffinity(),
                cardForm.getHp(),
                cardForm.getEnergy(),
                cardForm.getAttack(),
                cardForm.getDefence()
        );
        cardManager.saveCard(card);
        return card;
    }


}
