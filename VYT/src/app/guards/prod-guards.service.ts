import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { TokenService } from '../services/token.service';
import decode from 'jwt-decode';
@Injectable({
  providedIn: 'root'
})
export class ProdGuardsService implements CanActivate{
  adminRol: string;
  capitanRol:string;
  constructor(   
    private tokenService: TokenService,
    private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean  {
    //const expectedRol=route.data.expectedRol;
    const roles=this.tokenService.getAuthorities();
    this.adminRol='user';
    this.capitanRol='user';
    roles.forEach(rol => {
      if(rol==='ROLE_ADMIN'){
        this.adminRol='admin';
      }
      if(rol==='ROLE_CAPITAN'){
        this.capitanRol='capitan';
      }
    });
   /* if(!this.tokenService.getToken()||expectedRol.indexof(this.adminRol)===-1||expectedRol.indexof(this.capitanRol)===-1){
      this.router.navigate(['/']);
      return false
    }*/
      return true
  }
  
}
