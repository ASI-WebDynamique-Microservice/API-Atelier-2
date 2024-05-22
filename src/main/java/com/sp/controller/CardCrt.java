package com.sp.controller;


import com.sp.DTO.CardRequestDTO;
import com.sp.Entity.Card;
import com.sp.Service.CardService;
import com.sp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardCrt {

    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public List<Card> cards(@RequestHeader("TOKEN") String token) {
        userService.islogin(token);
        return cardService.getAllCards();
    }

    @RequestMapping(value = {"/addCard"}, method = RequestMethod.GET)
    public ResponseEntity<Void>  creat(@RequestHeader("TOKEN") String token, @RequestBody CardRequestDTO cardRequestDTO) {
        userService.islogin(token);
        cardService.addCard(cardRequestDTO);
        return ResponseEntity.ok().build();
    }

}