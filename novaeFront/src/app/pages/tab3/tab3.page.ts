import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../../services/persona.service';
import { UiServiceService } from 'src/app/services/ui-service.service';
import { CardService } from '../../services/card.service';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page implements OnInit {

  card: any = {
    numCard: "",
    nameCard: "",
    cvv: "",
    expiredDate: "",
    franchise: "",
    status: "",
    personId: ""
  };

  constructor(private personaService: PersonaService,
    private uiService: UiServiceService,
    private cardService: CardService,
    private navCtrl: NavController
  ) { }

  ngOnInit() {
  }

  createcard() {

    let person = JSON.parse(sessionStorage.getItem('USER') || '');

    this.card['franchise'] = 'VISA';
    this.card['personId'] = person['idPerson'];
    this.card['status'] = 1;

      this.cardService.createCard(this.card).subscribe((resp) => {
        this.card = {
          numCard: "",
          nameCard: "",
          cvv: "",
          expiredDate: "",
          franchise: "",
          status: "",
          personId: ""
        };
        this.uiService.alertaInformativa('Se agrego la tarjeta');
        this.cardService.notifyGetCards();
      }, (err) => {
        this.uiService.alertaInformativa('No se pudo agregar la tarjeta.');
      });
  }

  logout() {
    this.personaService.logout();
  }
}
