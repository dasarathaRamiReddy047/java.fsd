import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeEventComponent } from './employee-event.component';

describe('EmployeeEventComponent', () => {
  let component: EmployeeEventComponent;
  let fixture: ComponentFixture<EmployeeEventComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmployeeEventComponent]
    });
    fixture = TestBed.createComponent(EmployeeEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
