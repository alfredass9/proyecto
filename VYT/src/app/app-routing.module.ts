import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login.component';
import { RegistroComponent } from './auth/registro.component';


import { HomeComponent } from './home/home.component';
import { UserAdminComponent } from './user-admin/user-admin.component';
const routes: Routes = [
  {path:'',component:HomeComponent}, 
  {path:'login',component:LoginComponent} ,
  {path:'registro',component:RegistroComponent} ,
  {path:'user-admin',component:UserAdminComponent} ,
  //{path:'',component:} ,

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
