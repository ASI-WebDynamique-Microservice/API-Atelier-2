package com.sp.controller;


import com.sp.DTO.Card.CardRequestDTO;
import com.sp.DTO.Card.CardResponceDTO;
import com.sp.Entity.Card;
import com.sp.Service.CardService;
import com.sp.Service.GenerateService;
import com.sp.DTO.InfoDTO;
import com.sp.DTO.UserDTO;
import com.sp.Service.MarketService;
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
    @Autowired
    private MarketService marketService;


    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public List<CardResponceDTO> cards(@RequestHeader("TOKEN") String token, @RequestParam(required = false) String login, @RequestParam(required = false) Boolean isForSell) {
        userService.islogin(token);
        if(login == null && isForSell == null)
        {
            return cardService.getAllCardReponceDTOList();
        }
        else if(login != null && isForSell == null)
        {
            return cardService.getUserCardReponceDTOList(userService.getUserCardsByLogin(login));
        }
        else if (login == null && isForSell)
        {
            return cardService.getIsForSellCards(isForSell);
        }
        else
        {
            return cardService.getUserandIsForSellCards(isForSell, userService.getUserByLogin(login));
        }
    }
    @RequestMapping(value = {"/buyCard/{id_card}"}, method = RequestMethod.GET)
    public InfoDTO buyCard(@RequestHeader("TOKEN") String token, @PathVariable long id_card)
    {

        return new InfoDTO( marketService.buyCard(token,id_card));
    }
    @RequestMapping(value = {"/sellCard/{id_card}"}, method = RequestMethod.GET)
    public InfoDTO sellCard(@RequestHeader("TOKEN") String token, @PathVariable long id_card)
    {
        return new InfoDTO(marketService.sellCard(token,id_card));
    }
    @RequestMapping(value = {"/cards"}, method = RequestMethod.POST)
    public ResponseEntity<Void>  creat(@RequestHeader("TOKEN") String token, @RequestBody CardRequestDTO cardRequestDTO) {
        userService.islogin(token);
        cardService.addCard(cardRequestDTO);
        return ResponseEntity.ok().build();
    }
}




