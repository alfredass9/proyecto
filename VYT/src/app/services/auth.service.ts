import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtDTO } from '../interfaces/jwt-dto';
import { LoginUsusario } from '../interfaces/login-usuario';
import { NuevoUsuario } from '../interfaces/nuevo-usuario';
import { Usuario } from '../interfaces/Usuario';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  logout: any;
  authUrl="http://localhost:8080/api/auth/"
  constructor(private httpClient:HttpClient) { }
  public nuevo(nuevoUsuario: NuevoUsuario):Observable<any>{
      return this.httpClient.post<any>(this.authUrl+'nuevo',nuevoUsuario)
  }
  public login(loginUsuario:LoginUsusario):Observable<JwtDTO>{
    return this.httpClient.post<JwtDTO>(this.authUrl+'login',loginUsuario)
}

}
