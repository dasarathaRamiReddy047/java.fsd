import { LoginService } from 'src/app/services/login/login.service';
import { Component, OnInit } from '@angular/core';
import { LoginAuthService } from 'src/app/shared/login/login-auth.service';
import { Router } from '@angular/router';
import { AdminAuthServiceService } from 'src/app/authService/admin-auth-service.service';
import { Admin } from 'mongodb';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css'],
})
export class UserLoginComponent implements OnInit {
  constructor(
    private ls: LoginService,
    private loginAuth: LoginAuthService,
    private adminAuth: AdminAuthServiceService,
    private routes: Router
  ) {}

  details: any;

  getLogindetails() {
    this.details = this.ls.loginDetails;
  }

  ngOnInit(): void {
    this.getLogindetails();
  }

  logout() {
    console.log(this.details.name);
    if (this.details.name === 'admin') {
      this.adminAuth.isAdminLoggined = false;
      this.loginAuth.isUserLogined = false;
      this.ls.loginDetails = '';
      this.getLogindetails();
      this.routes.navigate(['/adminlogin']);
    } else {
      this.loginAuth.isUserLogined = false;
      this.routes.navigate(['/login']);
      this.ls.loginDetails = '';
      this.getLogindetails();
    }
  }
}
