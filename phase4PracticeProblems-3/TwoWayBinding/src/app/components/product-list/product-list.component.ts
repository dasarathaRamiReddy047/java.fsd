import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-product-list',
  template: '...',
})
export class ProductListComponent {
  @Output() cevent: EventEmitter<string> = new EventEmitter<string>();
  @Input() pdata: any;

  constructor() {}

  ngOnInit() {}

  onChange(value: string) {
    this.cevent.emit(value);
  }
}
