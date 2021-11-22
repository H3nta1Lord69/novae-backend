package com.novae.back.rest;

import com.novae.back.model.Card;
import com.novae.back.model.Person;
import com.novae.back.security.Encrypt;
import com.novae.back.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/card")
public class CardRestController {

    @Autowired
    private ICardService cardService;

    @GetMapping("/get-card")
    @ResponseStatus(HttpStatus.OK)
    public List<Card> getCards() {
        Encrypt encrypt = new Encrypt();
        List<Card> cardList = new ArrayList<>();
        List<Card> cards = cardService.findAll();
        for (Card card : cards) {
            try {
                String passCifra = card.getNumCard();
                String passDecrypt = encrypt.decrypt(passCifra);
                card.setNumCard(passDecrypt);
                cardList.add(card);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cardList;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> addCard(@RequestBody Card card) {
        if(cardService.findCard(card) == null) {
            Encrypt encrypt = new Encrypt();
            card.setNumCard(encrypt.encrypt(card.getNumCard()));
            cardService.save(card);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/find-person")
    public ResponseEntity<?> findCardPerson(@RequestBody Person person) {
        List<Card> cardList = cardService.getPersonCards(person.getIdPerson());
        if(cardList != null && cardList.size() != 0) {
            return new ResponseEntity<>(cardList, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/find-franchise")
    public ResponseEntity<?> findFranchise(@RequestBody Card card) {
        Card cardDb = cardService.findByFranchise(card);
        if(cardDb != null) {
            return new ResponseEntity<>(cardDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCard(@PathVariable (value = "id") Long id, @RequestBody Card card) {
        Card cardDb = null;
        cardDb = cardService.findById(id);
        if(cardDb != null) {
            cardDb.setStatus(card.getStatus());
            cardDb.setExpiredDate(card.getExpiredDate());
            cardService.updateCard(cardDb);
            return new ResponseEntity<>(cardDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable(value = "id") Long id) {
        cardService.deleteCard(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/why-will-you-do-this")
    public ResponseEntity<Void> deleteAllCard() {
        cardService.deleteAllCard();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
/*
    @PutMapping("/update_sql")
    public ResponseEntity<?> updateCardSql(@RequestBody Card card) {
        Card cardDb = null;
        cardDb = cardService.findById(id);
        if(cardDb != null)
        {
            cardDb.setStatus(card.getStatus());
            cardDb.setExpiredDate(card.getExpiredDate());
            cardService.updateCard(cardDb);
            return new ResponseEntity<>(cardDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
 */



}
