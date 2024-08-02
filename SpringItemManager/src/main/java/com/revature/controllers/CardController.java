package com.revature.controllers;

import com.revature.models.Card;
import com.revature.repositories.CardRepo;
import com.revature.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

   public CardService cardService;

   public CardRepo cardRepo;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

   @PostMapping("card")
   public ResponseEntity<Card> createCard(@RequestBody Card card)
   {

       System.out.println(card.getName());
       Card createdCard = cardService.createCard(card);

       return ResponseEntity.ok(card);

   }

   @GetMapping("card")
   public List<Card> getAllCards()
    {

       return cardService.getAllCards();
    }

    @GetMapping("card/{number}")
    public ResponseEntity<Card> getCardById(@PathVariable Integer number)
    {
        Card card = cardService.getCardById(number);
        if(card == null) {

            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(card);
    }

    @PatchMapping("card/{number}")
    public ResponseEntity<?> updateCard(@PathVariable Integer number, @RequestBody Card cardUpdate)
    {

        try{

            if(cardUpdate.getName().trim().isEmpty() || cardUpdate.getName().length() > 250)
            {

                return ResponseEntity.badRequest().body("Name cannot be empty");

            }

            Card cardUpdated = cardService.updateCard(number, cardUpdate);

            if(cardUpdated == null)
            {
                return ResponseEntity.badRequest().body("Could not update card");
            }

            return ResponseEntity.ok(1);


        } catch (Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }



}
