import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css'],
})
export class ServiceComponent {
  constructor(private us: UserService) {}

  // form data
  name: string = '';
  dob: string = '';
  email: string = '';
  address: string = '';
  phone: string = '';
  gender: string = '';

  // get data
  getMobile: string = '';
  getCardNo: string = '';

  //msg
  getdatamsg: string = '';

  //new apply
  isApplynew: boolean = false;
  applyNew() {
    this.isApplynew = !this.isApplynew;
  }

  formData() {
    let data = {
      name: this.name,
      dob: this.dob,
      email: this.email,
      address: this.address,
      phone: this.phone,
      gender: this.gender,
      accept: false,
    };
    console.log(data);
    this.us.requestNewCard(data);
    alert('sent request for new mAadhar Card');
    this.name = '';
    this.dob = '';
    this.email = '';
    this.address = '';
    this.phone = '';
    this.gender = '';
    this.isApplynew = false;
  }

  //duplicate

  isdownload: boolean = false;

  download() {
    this.isdownload = !this.isdownload;
    this.isApplynew = false;
  }

  duplicate() {
    this.isAadherCard = false;
  }

  //delete

  deleteCon() {
    this.isdeleteData = false;
  }

  deleteData: any;

  isdeleteData: boolean = false;

  deleteCard() {
    this.isdeleteData = !this.isdeleteData;
  }

  deleteRequest() {
    this.isdeleteData = true;
    console.log(this.getCardNo, this.getMobile);
    return this.us
      .getDatamAadharNoAndMobile(this.getCardNo, this.getMobile)
      .subscribe((res) => {
        if (res === null) {
          this.getdatamsg = 'Data Not Found';
          this.isdownload = true;
        } else {
          this.getdatamsg = '';
          this.deleteData = res;
          this.isdeleteData = false;
          console.log(this.deleteData);
          this.deleteData['isdeleted'] = false;
          this.us.deleteCardRequest(this.deleteData).subscribe((res) => {
            console.log(res);
          });
        }
      });
  }

  // getting duplicate maadhar card

  downloadData: any;
  istrue: boolean = false;
  isAadherCard = false;

  sendRequest() {
    this.istrue = !this.istrue;
    return this.us
      .getDatamAadharNoAndMobile(this.getCardNo, this.getMobile)
      .subscribe((res) => {
        if (res === null) {
          this.getdatamsg = 'Data Not Found';
          this.isdownload = true;
        } else {
          this.getdatamsg = '';
          this.downloadData = res;
          this.isAadherCard = true;
          this.isdownload = false;
          this.istrue = false;
        }
      });
  }

  //duplicate Request

  isduplicate: boolean = false;

  duplicateClose() {
    this.isduplicate = false;
  }

  DuplicatesendRequest() {
    this.isduplicate = true;
    this.us
      .getDatamAadharNoAndMobile(this.getCardNo, this.getMobile)
      .subscribe((res) => {
        if (res === null) {
          this.getdatamsg = 'Data Not Found';
          this.isdownload = true;
        } else {
          this.getdatamsg = '';
          this.duplicateDataList = res;
          this.us.duplicateDataList = this.duplicateDataList;
          this.isduplicate = false;
          this.isdownload = false;
          this.istrue = false;
          console.log(this.duplicateDataList);
        }
      });
  }

  duplicateDataList: any;

  duplicateRequest() {
    this.isduplicate = !this.isduplicate;
  }

  acceptedDuplicateData: any;

  getAcceotedDuplicateData() {
    this.us.getDuplicateData().subscribe((res) => {
      this.acceptedDuplicateData = res;
      console.log(this.acceptedDuplicateData);
    });
  }

  isshow: boolean = false;

  showDuplicate() {
    this.isshow = !this.isshow;
    this.getAcceotedDuplicateData();
  }

  duplicateCloseItem() {
    this.isshow = false;
  }
}
