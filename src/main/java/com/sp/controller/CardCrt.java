package com.sp.controller;


import com.sp.DTO.InfoDTO;
import com.sp.DTO.UserDTO;
import com.sp.Service.MarketService;
import com.sp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardCrt {
    @Autowired
    private UserService userService;
    @Autowired
    private MarketService marketService;


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
}
