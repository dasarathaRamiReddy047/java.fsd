import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { ViewEmployeeComponent } from '../view-employee/view-employee.component';
import { EmployeeEventComponent } from '../employee-event/employee-event.component';
import { LoginComponent } from '../login/login.component';
import { AdminComponent } from '../admin/admin.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'event', component: EmployeeEventComponent },
  { path: '', component: LoginComponent },
  { path: 'view/:id', component: ViewEmployeeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'admin', component: AdminComponent },
  { path: '**', component: HomeComponent },
];

@NgModule({
  declarations: [],
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRouteModule {}
