import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  constructor(private http: HttpClient) {}

  url = 'http://localhost:3000/newaadhar';

  // request

  // new apply request
  getRequestData() {
    return this.http.get(this.url);
  }

  getRequestDataById(id: number) {
    return this.http.get(this.url + '/' + id);
  }

  updatedRequestedData(id: number, body: any) {
    return this.http.put(this.url + '/' + id, body);
  }

  deletenewAadharRequest(id: number) {
    return this.http.delete(this.url + '/' + id);
  }

  // updateRequest Card

  updateurl: string = 'http://localhost:3000/updateAadhar';

  gettingUpdated() {
    return this.http.get(this.updateurl);
  }

  getUpdatedRequestById(id: number) {
    return this.http.get(this.updateurl + '/' + id);
  }

  insertUPdatedRequest(id: number, body: any) {
    return this.http.put(this.updateurl + '/' + id, body);
  }

  //updaterequest

  deleteUpdateRequest(id: number) {
    return this.http.delete(this.updateurl + '/' + id);
  }

  // getting deleteRequest Card

  deleteUrl = 'http://localhost:3000/deleteAadhar';

  deleterequest() {
    return this.http.get(this.deleteUrl);
  }

  getDeleteRequestById(id: any) {
    return this.http.get(this.deleteUrl + '/' + id);
  }

  Updatedeleterequest(id: number, body: any) {
    return this.http.put(this.deleteUrl + '/' + id, body);
  }

  // submitting to sql

  urlSql = 'http://localhost:2000/user';

  maadharAccept(body: any) {
    return this.http.post(this.urlSql, body);
  }

  getmAadharCard() {
    return this.http.get(this.urlSql);
  }

  getmAadharCardById(id: number) {
    return this.http.get(this.urlSql + '/' + id);
  }

  insertmAadharCard(id: number, data: any) {
    return this.http.put(this.urlSql + '/' + id, data);
  }
}
