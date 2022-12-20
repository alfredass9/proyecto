import { Injectable } from '@angular/core';
import {  Observable} from "rxjs";
import { Usuario } from '../interfaces/Usuario';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiserverUrl=environment.apiBaseUrl;
  authUrl="http://localhost:8080/api/user/"
  constructor(private http: HttpClient) { }

  public getUser(): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(`${this.apiserverUrl}/user/all`);
  }
  public addUsuario(usuario: Usuario):Observable<Usuario>{
    return this.http.post<Usuario>(`${this.apiserverUrl}/user/add`,usuario);
  }
  public updateUsuario(usuario:Usuario):Observable<Usuario>{
    return this.http.put<Usuario>(`${this.apiserverUrl}/user/update`,usuario);
    console.log(this.apiserverUrl);
  }
  public deleteUsuario(usuarioid: number):Observable<void>{
    return this.http.delete<void>(`${this.apiserverUrl}/user/delete/${usuarioid}`);
  }
  public getByNombreUsuario(nombreUsuario:string):Observable<Usuario>{
    return this.http.get<Usuario>(`${this.apiserverUrl}/user/findUser/${nombreUsuario}`) ;
}
}
