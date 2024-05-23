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

        User userSeller = cardBuy.getUser();

        if(cardBuy.isForSell()) {
            cardBuy.setUser(userBuy);
            cardBuy.setForSell(false);
        }
        else{return "Carte indispo";}

        int newBalanceBuy = userBuy.getBalance() - cardBuy.getPrice();
        int newBalanceSeller = userBuy.getBalance() - cardBuy.getPrice();
        if(newBalanceBuy > 0) {
            userBuy.setBalance(newBalanceBuy);
            userSeller.setBalance(newBalanceSeller);
        }
        else{return "Solde insuffisant";}

        cardRepository.save(cardBuy);
        userRepository.save(userBuy);
        userRepository.save(userSeller);
        userService.displayUserAndCards(userBuy);

        return String.valueOf(newBalanceBuy);

    }
    public String sellCard(String token, long id_card) {
        // Mettez en œuvre la logique de vente de carte ici
        User userSell = userRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("impossible de trouver le token"));
        Card cardSell = cardRepository.findById(id_card)
                .orElseThrow(() -> new RuntimeException("impossible de trouver le id"));
        if(!cardSell.isForSell()) {

            cardSell.setForSell(true);

        }
        else{return "Carte indspo";}


        userRepository.save(userSell);
        cardRepository.save(cardSell);
        userService.displayUserAndCards(userSell);
        return "Carte à vendre";

    }
}
