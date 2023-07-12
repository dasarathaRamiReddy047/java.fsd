import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductComponent } from '../product/product.component';
import { ProductListComponent } from '../product-list/product-list.component';

const routes: Routes = [
  { path: '', component: ProductComponent },
  { path: 'list', component: ProductListComponent },
];

@NgModule({
  declarations: [],
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRouteModule {}
