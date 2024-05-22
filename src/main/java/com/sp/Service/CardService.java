package com.sp.Service;

import com.sp.DTO.CardFormDTO;
import com.sp.Entity.Card;
import com.sp.Entity.User;
import com.sp.Repository.CardRepository;
import com.sp.Repository.UserRepository;
import com.sp.Service.Manager.CardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;



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
        cardRepository.save(card);
        return card;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }



    public Card getRandomCard(){
        List<Card> cards = cardRepository.findAll();
        if (cards.isEmpty()) {
            return null; // ou vous pouvez lancer une exception
        }
        Random random = new Random();
        int randomIndex = random.nextInt(cards.size());

        return cards.get(randomIndex);
    }

    public Card assignCardToUser(Card card, User user) {
        if (card != null && user != null) {
            card.setUser(user);

            return cardRepository.save(card);
        } else {
            throw new IllegalArgumentException("Card or User is null");
        }

    }

    public void add5Cards(User user) {
        List<Card> randomCards = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Card newCard = getRandomCard();
            randomCards.add(newCard);
        }


        // Assign each random card to the user
        for (Card card : randomCards) {
            assignCardToUser(card, user);
        }


    }

    public List<Card> getUserCards(User user) {
        // Récupérer les cartes associées à l'utilisateur à partir du repository
        return cardRepository.findByUser(user);
    }

}
