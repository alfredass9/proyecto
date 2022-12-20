import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Equipo } from '../interfaces/equipo';
import { EquipoDTO } from '../interfaces/equipo-dto';

@Injectable({
  providedIn: 'root'
})
export class EquipoService {
  private apiserverUrl=environment.apiBaseUrl;
  authUrl="http://localhost:8080/api/equipos/"


  constructor(private http: HttpClient) { }

  public getEquipos():Observable<Equipo[]>{
    return this.http.get<Equipo[]>(this.authUrl+'lista')
  }
  public getEquipoById(equipoId: number):Observable<Equipo>{
    return this.http.get<Equipo>(this.authUrl+'detalle/'+equipoId)
  }
  public getEquipoByNombre(nombreEquipo:string):Observable<Equipo>{
    return this.http.get<Equipo>(this.authUrl+'detalleNombre/'+nombreEquipo)
  }
  public crearEquipo(equipo:EquipoDTO,capitanId:number):Observable<Equipo>{
      return this.http.post<Equipo>(this.authUrl+'crear/'+capitanId,equipo)
  }
  public deleteEquipo(equipoid: number):Observable<void>{
    return this.http.delete<void>(`${this.apiserverUrl}/equipos/delete/${equipoid}`);
  }
  public añadirUsuario(nombreEquipo:string,equipo:Equipo,usuarioId:number):Observable<Equipo>{
    return this.http.put<Equipo>(this.authUrl+'nuevoUsuario/'+nombreEquipo+'/'+usuarioId,equipo)
  }
  public updateEquipo(equipo:Equipo):Observable<Equipo>{
    return this.http.put<Equipo>(`${this.apiserverUrl}/equipos/modificar`,equipo);

  }
}
