package com.sp.Service;

import com.sp.DTO.InfoUser.InfoUserResponceDTO;
import com.sp.DTO.Login.LoginRequestDTO;
import com.sp.DTO.UserDTO;
import com.sp.Entity.Card;
import com.sp.Entity.User;
import com.sp.Repository.UserRepository;
import com.sp.Service.Manager.CardManager;
import com.sp.Service.Manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private static final SecureRandom secureRandom = new SecureRandom(); // threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); // threadsafe

    @Autowired
    UserManager userManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CardManager cardManager;

    @Autowired
    private CardService cardService;


    public void newUser(UserDTO userDTO)
    {
        if(userRepository.findByLogin(userDTO.getLogin()) == null)
        {
            Random random = new Random();
            User user = new User(
                    null,
                    userDTO.getName(),
                    userDTO.getSurname(),
                    userDTO.getLogin(),
                    userDTO.getPassword(),
                    (500 + random.nextInt(2501 - 500))
            );
            userRepository.save(user);
            cardService.add5Cards(user);
        }
        else
        {
            throw new RuntimeException("L\'utilisateru existe deja");
        }

    }

    public String login(LoginRequestDTO loginRequestDTO)
    {
        User user = userRepository.findByLogin(loginRequestDTO.getLogin());

        if((user != null) && (Objects.equals(user.getPassword(), loginRequestDTO.getPassword())))
        {
            byte[] randomBytes = new byte[24];
            secureRandom.nextBytes(randomBytes);
            String token = base64Encoder.encodeToString(randomBytes);
            user.setToken(token);
            userRepository.save(user);
            return token;
        }
        else
        {
            throw new RuntimeException("utilisateur ou mot de passe incorrecte");
        }
    }

    public InfoUserResponceDTO getInfoUser(String token)
    {
        User user = userRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("impossible de trouver le token"));

        return new InfoUserResponceDTO(
                user.getName(),
                user.getSurname(),
                user.getLogin(),
                user.getBalance()
        );
    }


//    public void displayUserAndCards(User user) {
//        // Récupérer l'utilisateur à partir de la base de données
//        User fetchedUser = userRepository.findById(user.getId()).orElse(null);
//
//        if (fetchedUser != null) {
//            // Afficher les détails de l'utilisateur
//            System.out.println("Utilisateur : " + fetchedUser.getName());
//
//            // Récupérer les cartes associées à l'utilisateur à partir du service CardService
//            List<Card> userCards = cardService.getUserCards(fetchedUser);
//
//            if (!userCards.isEmpty()) {
//                System.out.println("Cartes de l'utilisateur :");
//                // Afficher les détails de chaque carte associée à l'utilisateur
//                for (Card card : userCards) {
//                    System.out.println(" - " + card.getName());
//                    // Afficher d'autres détails de la carte si nécessaire
//                }
//            } else {
//                System.out.println("L'utilisateur n'a pas de cartes.");
//            }
//        } else {
//            System.out.println("Utilisateur non trouvé.");
//        }
//    }

}
