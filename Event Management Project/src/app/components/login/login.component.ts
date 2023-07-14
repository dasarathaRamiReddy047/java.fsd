import { Component } from '@angular/core';
import { EventService } from '../eventService/event.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  constructor(
    private es: EventService,
    private http: HttpClient,
    private router: Router
  ) {}
  username: string = '';
  password: string = '';

  url = 'http://localhost:3000/user';

  istrue = false;

  loginUser: any;
  istruemsg: boolean = true;

  login() {
    this.http.get(this.url).subscribe((res) => {
      this.loginUser = res;
      for (let i of this.loginUser) {
        if (i.username === this.username && i.password === this.password) {
          this.istrue = true;
          this.es.isAuth = true;
          this.istruemsg = true;

          this.router.navigate(['/home']);
        } else {
          this.istruemsg = false;
          this.es.isAuth = false;
          this.istrue = false;
        }
      }
    });
  }

  ischange = false;
  changePassword() {
    this.ischange = true;
  }

  model() {
    this.ischange = false;
  }

  changeusername: string = '';
  changepassword: string = '';

  isusercorrect: boolean = false;

  userurl = 'http://localhost:3000/user/1';

  ischangeRouter() {
    if (this.isusercorrect) {
      this.router.navigate(['/home']);
    }
  }

  passwordChange: boolean = false;

  userCheck() {
    this.http.get(this.url).subscribe((res) => {
      this.loginUser = res;
      for (let i of this.loginUser) {
        if (i.username === this.changeusername) {
          this.isusercorrect = true;
        }
      }
    });
  }

  submit() {
    if (this.isusercorrect) {
      let details = {
        username: this.changeusername,
        password: this.changepassword,
      };
      this.http.put(this.userurl, details).subscribe((res) => {
        this.passwordChange = true;
        console.log(res);
        this.model();
      });
    }
  }
}
