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
export class AdminAuthServiceService implements CanActivate {
  constructor(private router: Router) {}

  isAdminLoggined: boolean = false;

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    if (this.isAdminLoggined) {
      return true;
    } else {
      this.router.navigate(['/adminlogin']);
      return false;
    }
  }
}
