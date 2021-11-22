import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CardService } from '../../services/card.service';
import { PersonaService } from '../../services/persona.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.scss']
})
export class CardsComponent implements OnInit {

  @Input() cardsArray: any;

  constructor(private cardService: CardService,
    private personService: PersonaService,
    private router: Router) {
      console.log('load');
      this.cardService.userAddCard.subscribe(() => {
        this.getCards();
      });
    }

  ngOnInit() {
    this.getCards();
  }

  getCards() {
    let person = JSON.parse(sessionStorage.getItem('USER') || '');
    this.cardService.getCards(person['email'], person['password']).then((resp) => {
      console.log(resp);
      this.cardsArray = resp['card'];
    }, (err) => {
      console.error(err);
    });
  }

  deleteCard(idCard) {
    this.cardService.deleteCard(idCard).subscribe((resp) => {
      this.getCards();
    }, (err) => {
      console.error(err);
    });
  }

  editCard(card) {
    this.router.navigateByUrl('main/tabs/tab2', { state: { card: card } });
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
}
