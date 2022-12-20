import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login.component';
import { RegistroComponent } from './auth/registro.component';
import { DetalleequipoComponent } from './equipo/detalleequipo.component';
import { EditarequipoComponent } from './equipo/editarequipo.component';
import { ListaequipoComponent } from './equipo/listaequipo.component';
import { NuevoequipoComponent } from './equipo/nuevoequipo.component';



import { HomeComponent } from './home/home.component';
import { DetalleLigaComponent } from './liga/detalle-liga.component';
import { ListaLigaComponent } from './liga/lista-liga.component';
import { NuevaLigaComponent } from './liga/nueva-liga.component';
import { PerfilUsuarioComponent } from './perfil-usuario/perfil-usuario.component';
import { UserAdminComponent } from './user-admin/user-admin.component';
const routes: Routes = [
  {path:'',component:HomeComponent}, 
  {path:'login',component:LoginComponent} ,
  {path:'registro',component:RegistroComponent} ,
  {path:'user-admin',component:UserAdminComponent} ,
  {path:'home',component:HomeComponent},
  {path:'miperfil',component:PerfilUsuarioComponent },
  {path:'registroequipo',component:NuevoequipoComponent},
  {path:'detalle/:id',component:DetalleequipoComponent},
  {path:'lista',component:ListaequipoComponent},
  {path:'editarequipo',component:EditarequipoComponent},
  {path:'listaLiga',component:ListaLigaComponent},
  {path:'detalleliga/:id',component:DetalleLigaComponent},
  {path:'nuevaLiga',component:NuevaLigaComponent}
  //{path:'',component:} ,

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
