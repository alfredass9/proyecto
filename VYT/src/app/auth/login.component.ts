import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUsusario } from '../interfaces/login-usuario';
import { AuthService } from '../services/auth.service';
import { TokenService } from '../services/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLogged=false;
  isLoginFalse=false;
  loginUsuario:LoginUsusario;
  nombreUsuario:string;
  password :string;
  roles:string[]=[];
  errMSj:string;
  constructor(
    private tokenService:TokenService,
    private authService:AuthService,
    private router:Router
  ) { }

  ngOnInit(): void {
    if (this.tokenService.getToken()){
      this.isLogged=true;
      this.isLoginFalse=false;
      this.roles=this.tokenService.getAuthorities();
    }
  }
  onLogin():void{
      this.loginUsuario= new LoginUsusario(this.nombreUsuario,this.password);
      this.authService.login(this.loginUsuario).subscribe(
        data=>{
        this.isLogged=true;
        this.isLoginFalse=false;

        this.tokenService.setToken(data.token);
        this.tokenService.setUserName(data.nombreUsuario);
        this.tokenService.setAuthorities(data.authorities);
        this.roles=data.authorities;
        this.router.navigate([''])
      },err=>{
        this.isLogged=false;
        this.isLoginFalse=true;
        this.errMSj=err.error.menssage
        console.log(err.error.menssage);
      }
      )
  }

}
