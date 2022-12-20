import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { UsuarioService } from './services/usuario.service';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserAdminComponent } from './user-admin/user-admin.component';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './auth/login.component';
import { RegistroComponent } from './auth/registro.component';
import { PerfilUsuarioComponent } from './perfil-usuario/perfil-usuario.component'
import { interceptorProvider } from './interceptors/prod-interceptor.service';
import { DetalleequipoComponent } from './equipo/detalleequipo.component';
import { EditarequipoComponent } from './equipo/editarequipo.component';
import { ListaequipoComponent } from './equipo/listaequipo.component';
import { NuevoequipoComponent } from './equipo/nuevoequipo.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { ListaLigaComponent } from './liga/lista-liga.component';
import { DetalleLigaComponent } from './liga/detalle-liga.component';
import { NuevaLigaComponent } from './liga/nueva-liga.component';
@NgModule({
  declarations: [
    AppComponent,
    UserAdminComponent,
    MenuComponent,
    HomeComponent,
    LoginComponent,
    RegistroComponent,
    PerfilUsuarioComponent,
    NuevoequipoComponent,
    ListaequipoComponent,
    EditarequipoComponent,
    DetalleequipoComponent,
    ListaLigaComponent,
    DetalleLigaComponent,
    NuevaLigaComponent,

   
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,    
    ReactiveFormsModule,   
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
       
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
