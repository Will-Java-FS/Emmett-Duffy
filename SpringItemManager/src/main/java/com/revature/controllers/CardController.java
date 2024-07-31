package com.revature.controllers;

import com.revature.models.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @Autowired
    Card c;

    @PutMapping("/card")
    public Card setCardInfo() {
        c.setNumber(1);
        c.setName("Poliwhirl");
        c.setType("Water");
        c.setCondition("Fair");

        return c;
    }

    @GetMapping("/card")
    public Card getCardInfo() {
        System.out.println(c);
        return c;
    }


}
