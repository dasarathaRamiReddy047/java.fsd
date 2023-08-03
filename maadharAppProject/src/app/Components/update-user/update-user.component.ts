import { UserService } from 'src/app/services/user/user.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css'],
})
export class UpdateUserComponent {
  constructor(private us: UserService, private router: Router) {}

  //getform details
  getCardNo: string = '';
  getMobile: string = '';

  //form
  name: string = '';
  dob: string = '';
  email: string = '';
  address: string = '';
  phone: string = '';
  gender: string = '';

  isupdated: boolean = false;

  updateData() {
    this.isupdated = !this.isupdated;
  }

  update() {
    this.isupdated = !this.isupdated;
  }
  getdatamsg: string = '';

  getUserData: any;

  isupdatedata: boolean = false;

  getupdateDetails() {
    this.us
      .getDatamAadharNoAndMobile(this.getCardNo, this.getMobile)
      .subscribe((res) => {
        if (res === null) {
          this.getdatamsg = 'Data Not Found';
        } else {
          this.getUserData = res;
          console.log(this.getUserData);
          this.getdatamsg = '';
          this.isupdated = false;

          this.isupdatedata = true;

          //updating form

          this.name = this.getUserData.name;
          this.address = this.getUserData.address;
          this.dob = this.getUserData.dob;
          this.email = this.getUserData.email;
          this.phone = this.getUserData.mobile;
          this.gender = this.getUserData.gender;
        }
      });
  }

  //formdata send request to update

  formData() {
    let data = {
      id: this.getUserData.id,
      aadharNo: this.getUserData.aadharNo,
      name: this.name,
      dob: this.dob,
      email: this.email,
      address: this.address,
      mobile: this.phone,
      gender: this.gender,
      issueDate: this.getUserData.issueDate,
      isupdated: false,
    };

    this.us.updateRequest(data).subscribe((res) => {
      this.isupdated = false;
      alert('Update mAdhar Request Sent');
      this.router.navigate(['/service']);
    });
  }
}
