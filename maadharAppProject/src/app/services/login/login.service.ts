import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  isAuth: boolean = false;

  url = 'http://localhost:2000/login';

  registration(body: any) {
    return this.http.post(this.url, body);
  }

  getLogin() {
    return this.http.get(this.url);
  }

  loginDetails: any;
}
