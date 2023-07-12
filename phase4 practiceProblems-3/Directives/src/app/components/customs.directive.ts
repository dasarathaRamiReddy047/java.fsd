import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appCustoms]',
})
export class CustomsDirective {
  constructor(private eleRef: ElementRef) {
    eleRef.nativeElement.style.color = 'green';
    eleRef.nativeElement.style.background = 'skyblue';
    eleRef.nativeElement.style.fontWeight = '700';
  }
}
