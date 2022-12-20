import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { ToastrService } from 'ngx-toastr';

import { Equipo } from '../interfaces/equipo';
import { Usuario } from '../interfaces/Usuario';
import { EquipoService } from '../services/equipo.service';
import { TokenService } from '../services/token.service';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-detalleequipo',
  templateUrl: './detalleequipo.component.html',
  styleUrls: ['./detalleequipo.component.css']
})
export class DetalleequipoComponent implements OnInit{
  equipo:Equipo
  isLogged=false
 
  nuevoJugador:string
  idJugador:number;
  nombreEquipo:string;
  jugadores=new Set<Usuario>()
  constructor(    private equipoService: EquipoService,
    private activatedRoute: ActivatedRoute,
    private userService:UsuarioService,
    private tokenService:TokenService,
    private toastr: ToastrService,
    private router: Router){}
  ngOnInit(){
    if (this.tokenService.getToken()){
      this.isLogged=true;
    }else{
      this.isLogged=false;
      this.volver();
    }
    const id =this.activatedRoute.snapshot.params['id'];
    console.log(id);
    let miID= new Number(id);
    this.tokenService.getToken
    this.equipoService.getEquipoById(id).subscribe(
      data=>{
        this.equipo=data
        this.jugadores=this.equipo.listaJugadores
        console.log(this.jugadores)
      },err=>{
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
          
        });
        this.router.navigate(['/home'])
      }

    )

  }
  public volver(): void {
    this.router.navigate(['/login']);
  }
  OnNuevo():void{
    this.nombreEquipo=this.equipo.nombreEquipo
  
    this.userService.getByNombreUsuario(this.nuevoJugador).subscribe(
      data=>{
        this.idJugador=data.id
        this.nuevoJugador
        this.equipoService.añadirUsuario(this.nombreEquipo,this.equipo,this.idJugador).subscribe(
          data => {
            this.toastr.success('Producto Creado', 'OK', {
              timeOut: 3000, positionClass: 'toast-top-center'
            });
            this.router.navigate(['/lista']);
            console.log(data)
          }
          ,err => {
            this.toastr.error(err.error.mensaje, 'Fail', {
              timeOut: 3000,  positionClass: 'toast-top-center',
            });
            // this.router.navigate(['/']);
          }
        )
      }
    )


  }
}
