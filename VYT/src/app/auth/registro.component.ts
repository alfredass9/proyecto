import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NuevoUsuario } from '../interfaces/nuevo-usuario';
import { Usuario } from '../interfaces/Usuario';
import { AuthService } from '../services/auth.service';
import { TokenService } from '../services/token.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  nuevoUsuario: NuevoUsuario;
    name:string;
    nombreUsuario:string;
    email:string;
    password:string;
    imageUrl:string;
    posicion:string;
    errMsj: string;
  isLogged = false;

  constructor(    
    private tokenService: TokenService,
    private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }
    if(this.isLogged==true){
      this.volver()
    }
  }
  public volver(): void {
    this.router.navigate(['/home']);
  }
  onRegister(){
    this.nuevoUsuario=new NuevoUsuario(this.name,this.nombreUsuario,this.email,this.password,this.imageUrl,this.posicion)
    this.authService.nuevo(this.nuevoUsuario).subscribe(
      data=>{
        console.log(data)
        this.router.navigate(['/home']);
      },
      err=>{
        this.errMsj = err.error.mensaje;
        
      }

    )
  }
}
