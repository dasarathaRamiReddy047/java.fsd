import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { LoginService } from 'src/app/services/login/login.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginAuthService } from 'src/app/shared/login/login-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  constructor(
    private ls: LoginService,
    private http: HttpClient,
    private router: Router,
    private fb: FormBuilder,
    private loginAuth: LoginAuthService
  ) {}
  loginForm: any;
  phonePattern = /^[0-9]{10}$/;
  passwordPattern = /^[0-9]{6,}$/;
  ngOnInit() {
    this.loginForm = this.fb.group({
      phone: ['', [Validators.required, Validators.pattern(this.phonePattern)]],
      password: [
        '',
        [Validators.required, Validators.pattern(this.passwordPattern)],
      ],
    });
  }

  loginDetails: any;
  onSubmit() {
    let login = this.loginForm.value;
    this.ls.getLogin().subscribe((res) => {
      this.loginDetails = res;
      for (let i of this.loginDetails) {
        if (i.phone === login.phone && i.password === login.password) {
          alert('Logged in');
          this.loginAuth.isUserLogined = true;
          this.router.navigate(['/']);
          this.ls.loginDetails = i;
          return;
        }
      }
      alert('Invalid phone number or password');
    });
  }
}
