
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { PersonaService } from './persona.service';
import * as Rx from 'rxjs';

const URL = environment.url;

@Injectable({
    providedIn: 'root'
})
export class CardService {

    userAddCard: Rx.Subject<any> = new Rx.Subject<any>();

    constructor(private http: HttpClient) {

    }

    createCard(request: any) {
        return new Observable((observer) => {
            this.http.post(`${URL}card/create`, request).subscribe(resp => {
                observer.next(resp);
                observer.complete();
            }, (err) => {
                observer.error(err);
                observer.complete();
            });
        });
    }

    updateCard(card) {
        console.log(card);
        return new Observable((observer) => {
            this.http.put(`${URL}card/update/${card.idCard}`, { ...card }).subscribe(resp => {
                console.log(resp);
                observer.next(resp);
                observer.complete();
            }, (err) => {
                observer.error(err);
                observer.complete();
            });
        });
    }

    deleteCard(idCard) {
        return this.http.delete(`${URL}card/delete/${idCard}`);
    }

    getCards(email: string, password: string) {
        const data = { email, password };
        return new Promise(resolve => {

            this.http.post(`${URL}person/login`, data)
                .subscribe(async resp => {
                    if (resp) {
                        sessionStorage.setItem('USER', JSON.stringify(resp));
                        resolve(resp);
                    } else {
                        resolve(resp);
                    }

                }, (err) => {
                    resolve(err)
                });
        });
    }

    notifyGetCards() {
        this.userAddCard.next(true);
    }
}