import { Injectable } from '@angular/core';
import { CanLoad } from '@angular/router';
import { Observable } from 'rxjs';
import { PersonaService } from '../services/persona.service';

@Injectable({
  providedIn: 'root'
})
export class UsuarioGuard implements CanLoad {

  constructor( private usuarioService: PersonaService ) {}

  canLoad(): Observable<boolean> | Promise<boolean> | boolean  {
    return true;
  }
}
