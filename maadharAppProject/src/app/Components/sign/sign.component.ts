import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-sign',
  templateUrl: './sign.component.html',
  styleUrls: ['./sign.component.css'],
})
export class SignComponent {
  constructor(private ls: LoginService, private router: Router) {}

  user = {
    name: '',
    email: '',
    password: '',
    phone: '',
  };

  onSubmit() {
    this.ls.registration(this.user).subscribe(
      (res) => {
        this.router.navigate(['/login']);
      },
      (error) => {
        console.error(error);
      }
    );
  }
}
