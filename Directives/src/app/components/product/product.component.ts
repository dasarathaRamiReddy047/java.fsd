import { Component } from '@angular/core';
import { CustomsDirective } from '../customs.directive';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent {
  products = [
    {
      id: 1,
      name: 'Samsung Galaxy S21',
      description: 'This is the latest flagship smartphone from Samsung.',
      price: 69999,
      quantity: 10,
      category: 'Mobile Phones',
    },
    {
      id: 2,
      name: 'Apple MacBook Pro',
      description: 'Powerful laptop for professional use.',
      price: 129999,
      quantity: 5,
      category: 'Laptops',
    },
    {
      id: 3,
      name: 'Sony PlayStation 5',
      description: 'Next-generation gaming console with immersive gameplay.',
      price: 49999,
      quantity: 15,
      category: 'Gaming Consoles',
    },
    {
      id: 4,
      name: 'Mi Smart Band 6',
      description:
        'Fitness tracker with heart rate monitoring and sleep tracking.',
      price: 2499,
      quantity: 20,
      category: 'Wearable Devices',
    },
    {
      id: 5,
      name: 'Canon EOS 200D DSLR Camera',
      description: 'Entry-level DSLR camera with advanced features.',
      price: 35999,
      quantity: 8,
      category: 'Cameras',
    },
    {
      id: 6,
      name: 'LG 55-inch 4K Smart TV',
      description: 'Ultra HD television with smart features and voice control.',
      price: 64999,
      quantity: 12,
      category: 'Televisions',
    },
  ];
}
