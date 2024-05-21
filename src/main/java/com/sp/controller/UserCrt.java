package com.sp.controller;

import com.sp.Service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserCrt {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/user/new"}, method = RequestMethod.POST)
    public int newUser(@RequestBody JSONObject user)
    {
        userService.addUser(user);
        return 0;
    }

}
