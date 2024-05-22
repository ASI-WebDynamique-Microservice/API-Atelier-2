package com.sp.controller;

import com.sp.Entity.Card;
import com.sp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class InventoryCrt {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    public List<Card> cards(@RequestHeader("TOKEN") String token)
    {
        return userService.getuserCards(token);
    }

}
