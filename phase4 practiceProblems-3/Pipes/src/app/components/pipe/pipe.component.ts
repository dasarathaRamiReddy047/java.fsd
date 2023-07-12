import { Component } from '@angular/core';

@Component({
  selector: 'app-pipe',
  templateUrl: './pipe.component.html',
  styleUrls: ['./pipe.component.css'],
})
export class PipeComponent {
  products: any = [
    {
      name: 'iPhone 13 Pro',
      price: 999,
      category: '-smartphones',
    },
    {
      name: 'Samsung Galaxy S22 Ultra',
      price: 1199,
      category: '-smartphones',
    },
    {
      name: 'MacBook Pro M1 Pro',
      price: 1999,
      category: '-laptops',
    },
    {
      name: 'Dell XPS 13',
      price: 1299,
      category: '-laptops',
    },
    {
      name: 'Sony WH-1000XM4 Wireless Headphones',
      price: 349,
      category: '-headphones',
    },
    {
      name: 'AirPods Pro',
      price: 249,
      category: '-headphones',
    },
    {
      name: 'Apple Watch Series 7',
      price: 399,
      category: '-wearables',
    },
    {
      name: 'Samsung Galaxy Watch 4',
      price: 249,
      category: '-wearables',
    },
  ];
}
