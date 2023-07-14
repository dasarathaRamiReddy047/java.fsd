import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class EventService {
  constructor(private http: HttpClient) {}

  url = ' http://localhost:3000/employees';

  isAuth: boolean = false;

  fetchData() {
    return this.http.get(this.url);
  }

  deleteUser(id: number) {
    return this.http.delete(this.url + '/' + id);
  }

  postData(body: any) {
    return this.http.post(this.url, body);
  }

  putData(body: any, id: number) {
    const url = `${this.url}/${id}`;
    return this.http.put(url, body);
  }

  fetchDataById(id: any) {
    return this.http.get(this.url + '/' + id);
  }
}
