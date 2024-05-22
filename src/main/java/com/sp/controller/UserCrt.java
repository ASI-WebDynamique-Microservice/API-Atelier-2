package com.sp.controller;

import com.sp.DTO.UserDTO;
import com.sp.Service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
//@RequestMapping("/user")
public class UserCrt {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/user/new"}, method = RequestMethod.POST)
    public int newUser(@RequestBody UserDTO user)
    {
        userService.addUser(user);
        return 0;
    }

}
