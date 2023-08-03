import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from 'src/app/components/home/home.component';
import { ServiceComponent } from 'src/app/components/service/service.component';
import { UserComponent } from 'src/app/Components/user/user.component';
import { ErrorPageComponent } from 'src/app/Components/error-page/error-page.component';
import { LoginComponent } from 'src/app/Components/login/login.component';
import { SignComponent } from 'src/app/Components/sign/sign.component';
import { AdminComponent } from 'src/app/components/admin/admin.component';
import { UpdateUserComponent } from 'src/app/components/update-user/update-user.component';
import { UserLoginComponent } from 'src/app/components/user-login/user-login.component';
import { AdminLoginComponent } from 'src/app/components/admin-login/admin-login.component';
import { AdminAuthServiceService } from 'src/app/authService/admin-auth-service.service';
import { LoginAuthService } from 'src/app/shared/login/login-auth.service';

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'service',
    component: ServiceComponent,
    canActivate: [LoginAuthService],
  },
  { path: 'user', component: UserComponent },
  { path: 'login', component: LoginComponent },
  { path: 'sign', component: SignComponent },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AdminAuthServiceService],
  },
  { path: 'update', component: UpdateUserComponent },
  { path: 'userlogin', component: UserLoginComponent },
  { path: 'adminlogin', component: AdminLoginComponent },
  { path: '**', component: ErrorPageComponent },
];

@NgModule({
  declarations: [],
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class MaadharrouteModule {}
