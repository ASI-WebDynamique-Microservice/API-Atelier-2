package com.sp.controller;


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
    public ResponseEntity<Void> buyCard(@RequestHeader ("TOKEN") String token, @PathVariable int id_card)
    {

        marketService.buyCard(token,id_card);
        return ResponseEntity.ok().build();
    }
}
