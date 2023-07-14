import { Component, OnInit } from '@angular/core';
import { EventService } from '../eventService/event.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent implements OnInit {
  constructor(private es: EventService, private router: Router) {}

  isAuth: boolean = false;

  login() {
    if (this.isAuth) {
      this.es.isAuth = false;
      this.router.navigate(['/login']);
    } else {
      this.router.navigate(['/login']);
    }
  }

  ngOnInit(): void {
    this.isAuth = this.es.isAuth;
  }
}
