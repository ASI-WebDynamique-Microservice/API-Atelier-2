package com.sp.Service.Manager;

import com.sp.Entity.Card;
import com.sp.Entity.User;
import com.sp.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class CardManager {
    @Autowired
    private CardRepository cardRepository;



}
