import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Equipo } from '../interfaces/equipo';
import { Liga } from '../interfaces/liga';
import { EquipoService } from '../services/equipo.service';
import { LigaService } from '../services/liga.service';
import { TokenService } from '../services/token.service';


@Component({
  selector: 'app-detalle-liga',
  templateUrl: './detalle-liga.component.html',
  styleUrls: ['./detalle-liga.component.css']
})
export class DetalleLigaComponent implements OnInit {
  liga:Liga
  isLogged=false
  nuevoEquipo:string
  equipoPuntos:string
  idEquipo:number;
  nombreLiga:string;
  equipos=new Array<Equipo>();
  resultado:string
  equipo:Equipo
  constructor(    private equipoService: EquipoService,
    private activatedRoute: ActivatedRoute,
    private ligaService:LigaService,
    private tokenService:TokenService,
    private toastr: ToastrService,
    private router: Router){}
  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }else{
      this.isLogged=false;
      this.volver();
    }
    const id =this.activatedRoute.snapshot.params['id'];
    this.ligaService.getLigaById(id).subscribe(
      data=>{
        this.liga=data
        console.log(data)
        this.equipos=this.liga.listaEquipos
        this.equipos.sort((a,b)=>a.misPuntos-b.misPuntos).reverse();
        console.log(this.equipos)
      },err=>{
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
          
        });
        this.router.navigate(['/home'])
      }
    )
  }
    OnNuevo():void{
    this.nombreLiga=this.liga.nombreLiga
  
    this.equipoService.getEquipoByNombre(this.nuevoEquipo).subscribe(
      data=>{
        console.log(data)
        this.idEquipo=data.id
        this.nuevoEquipo
        this.ligaService.añadirEquipo(this.nombreLiga,this.liga,this.idEquipo).subscribe(
          data => {
            this.toastr.success('Producto Creado', 'OK', {
               positionClass: 'toast-top-center'
            });
            this.router.navigate(['/detalleLiga/'+data.id]);
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
  OnSumar():void{
    this.resultado.toLocaleLowerCase();
    this.equipoService.getEquipoByNombre(this.equipoPuntos).subscribe(
      data=>{
      this.equipo=data
      console.log(data)
      if(this.resultado=='victoria'){
        this.equipo.misPuntos=this.equipo.misPuntos+3;
          this.equipoService.updateEquipo(this.equipo).subscribe(
            data => {
              this.toastr.success('Producto Creado', 'OK', {
                 positionClass: 'toast-top-center'
              });
              this.router.navigate(['/detalleLiga/'+this.liga.id]);
              console.log(data)
            }
            ,err => {
              this.toastr.error(err.error.mensaje, 'Fail', {
                timeOut: 3000,  positionClass: 'toast-top-center',
              });
              // this.router.navigate(['/']);
            }

          )
      }else{
              if(this.resultado=='empate'){
        this.nombreLiga=this.liga.nombreLiga
        this.equipo.misPuntos=this.equipo.misPuntos+1;
        this.equipoService.updateEquipo(this.equipo).subscribe(
          data => {
            this.toastr.success('Producto Creado', 'OK', {
               positionClass: 'toast-top-center'
            });
            this.router.navigate(['/detalleLiga/'+data.id]);
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
      }

      },err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        // this.router.navigate(['/']);
      }

    )
    

  }
  public volver(): void {
    this.router.navigate(['/login']);
  }
}
