import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { UsuarioService } from './services/usuario.service';

import { AuthGuard } from './guards/auth.guard'; 
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserAdminComponent } from './user-admin/user-admin.component';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './auth/login.component';
import { RegistroComponent } from './auth/registro.component'
@NgModule({
  declarations: [
    AppComponent,
    UserAdminComponent,
    MenuComponent,
    HomeComponent,
    LoginComponent,
    RegistroComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,    
    ReactiveFormsModule  
    
  ],
  providers: [UsuarioService,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
