package com.sp.Service;

import com.sp.Entity.Card;
import com.sp.Entity.User;
import com.sp.Repository.CardRepository;
import com.sp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketService {

    @Autowired
    private CardRepository cardRepository;
    private UserRepository userRepository;
    private UserService userService;

    public List<Card> displayAvailableCards() {
        return cardRepository.findAll();
    }

    public void buyCard(String token, long id_card) {
        // Mettez en œuvre la logique d'achat de carte ici
        // Par exemple, associez la carte à l'utilisateur et retirez-la du marché

        User userBuy = userRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("impossible de trouver le token"));
        Card cardBuy = cardRepository.findById(id_card)
                .orElseThrow(() -> new RuntimeException("impossible de trouver le id"));
        userBuy.addCard(cardBuy);
        cardBuy.setForSell(false);
        userBuy.setBalance(userBuy.getBalance() - cardBuy.getPrice());
        //cardRepository.save(cardBuy);
        userRepository.save(userBuy);
        userService.displayUserAndCards(userBuy);


    }
    public void sellCard(Card card, User user) {
        // Mettez en œuvre la logique de vente de carte ici

    }
}
