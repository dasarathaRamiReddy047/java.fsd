import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductComponent } from './components/product/product.component';
import { AppRouteModule } from './components/app-route/app-route.module';
import { HeaderComponent } from './components/header/header.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductComponent,
    HeaderComponent,
  ],
  imports: [BrowserModule, AppRouteModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
