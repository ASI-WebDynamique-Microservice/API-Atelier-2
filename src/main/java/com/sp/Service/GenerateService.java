package com.sp.Service;

import com.sp.Entity.Card;
import com.sp.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GenerateService implements ApplicationRunner {

    @Autowired
    private CardRepository cardRepository;

    public void createAndSaveInitialCards() {
        List<Card> initialCards = generateInitialCards();
        cardRepository.saveAll(initialCards);
        System.out.println("Création et ajout des cartes terminés.");
    }

    private List<Card> generateInitialCards() {
        List<Card> initialCards = new ArrayList<>();
        Random random = new Random();

        // Exemple de noms et descriptions de cartes Pokémon
        String[] pokemonNames = {"Pikachu", "Charmander", "Squirtle", "Bulbasaur", "Eevee", "Jigglypuff", "Meowth", "Psyduck", "Snorlax", "Mewtwo"};
        String[] pokemonFamilies = {"Electric", "Fire", "Water", "Grass", "Normal", "Fairy", "Normal", "Water", "Normal", "Psychic"};
        String[] pokemonAffinities = {"Thunder", "Blaze", "Torrent", "Overgrow", "Adaptability", "Cute Charm", "Pickup", "Damp", "Thick Fat", "Pressure"};

        for (int i = 0; i < 10; i++) {
            Card card = new Card();
            card.setName(pokemonNames[i]);
            card.setDescription("Description for " + pokemonNames[i]);
            card.setImage("Image URL for " + pokemonNames[i]);
            card.setFamily(pokemonFamilies[i]);
            card.setAffinity(pokemonAffinities[i]);
            card.setHp((i + 1) * 10); // Example: 10, 20, 30...
            card.setEnergy((i + 1) * 5); // Example: 5, 10, 15...
            card.setAttack((i + 1) * 2); // Example: 2, 4, 6...
            card.setDefence((i + 1) * 3); // Example: 3, 6, 9...
            card.setPrice(random.nextInt(500) + 1);
            card.setForSell(false);// Price between 1 and 500

            initialCards.add(card);
        }
        return initialCards;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Intiailisaiton des données");
        createAndSaveInitialCards();
    }
}