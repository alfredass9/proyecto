import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Equipo } from '../interfaces/equipo';
import { EquipoService } from '../services/equipo.service';
import { TokenService } from '../services/token.service';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-listaequipo',
  templateUrl: './listaequipo.component.html',
  styleUrls: ['./listaequipo.component.css'],
})
export class ListaequipoComponent {
  isLogged = false;
  public equipos: Equipo[];
  errMSj: string;
  constructor(
    private tokenService: TokenService,
    private equipoService: EquipoService,
    private userService: UsuarioService,
    private router: Router
  ) {}
  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    }
    if ((this.isLogged = false)) {
      this.volver();
    }
    this.getEquipos();
  }
  public getEquipos(): void {
    this.equipoService.getEquipos().subscribe(
      (data) => {
        this.equipos = data;
        console.log(this.equipos);
      },
      (err) => {
        this.errMSj = err.error.menssage;
        console.log(err.error.menssage);
      }
    );
  }
  public volver(): void {
    this.router.navigate(['/login']);
  }
}
