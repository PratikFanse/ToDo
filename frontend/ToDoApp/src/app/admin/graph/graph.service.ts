import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GraphData } from './data/GraphData.model';
import { UserLog } from './data/UserLog.model';

@Injectable({
  providedIn: 'root'
})
export class GraphService {

  constructor(private http:HttpClient) {}

  getGraphDetails(){
    return this.http.get<GraphData[]>("http://localhost:8080/userActivity").toPromise();
  }
  getUserLog(){
    return this.http.get<UserLog[]>("http://localhost:8080/userLog").toPromise();
  }
  

}
