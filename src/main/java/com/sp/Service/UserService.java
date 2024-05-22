package com.sp.Service;

import com.sp.DTO.UserDTO;
import com.sp.Entity.User;
import com.sp.Repository.UserRepository;
import com.sp.Service.Manager.CardManager;
import com.sp.Service.Manager.UserManager;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserManager userManager;

    @Autowired
    CardManager cardManager;
    @Autowired
    private CardService cardService;
    @Autowired
    private UserRepository userRepository;

    public int addUser(UserDTO userDTO)
    {
        Random random = new Random();
        User user = new User(
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getLogin(),
                userDTO.getPassword(),
                (500 + random.nextInt(2501 - 500))
        );

        userRepository.save(user);
        cardService.add5Cards(user);
        return 0;
    }
}
