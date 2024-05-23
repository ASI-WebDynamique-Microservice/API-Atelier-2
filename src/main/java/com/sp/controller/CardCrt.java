package com.sp.controller;


import com.sp.DTO.CardRequestDTO;
import com.sp.Entity.Card;
import com.sp.Service.CardService;
import com.sp.Service.GenerateService;
import com.sp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardCrt {

    @Autowired
    private GenerateService generateService;
    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public List<Card> cards(@RequestHeader("TOKEN") String token, @RequestParam(required = false) String login, @RequestParam(required = false) Boolean isForSell) {
        userService.islogin(token);
        if(login == null && isForSell == null)
        {
            return cardService.getAllCards();
        }
        else if(login != null && isForSell == null)
        {
            return userService.getUserCardsByLogin(login);
        }
        else if (login == null && isForSell)
        {
            return cardService.getIsForSellCards();
        }
        else
        {
            return cardService.getUserandIsForSellCards(isForSell, userService.getUserByLogin(login));
        }
    }

    @RequestMapping(value = {"/cards"}, method = RequestMethod.POST)
    public ResponseEntity<Void>  creat(@RequestHeader("TOKEN") String token, @RequestBody CardRequestDTO cardRequestDTO) {
        userService.islogin(token);
        cardService.addCard(cardRequestDTO);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public ResponseEntity<Void>  test() {
        generateService.createAndSaveInitialCards();
        return ResponseEntity.ok().build();
    }

}