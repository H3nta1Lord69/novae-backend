package com.novae.back.rest;

import com.novae.back.model.Card;
import com.novae.back.model.Person;
import com.novae.back.security.Encrypt;
import com.novae.back.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/person")
public class PersonRestController {

    @Autowired
    private IPersonService iPersonService;

    @GetMapping("/get-person")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPersons() {
        return iPersonService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
        if (iPersonService.findPerson(person) == null) {
            iPersonService.save(person);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginPerson(@RequestBody Person person) {
        Encrypt encrypt = new Encrypt();

        Person personDb = iPersonService.checkPersonLogin(person);

        if (personDb != null) {
            try {
                List<Card> cardsReturn = new ArrayList<>();
                List<Card> cards = personDb.getCard();
                System.out.println(cards);
                for (Card card : cards) {
                    String numberCard = encrypt.decrypt(card.getNumCard());
                    System.out.println(numberCard);
                    card.setNumCard(numberCard);
                    cardsReturn.add(card);
                }
                personDb.setCard(cardsReturn);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ResponseEntity<>(personDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/find-person")
    public ResponseEntity<?> findPerson(@RequestBody Person person) {
        Person personDb = iPersonService.findPersonByEmail(person);
        if (personDb != null) {
            return new ResponseEntity<>(personDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable(value = "id") Long id, @RequestBody Person person) {
        Person personDb = null;
        personDb = iPersonService.findById(id);
        if (personDb != null) {
            personDb.setNamePerson(person.getNamePerson());
            personDb.setEmail(person.getEmail());
            personDb.setPassword(person.getPassword());
            iPersonService.updatePerson(personDb);
            return new ResponseEntity<>(personDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable(value = "id") Long id) {
        iPersonService.deletePerson(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/are-you-sure-of-this")
    public ResponseEntity<Void> deleteAllPerson() {
        iPersonService.deleteAllPerson();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
