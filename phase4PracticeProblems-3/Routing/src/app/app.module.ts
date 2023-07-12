import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutesModule } from './components/app-routes/app-routes.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { ProductComponent } from './components/product/product.component';
import { AboutComponent } from './components/about/about.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProductComponent,
    AboutComponent,
    SignInComponent,
    HomeComponent,
  ],
  imports: [BrowserModule, FormsModule, AppRoutesModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
