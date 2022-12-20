import { Component, OnInit } from '@angular/core';
import { Usuario } from '../interfaces/Usuario';
import { UsuarioService } from '../services/usuario.service';
import { TokenService } from '../services/token.service';
import { Router } from '@angular/router';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-perfil-usuario',
  templateUrl: './perfil-usuario.component.html',
  styleUrls: ['./perfil-usuario.component.css']
})
export class PerfilUsuarioComponent implements OnInit {
  public usuario:Usuario;
  isLogged=false;
  nombreUsuario:string="";
  constructor(private usuarioService: UsuarioService,private tokenService:TokenService,
   private router:Router) { }

  ngOnInit(): void {
    
    if (this.tokenService.getToken()){
      this.isLogged=true;
      this.nombreUsuario=this.tokenService.getUserName();
      console.log(this.tokenService.roles);
      this.getMiUsuario(this.tokenService.getUserName());
    }else{
      this.isLogged=false;
    }
    
  }
  public getMiUsuario(nombreUsuario:string):void{
      console.log(this.nombreUsuario);
    this.usuarioService.getByNombreUsuario(this.nombreUsuario).subscribe(
      data=>{
        console.log(data)
        this.usuario=data;
      },
      err=>{
        console.log("aqui me quedo")
        this.volver();
      }
    );
    
  }
  public volver(): void {
    this.router.navigate(['/login']);
  }

}
