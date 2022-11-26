import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, CanDeactivate, CanLoad, CanMatch, Route, RouterStateSnapshot, UrlSegment, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';   
import { ILogin} from 'src/app/interfaces/login';
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanActivateChild, CanDeactivate<unknown>, CanLoad, CanMatch {
  constructor(private router: Router) { } 
    canActivate(
      route: ActivatedRouteSnapshot,
      state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
        if (this.isLoggedIn()) {      
          return true;      
          }      
          // navigate to login page as user is not authenticated      
       this.router.navigate(['/login']);      
    return false;      
    }
    public isLoggedIn(): boolean {      
      let status = false;      
      if (localStorage.getItem('isLoggedIn') == "true") {      
         status = true;      
      }
        else {      
         status = false;      
         }      
      return status;      
      }    
      logout() :void {    
        localStorage.setItem('isLoggedIn','false');    
        localStorage.removeItem('token');    
        }    
    canActivateChild(
      childRoute: ActivatedRouteSnapshot,
      state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      return true;
    }
    canDeactivate(
      component: unknown,
      currentRoute: ActivatedRouteSnapshot,
      currentState: RouterStateSnapshot,
      nextState?: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      return true;
    }
    canMatch(
      route: Route,
      segments: UrlSegment[]): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      return true;
    }canLoad(
      route: Route,
      segments: UrlSegment[]): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      return true;
    }
}
