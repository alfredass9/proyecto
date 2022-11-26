import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { UsuarioService } from './services/usuario.service';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGuard } from './guards/auth.guard'; 
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent
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
