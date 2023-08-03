import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Timestamp } from 'mongodb';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  //request to apply new aadhar
  url: string = 'http://localhost:3000/newaadhar';

  requestNewCard(body: any) {
    return this.http.post(this.url, body).subscribe((res) => {
      console.log('register for new aadhar');
    });
  }

  // request for update new maadhar

  updateurl: string = 'http://localhost:3000/updateAadhar';

  updateRequest(body: any) {
    return this.http.post(this.updateurl, body);
  }

  //request card deleted

  deleteurl = 'http://localhost:3000/deleteAadhar';

  deleteCardRequest(body: any) {
    return this.http.post(this.deleteurl, body);
  }

  // gettting data from maadharcard and phone number

  urlSql = 'http://localhost:2000/user';

  getDatamAadharNoAndMobile(aadharNo: string, mobile: string) {
    return this.http.get(this.urlSql + '/' + aadharNo + '/' + mobile);
  }

  // for duplicate Request

  isduplicateAccepted: boolean = false;

  duplicateDataList: any;

  acceptedDuplicateData: any;

  duplicateUrl = 'http://localhost:3000/duplicate';

  getDuplicateData() {
    return this.http.get(this.duplicateUrl);
  }

  insertDuplicate(body: any) {
    return this.http.post(this.duplicateUrl, body);
  }
}
