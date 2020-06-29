import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActiveUser } from '../shared/activeUser/active-user';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  loadUsers(){
      return this.http.get<ActiveUser[]>("http://localhost:8080/fetchAllUser").toPromise()
  }

  changeAccStatus(user:ActiveUser){
    return this.http.put<ActiveUser[]>("http://localhost:8080/updateUser",user).toPromise()    
  }
}
