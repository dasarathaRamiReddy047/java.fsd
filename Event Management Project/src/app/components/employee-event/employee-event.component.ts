import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tick } from '@angular/core/testing';
import { EventService } from '../eventService/event.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-event',
  templateUrl: './employee-event.component.html',
  styleUrls: ['./employee-event.component.css'],
})
export class EmployeeEventComponent implements OnInit {
  constructor(
    private http: HttpClient,
    private es: EventService,
    private router: Router
  ) {}

  url = ' http://localhost:3000/employees';

  userdata: any;

  header: string = '';

  id: number = 0;
  fname: string = '';
  lname: string = '';
  email: string = '';

  istrue: boolean = false;

  gettingData() {
    this.es.fetchData().subscribe(
      (data) => {
        this.userdata = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  ngOnInit(): void {
    this.gettingData();
  }

  view(id: any) {
    this.router.navigate(['/view', id]);
  }

  close() {
    this.istrue = false;
  }
  add() {
    this.istrue = true;
  }

  submit() {
    let details = {
      first_name: this.fname,
      last_name: this.lname,
      email: this.email,
    };
    return this.es.postData(details).subscribe((res) => {
      this.gettingData();
      this.istrue = false;
    });
  }
}
