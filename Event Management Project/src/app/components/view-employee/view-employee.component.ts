import { Component, OnInit } from '@angular/core';
import { EventService } from '../eventService/event.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css'],
})
export class ViewEmployeeComponent implements OnInit {
  constructor(
    public route: ActivatedRoute,
    public router: Router,
    private es: EventService,
    private http: HttpClient
  ) {}

  fname: string = '';
  lname: string = '';
  email: string = '';

  paramValue: any;
  viewData: any;

  istrue: boolean = false;

  gettingDetails() {
    return this.es.fetchDataById(this.paramValue).subscribe((res) => {
      this.viewData = res;
      console.log(this.viewData);
    });
  }

  ngOnInit(): void {
    let value = this.route.params.subscribe((params) => {
      this.paramValue = params['id'];
      console.log(this.paramValue);
      this.gettingDetails();
      console.log(this.viewData);
    });
  }

  delete() {
    this.es.deleteUser(this.paramValue).subscribe((res) => {
      this.router.navigate(['/event']);
    });
  }

  edit() {
    this.istrue = true;
    this.fname = this.viewData.first_name;
    this.lname = this.viewData.last_name;
    this.email = this.viewData.email;
  }

  close() {
    this.istrue = false;
  }

  save() {
    let update = {
      first_name: this.fname,
      last_name: this.lname,
      email: this.email,
    };
    return this.es.putData(update, this.paramValue).subscribe((res) => {
      this.router.navigate(['/event']);
    });
  }
}
