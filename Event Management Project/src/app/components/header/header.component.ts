import { Component, OnInit } from '@angular/core';
import { EventService } from '../eventService/event.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  constructor(private es: EventService) {}

  isAuth: boolean = this.es.isAuth;
}
