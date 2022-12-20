import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EquipoDTO } from '../interfaces/equipo-dto';
import { Usuario } from '../interfaces/Usuario';
import { EquipoService } from '../services/equipo.service';
import { TokenService } from '../services/token.service';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-nuevoequipo',
  templateUrl: './nuevoequipo.component.html',
  styleUrls: ['./nuevoequipo.component.css']
})
export class NuevoequipoComponent implements OnInit {
  constructor(private tokenService: TokenService,
    private equipoService:EquipoService,
    private userService:UsuarioService,
    private router: Router) { }
    isLogged = false;
    equipo:EquipoDTO;
    nombreEquipo:string;
    logo:string;
    usuario:Usuario;
    iscreated=false;
    errMSj:string;

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }
    if(this.isLogged==false){
      this.volver()
    }
    this.userService.getByNombreUsuario(this.tokenService.getUserName()).subscribe(
      data=>{
        this.usuario=data;
        console.log(data)
      }

    )
  }
   onCreate(){
    this.equipo=new EquipoDTO(this.nombreEquipo,this.logo);
   
    this.equipoService.crearEquipo(this.equipo,this.usuario.id).subscribe(
        data=>{
          this.iscreated=true
          console.log(data);
          this.router.navigate(['/lista'])
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
