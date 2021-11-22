import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Geolocation } from '@ionic-native/geolocation/ngx';
import { Camera, CameraOptions } from '@ionic-native/camera/ngx';
import { PersonaService } from 'src/app/services/persona.service';
import { CardService } from 'src/app/services/card.service';
import { UiServiceService } from 'src/app/services/ui-service.service';

declare var window: any;

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {

  tempImages: string[] = [];
  cargandoGeo = false;

  cardInput: any = {
    expiredDate: '',
    status: ''
  };

  card: any;

  constructor(private router: Router,
    private usuarioService: PersonaService,
    private uiService: UiServiceService,
    private cardService: CardService
    ) {
    const objStateParams = this.router.getCurrentNavigation().extras.state;
    if(objStateParams && objStateParams['card']){
      this.card = objStateParams['card'];
      this.cardInput = objStateParams['card'];
    }
  }

  updatecard() {

    let person = JSON.parse(sessionStorage.getItem('USER') || '');

    console.log(this.cardInput)

    this.card['personId'] = person['idPerson'];
    this.card['status'] = 1;
    this.card['expiredDate'] = this.cardInput.expiredDate;
    this.card['status'] = Number(this.cardInput.status);

    this.cardService.updateCard(this.card).subscribe((resp) => {
      this.uiService.alertaInformativa('Se actualizó la tarjeta');
      console.log(this.card);
    }, (err) => {
      this.uiService.alertaInformativa('No se pudo actualizar el registro');
    });
  }

  logout() {
    this.usuarioService.logout();
  }
}
