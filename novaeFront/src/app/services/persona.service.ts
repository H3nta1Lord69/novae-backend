import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { NavController } from '@ionic/angular';

const URL = environment.url;

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  constructor(private http: HttpClient,
    private navCtrl: NavController) { }

  login(email: string, password: string) {

    const data = { email, password };

    return new Promise(resolve => {

      this.http.post(`${URL}person/login`, data)
        .subscribe(async resp => {
          if (resp) {
            sessionStorage.setItem('USER', JSON.stringify(resp));
            resolve(true);
          } else {
            resolve(false);
          }
        }, (err) => {
          resolve(false)
        });
    });
  }

  logout() {
    sessionStorage.clear();
    this.navCtrl.navigateRoot('/login', { animated: true });
  }

  register(usuario: any) {
    return new Promise(resolve => {
      this.http.post(`${URL}person/create`, usuario)
        .subscribe(async resp => {
          this.login(usuario['email'], usuario['password']).then((resLogin) => {
            console.log(resLogin);
            resolve(true);
          }, (err) => {
            resolve(false)
          });
        }, (err) => {
          resolve(false)
        });
    });
  }
}
