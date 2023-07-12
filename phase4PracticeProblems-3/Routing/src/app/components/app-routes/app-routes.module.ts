import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from '../sign-in/sign-in.component';
import { HomeComponent } from '../home/home.component';
import { AboutComponent } from '../about/about.component';
import { ProductComponent } from '../product/product.component';

const routes: Routes = [
  { path: 'signin', component: SignInComponent },
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'product', component: ProductComponent },
];

@NgModule({
  declarations: [],
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutesModule {}
