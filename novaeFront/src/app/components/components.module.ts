import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { CardsComponent } from './cards/cards.component';

@NgModule({
  declarations: [
    CardsComponent
  ],
  exports: [
    CardsComponent
  ],
  imports: [
    CommonModule,
    IonicModule
  ]
})
export class ComponentsModule { }
