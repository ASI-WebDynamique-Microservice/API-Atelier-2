package com.sp.controller;

import com.sp.DTO.CardFormDTO;
import com.sp.Entity.Card;
import com.sp.Repository.CardRepository;
import com.sp.Service.CardService;
import com.sp.Service.Manager.CardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class RequestCrt {
    @Autowired
    private CardService cardService;


    private static String messageLocal = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("messageLocal", messageLocal);
        return "index";
    }

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public String cards(Model model) {
        List<Card> cards = cardService.getAllCards();
        model.addAttribute("cardList", cards);
        return "showCartes";
    }

    @RequestMapping(value = {"/addCard"}, method = RequestMethod.GET)
    public String creat(Model model) {
        CardFormDTO cardForm = new CardFormDTO();
        model.addAttribute("cardForm", cardForm);
        return "creat";
    }
}