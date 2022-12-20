import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LigaDTO } from '../interfaces/liga-dto';
import { EquipoService } from '../services/equipo.service';
import { LigaService } from '../services/liga.service';
import { TokenService } from '../services/token.service';

@Component({
  selector: 'app-nueva-liga',
  templateUrl: './nueva-liga.component.html',
  styleUrls: ['./nueva-liga.component.css']
})
export class NuevaLigaComponent implements OnInit {
  constructor(private tokenService: TokenService,
    private equipoService:EquipoService,
    private ligaService:LigaService,
    private router: Router){}
    isLogged = false;
    liga:LigaDTO;
    nombreLiga:string;
    logo:string;
    direccion:string;
    iscreated=false;
    errMSj:string;
  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged=true;
    }
    if(this.isLogged==false){
      this.volver()
    }
  }
  onCreate(){
    this.liga=new LigaDTO(this.nombreLiga,this.direccion,this.logo);
   
    this.ligaService.crearLiga(this.liga).subscribe(
        data=>{
          this.iscreated=true
          console.log(data);
          this.router.navigate(['/listaLiga'])
        },err=>{
          this.isLogged=false;
          this.iscreated=true;
          this.errMSj=err.error.menssage
          console.log(err.error.menssage);
        }
    )
   }
  public volver(): void {
    this.router.navigate(['/login']);
  }
}
