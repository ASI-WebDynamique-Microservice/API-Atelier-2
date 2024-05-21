package com.sp.Service;

import com.sp.Entity.User;
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

    public int addUser(JSONObject jsonUser)
    {
        Random random = new Random();
        User user = new User(
                (String)jsonUser.get("name"),
                (String)jsonUser.get("surname"),
                (String)jsonUser.get("login"),
                (String)jsonUser.get("password"),
                (500 + random.nextInt(2501 - 500))
        );
        userManager.saveUser(user);
        return 0;
    }
}
