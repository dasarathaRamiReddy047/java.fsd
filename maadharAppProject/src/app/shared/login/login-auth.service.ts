import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  Router,
} from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class LoginAuthService {
  constructor(private router: Router) {}

  isUserLogined: boolean = false;

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    if (this.isUserLogined) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}
