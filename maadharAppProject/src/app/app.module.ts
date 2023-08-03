import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MaadharrouteModule } from './App-route/maadharroute/maadharroute.module';
import { AdminAuthServiceService } from './authService/admin-auth-service.service';
import { LoginAuthService } from './shared/login/login-auth.service';

import { AppComponent } from './app.component';
import { LoginComponent } from './Components/login/login.component';
import { SignComponent } from './Components/sign/sign.component';
import { HeaderComponent } from './Components/header/header.component';
import { FooterComponent } from './Components/footer/footer.component';
import { UserComponent } from './Components/user/user.component';
import { ErrorPageComponent } from './Components/error-page/error-page.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './components/home/home.component';
import { ServiceComponent } from './components/service/service.component';
import { AdminComponent } from './components/admin/admin.component';
import { AboutComponent } from './components/about/about.component';
import { UserService } from './services/user/user.service';
import { UpdateUserService } from './services/updateUser/update-user.service';
import { LoginService } from './services/login/login.service';
import { AdminService } from './services/admin/admin.service';
import { UpdateUserComponent } from './components/update-user/update-user.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignComponent,
    HeaderComponent,
    FooterComponent,
    UserComponent,
    ErrorPageComponent,
    HomeComponent,
    ServiceComponent,
    AdminComponent,
    AboutComponent,
    UpdateUserComponent,
    UserLoginComponent,
    AdminLoginComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    MaadharrouteModule,
    ReactiveFormsModule,
  ],
  providers: [
    UserService,
    UpdateUserService,
    LoginService,
    AdminService,
    AdminAuthServiceService,
    LoginAuthService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
