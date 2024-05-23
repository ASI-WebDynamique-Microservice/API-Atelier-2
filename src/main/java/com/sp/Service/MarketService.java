package com.sp.Service;

import com.sp.Entity.Card;
import com.sp.Entity.User;
import com.sp.Repository.CardRepository;
import com.sp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public List<Card> displayAvailableCards() {
        return cardRepository.findAll();
    }

    public String buyCard(String token, long id_card) {
        // Mettez en œuvre la logique d'achat de carte ici
        // Par exemple, associez la carte à l'utilisateur et retirez-la du marché

        User userBuy = userRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("impossible de trouver le token"));
        Card cardBuy = cardRepository.findById(id_card)
                .orElseThrow(() -> new RuntimeException("impossible de trouver le id"));
        if(cardBuy.isForSell()) {
            cardBuy.setUser(userBuy);
            cardBuy.setForSell(false);
        }
        else{return "Carte indispo";}

        int newBalance = userBuy.getBalance() - cardBuy.getPrice();
        if(newBalance > 0) {
            userBuy.setBalance(newBalance);
        }
        else{return "Solde insuffisant";}

        cardRepository.save(cardBuy);
        userRepository.save(userBuy);
        userService.displayUserAndCards(userBuy);

        return String.valueOf(newBalance);

    }
    public String sellCard(String token, long id_card) {
        // Mettez en œuvre la logique de vente de carte ici
        User userSell = userRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("impossible de trouver le token"));
        Card cardSell = cardRepository.findById(id_card)
                .orElseThrow(() -> new RuntimeException("impossible de trouver le id"));
        if(!cardSell.isForSell()) {
            cardSell.setUser(null);
            cardSell.setForSell(true);

        }
        else{return "Carte indspo";}

        int newBalance = userSell.getBalance() + cardSell.getPrice();
        userSell.setBalance(newBalance);
        userRepository.save(userSell);
        cardRepository.save(cardSell);
        userService.displayUserAndCards(userSell);
        return String.valueOf(newBalance);

    }
}
