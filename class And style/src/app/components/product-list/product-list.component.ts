import { Component } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent {
  istrue = false;
  image =
    'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlCeVhPcF0B061dWx6Y2p6ZshztnAoVQI59g&usqp=CAU';

  show() {
    this.istrue = !this.istrue;
    console.log(this.istrue);
  }

  product: any = [
    {
      id: 1,
      name: 'iPhone',
      price: 100000,
      stock: true,
    },
    {
      id: 2,
      name: 'Samsung Galaxy',
      price: 90000,
      stock: false,
    },
    {
      id: 3,
      name: 'Google Pixel',
      price: 80000,
      stock: true,
    },
    {
      id: 4,
      name: 'Sony Xperia',
      price: 75000,
      stock: true,
    },
  ];
}
