import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin/admin.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent implements OnInit {
  constructor(private adminService: AdminService, private us: UserService) {}

  // requested Data
  requestData: any;
  acceptedData: any;

  requestDataList: any[] = [];
  updatedRequestList: any[] = [];
  deleteRequestList: any;
  updatedList: any;

  ngOnInit(): void {
    this.newRequestForAadhar();
    this.getmAadharCard();
    this.gettingUpdated();
    this.deleterequest();
    this.getDuplicateData();
  }

  newRequestForAadhar() {
    this.adminService.getRequestData().subscribe((res) => {
      this.requestData = res;
      console.log(this.requestData);

      this.requestDataList = this.requestData.filter((i: any) => !i.accept);
      console.log(this.requestDataList);
    });
  }

  getmAadharCard() {
    this.adminService.getmAadharCard().subscribe((res) => {
      this.acceptedData = res;
    });
  }

  gettingUpdated() {
    this.adminService.gettingUpdated().subscribe((res) => {
      this.updatedList = res;
      this.updatedRequestList = this.updatedList.filter(
        (i: any) => !i.isupdated
      );
      console.log(this.updatedRequestList);
    });
  }

  deleterequest() {
    this.adminService.deleterequest().subscribe((res) => {
      this.deleteRequestList = res;
      console.log(this.deleteRequestList);
    });
  }

  //duplicate data

  duplicateDataList: any;

  getDuplicateData() {
    this.duplicateDataList = this.us.duplicateDataList;
    console.log(this.duplicateDataList, 'duplicate');
  }

  //Issude date for aadharCard
  Issudedate() {
    let newDate = new Date();
    let date = newDate.getDate();
    let month = newDate.getMonth();
    let year = newDate.getFullYear();

    let date1 = date + '-' + month + '-' + year;
    return date1;
  }

  // accepting new card
  updateForAcceptedData: any;
  acceptingRequest: boolean = false;

  acceptedNewAadharCard(id: number) {
    this.acceptingRequest = true;

    this.adminService.getRequestDataById(id).subscribe((res) => {
      this.updateForAcceptedData = res;

      let requestdataupdate = {
        name: this.updateForAcceptedData.name,
        dob: this.updateForAcceptedData.dob,
        email: this.updateForAcceptedData.email,
        address: this.updateForAcceptedData.address,
        phone: this.updateForAcceptedData.phone,
        gender: this.updateForAcceptedData.gender,
        accept: true,
      };

      this.adminService
        .updatedRequestedData(id, requestdataupdate)
        .subscribe((res) => {
          console.log('requestdataupdate update');
        });

      // post this data into SQL
      let data = {
        name: this.updateForAcceptedData.name,
        aadharNo: Math.ceil(Math.random() * 10000),
        dob: this.updateForAcceptedData.dob,
        email: this.updateForAcceptedData.email,
        mobile: this.updateForAcceptedData.phone,
        gender: this.updateForAcceptedData.gender,
        address: this.updateForAcceptedData.address,
        passportId: this.updateForAcceptedData.passport,
        status: 'active',
        issueDate: this.Issudedate(),
      };

      this.adminService.maadharAccept(data).subscribe((res) => {
        alert('New Aadhar Accepted');
        this.newRequestForAadhar();
        this.getmAadharCard();
      });
    });
  }

  //accpted data
  isAcceptedDate = false;

  acceptData() {
    this.isAcceptedDate = !this.isAcceptedDate;
  }

  //deletenewRequest
  deleteRequest(id: number) {
    console.log(id);
    this.adminService.deletenewAadharRequest(id).subscribe((res) => {
      alert('Deleted New Request');
      this.newRequestForAadhar();
    });
  }

  //request update Data

  // deleterequest

  deleteData: any;
  isdeleted: boolean = false;
  deletedDataUpdate: any;

  deleteCard(id: number) {
    this.isdeleted = true;

    this.adminService.getDeleteRequestById(id).subscribe((res) => {
      this.deletedDataUpdate = res;
      let data = {
        id: this.deletedDataUpdate.id,
        name: this.deletedDataUpdate.name,
        aadharNo: this.deletedDataUpdate.aadharNo,
        dob: this.deletedDataUpdate.dob,
        email: this.deletedDataUpdate.email,
        mobile: this.deletedDataUpdate.mobile,
        gender: this.deletedDataUpdate.gender,
        address: this.deletedDataUpdate.address,
        status: this.deletedDataUpdate.status,
        issueDate: this.deletedDataUpdate.issueDate,
        isdeleted: true,
      };

      this.adminService.Updatedeleterequest(id, data).subscribe((res) => {
        console.log(res);
        this.deleterequest();
        this.acceptedData;
      });
    });

    this.adminService.getmAadharCardById(id).subscribe((res) => {
      this.deleteData = res;
      let data = {
        name: this.deleteData.name,
        aadharNo: this.deleteData.aadharNo,
        dob: this.deleteData.dob,
        email: this.deleteData.email,
        mobile: this.deleteData.phone,
        gender: this.deleteData.gender,
        address: this.deleteData.address,
        passportId: this.deleteData.passport,
        issueDate: this.deleteData.issueDate,
        status: 'close',
      };
      this.adminService.insertmAadharCard(id, data).subscribe((res) => {
        alert('deleted');
      });
    });
  }
  //updated data

  updatedDataList: any;

  updatedmAadharCard(id: any) {
    console.log(id);
    this.adminService.getUpdatedRequestById(id).subscribe((res) => {
      this.updatedDataList = res;
      console.log(res, 'update List');

      let updateData = {
        aadharNo: this.updatedDataList.aadharNo,
        name: this.updatedDataList.name,
        dob: this.updatedDataList.dob,
        email: this.updatedDataList.email,
        address: this.updatedDataList.address,
        mobile: this.updatedDataList.mobile,
        gender: this.updatedDataList.gender,
        issueDate: this.updatedDataList.issueDate,
        status: 'active',
      };
      let newid = this.updatedDataList.id;
      this.adminService.insertmAadharCard(newid, updateData).subscribe(() => {
        console.log('Updated status to active');
        alert('Updated successfully');
        this.adminService.deleteUpdateRequest(id).subscribe((res) => {
          console.log('updated Request');
          this.gettingUpdated();
        });
      });
    });
  }

  deleteUpdatedRequest(id: number) {
    this.adminService.deleteUpdateRequest(id).subscribe((res) => {
      console.log('updated Request');
      this.gettingUpdated();
    });
  }

  // tables toggle

  newApplyCardtable: boolean = false;
  updateCardtable: boolean = false;
  deleteCardtable: boolean = false;
  acceptCardtable: boolean = false;
  duplicateCardItem: boolean = false;

  newApplyCard() {
    this.newApplyCardtable = !this.newApplyCardtable;
    this.updateCardtable = false;
    this.deleteCardtable = false;
    this.acceptCardtable = false;
    this.duplicateCardItem = false;
  }

  updateCard() {
    this.newApplyCardtable = false;
    this.updateCardtable = !this.updateCardtable;
    this.deleteCardtable = false;
    this.acceptCardtable = false;
    this.duplicateCardItem = false;
  }

  deleteCardItem() {
    this.newApplyCardtable = false;
    this.updateCardtable = false;
    this.deleteCardtable = !this.deleteCardtable;
    this.acceptCardtable = false;
    this.duplicateCardItem = false;
  }

  acceptedCard() {
    this.newApplyCardtable = false;
    this.updateCardtable = false;
    this.deleteCardtable = false;
    this.acceptCardtable = !this.acceptCardtable;
    this.duplicateCardItem = false;
  }

  duplicateCard() {
    this.newApplyCardtable = false;
    this.updateCardtable = false;
    this.deleteCardtable = false;
    this.acceptCardtable = false;
    this.duplicateCardItem = !this.duplicateCardItem;
  }

  //duplicateItem
  isduplicate: boolean = false;
  duplicateItem(id: any) {
    this.isduplicate = true;
    this.us.insertDuplicate(this.duplicateDataList).subscribe((res) => {
      alert('Duplicate mAadhar Accpeted');
    });
  }
}
