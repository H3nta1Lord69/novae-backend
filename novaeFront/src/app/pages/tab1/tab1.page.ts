import { Component, OnInit } from '@angular/core';
import { CardService } from '../../services/card.service';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit {

  habilitado = true;

  cardsArray: any;

  constructor(private cardService: CardService) { }

  ngOnInit() {
    console.log('get cards');
    this.getCards();
  }

  getCards() {
    let person = JSON.parse(sessionStorage.getItem('USER') || '');
    this.cardService.getCards(person['email'], person['password']).then((resp) => {
      console.log(resp);
      console.log(resp['card']);
      this.cardsArray = resp['card'];
    }, (err) => {
      console.error(err);
    });
  }

  deleteCard(idCard) {
    this.cardService.deleteCard(idCard).subscribe((resp) => {
      console.log(resp);
    }, (err) => {
      console.error(err);
    });
  }

  getBinOfCardNumber(cardNumber: string): string {
    let product = '';
    if (cardNumber) {
      if (cardNumber.length >= 4) {
        product = cardNumber.toString().substring(cardNumber.toString().length - 4);
      }
    }
    return product;
  }

  editCard(card) {
    this.cardService.updateCard(card).subscribe((resp) => {
      console.log(resp);
    }, (err) => {
      console.error(err);
    });
  }
}
