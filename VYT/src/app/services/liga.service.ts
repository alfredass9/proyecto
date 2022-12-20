import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Liga } from '../interfaces/liga';
import { LigaDTO } from '../interfaces/liga-dto';

@Injectable({
  providedIn: 'root'
})
export class LigaService {
  authUrl="http://localhost:8080/api/ligas/"
  private apiserverUrl=environment.apiBaseUrl;
  constructor(private http:HttpClient) { }
  public getLigas():Observable<Liga[]>{
    return this.http.get<Liga[]>(this.authUrl+'lista')
  }
  public getLigaById(LigaId: number):Observable<Liga>{
    return this.http.get<Liga>(this.authUrl+'detalle/'+LigaId)
  }
  public crearLiga(Liga:LigaDTO,):Observable<Liga>{
      return this.http.post<Liga>(this.authUrl+'crear/',Liga)
  }
  public deleteLiga(Ligaid: number):Observable<void>{
    return this.http.delete<void>(`${this.apiserverUrl}/ligas/delete/${Ligaid}`);
  }
  public añadirEquipo(nombreLiga:string,Liga:Liga,equipoId:number):Observable<Liga>{
    return this.http.put<Liga>(this.authUrl+'nuevoEquipo/'+nombreLiga+'/'+equipoId,Liga)
  }
  public updateLiga(Liga:Liga):Observable<Liga>{
    return this.http.put<Liga>(`${this.apiserverUrl}/ligas/modificar`,Liga);
  }
  public añadirPuntos(nombreLiga:string,idequipo:number,resultado:string,liga:Liga){
    return this.http.put<Liga>(this.authUrl+'sumarPuntos/'+nombreLiga+'/'+idequipo+'/'+resultado,liga)
  }

}
