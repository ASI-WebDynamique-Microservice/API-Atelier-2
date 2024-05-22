package com.sp.Service;

import com.sp.Entity.Card;
import com.sp.Entity.User;
import com.sp.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> displayAvailableCards() {
        return cardRepository.findAll();
    }

    public void buyCard(Card card, User user) {
        // Mettez en œuvre la logique d'achat de carte ici
        // Par exemple, associez la carte à l'utilisateur et retirez-la du marché
    }
    public void sellCard(Card card, User user) {
        // Mettez en œuvre la logique de vente de carte ici

    }
}
