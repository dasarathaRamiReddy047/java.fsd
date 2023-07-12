import { BrowserModule } from '@angular/platform-browser';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.css'],
})
export class FormsComponent {
  signupForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.signupForm = this.formBuilder.group({
      firstName: ['', Validators.required, Validators.minLength(6)],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  onSubmit() {
    if (this.signupForm.valid) {
      // Form is valid, perform your desired action here
      console.log(this.signupForm.value);
      // Reset the form after submission
      this.signupForm.reset();
    } else {
      // Form is invalid, handle error or display validation messages
    }
  }
}
