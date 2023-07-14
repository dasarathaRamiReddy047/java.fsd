import { HttpClient } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRouteModule } from './components/app-route/app-route.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';

import { EventService } from './components/eventService/event.service';
import { EmployeeEventComponent } from './components/employee-event/employee-event.component';
import { ViewEmployeeComponent } from './components/view-employee/view-employee.component';
import { LoginComponent } from './components/login/login.component';
import { AdminComponent } from './components/admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    EmployeeEventComponent,
    ViewEmployeeComponent,
    LoginComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    AppRouteModule,
    HttpClientModule,
  ],
  providers: [EventService],
  bootstrap: [AppComponent],
})
export class AppModule {}
