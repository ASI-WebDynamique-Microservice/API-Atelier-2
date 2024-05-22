package com.sp.Service;

import com.sp.Entity.Card;
import com.sp.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateService {

    @Autowired
    private CardRepository cardRepository;

    public void createAndSaveInitialCards() {
        List<Card> initialCards = generateInitialCards();
        cardRepository.saveAll(initialCards);
        System.out.println("Création et ajout des cartes terminés.");
    }

    private List<Card> generateInitialCards() {
        List<Card> initialCards = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Card card = new Card();
            card.setName("Card " + i);
            card.setDescription("Description for Card " + i);
            card.setImage("Image URL for Card " + i);
            card.setFamily("Family for Card " + i);
            card.setAffinity("Affinity for Card " + i);
            card.setHp(i * 10); // Example: 10, 20, 30...
            card.setEnergy(i * 5); // Example: 5, 10, 15...
            card.setAttack(i * 2); // Example: 2, 4, 6...
            card.setDefence(i * 3); // Example: 3, 6, 9...

            initialCards.add(card);
        }
        return initialCards;
    }
}
