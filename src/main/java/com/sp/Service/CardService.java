package com.sp.Service;

import com.sp.DTO.Card.CardRequestDTO;
import com.sp.DTO.Card.CardResponceDTO;
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


    public List<CardResponceDTO> getAllCardReponceDTOList() {
        return feedCardResponceDTO(cardRepository.findAll());
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getRandomCard(){
        List<Card> cards = cardRepository.findByIsForSellTrueAndUserIsNull();
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
            card.setForSell(false);


            cardRepository.save(card);
        } else {
            throw new IllegalArgumentException("Card or User is null");
        }

    }

    public void add5Cards(User user) {
        List<Card> randomCards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
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

    public List<CardResponceDTO> getUserCardReponceDTOList(User user) {
        // Récupérer les cartes associées à l'utilisateur à partir du repository
        return feedCardResponceDTO(cardRepository.findByUser(user));
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

    public List<CardResponceDTO> getIsForSellCards(boolean isForSell)
    {
        return feedCardResponceDTO(cardRepository.findByIsForSell(isForSell));

    }

    public List<CardResponceDTO> getUserandIsForSellCards(boolean isForSell , User user)
    {
        List <Card> cardList = cardRepository.findByIsForSellAndUserId(isForSell, user.getId());
        return feedCardResponceDTO(cardList);
    }

    private List<CardResponceDTO> feedCardResponceDTO(List<Card> cardList)
    {
        List <CardResponceDTO> cardResponceDTOList = null;
        for (Card card : cardList) {
            cardResponceDTOList.add(new CardResponceDTO(
                    card.getId(),
                    card.getName(),
                    card.getDescription(),
                    card.getImage(),
                    card.getFamily(),
                    card.getAffinity(),
                    card.getHp(),
                    card.getEnergy(),
                    card.getAttack(),
                    card.getDefence(),
                    card.getPrice(),
                    card.isForSell(),
                    card.getUser().getLogin() != null ? card.getUser().getLogin(): null
            ));
        }
        return cardResponceDTOList;
    }
}
