import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Liga } from '../interfaces/liga';
import { EquipoService } from '../services/equipo.service';
import { LigaService } from '../services/liga.service';
import { TokenService } from '../services/token.service';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-lista-liga',
  templateUrl: './lista-liga.component.html',
  styleUrls: ['./lista-liga.component.css']
})
export class ListaLigaComponent implements OnInit {
  isLogged=true
  public liga:Liga[];
  errMSj:string;
  constructor(private tokenService: TokenService,
    private equipoService:EquipoService,
    private ligaService:LigaService,
    private router: Router){}
  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }
    if(this.isLogged=false){
      this.volver()
    }
    this.getLigas();
  }
  public getLigas():void{
    this.ligaService.getLigas().subscribe(
      data=>{
        this.liga=data
        
      },err=>{
        this.errMSj=err.error.menssage
        console.log(err.error.menssage);
      }
    )
  }
  public volver(): void {
    this.router.navigate(['/login']);
  }

}
