package com.sp.Service;

import com.sp.DTO.CardRequestDTO;
import com.sp.Entity.Card;
import com.sp.Entity.User;
import com.sp.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;


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

    public void assignCardToUser(Card card, User user) {
        if (card != null && user != null) {
            card.setUser(user);
            cardRepository.save(card);
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

    public void addCard(CardRequestDTO cardRequestDTO) {
        Card card = new Card(
                cardRequestDTO.getName(),
                cardRequestDTO.getDescription(),
                cardRequestDTO.getImage(),
                cardRequestDTO.getFamily(),
                cardRequestDTO.getAffinity(),
                cardRequestDTO.getHp(),
                cardRequestDTO.getEnergy(),
                cardRequestDTO.getAttack(),
                cardRequestDTO.getDefence(),
                cardRequestDTO.getPrice(),
                cardRequestDTO.isForSell()
        );
        cardRepository.save(card);
    }

    public List<Card> getIsForSellCards()
    {
        return cardRepository.findByIsForSell(true);

    }

    public List<Card> getUserandIsForSellCards(boolean isForSell ,User user)
    {
        return cardRepository.findByIsForSellAndUserId(isForSell, user.getId());
    }
}
