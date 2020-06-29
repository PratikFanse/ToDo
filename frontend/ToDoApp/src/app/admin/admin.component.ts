import { Component, OnInit } from '@angular/core';
import { ActiveUser } from '../shared/activeUser/active-user';
import { AdminService } from './admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  users:ActiveUser[];
  constructor(private adminService:AdminService) {}

  ngOnInit(): void {
    this.adminService.loadUsers().then(data=> this.users= data)
  }
  
  
  onToggleactiveStatus(id:number){
    let changeUserStatus:ActiveUser= this.users[id];
    console.log(changeUserStatus.username)
    this.adminService.changeAccStatus(changeUserStatus).then(data => {this.users = data; 
      return data }) 
    console.log(this.users[id].accstatus+"After update")
  }
  
  
  

}
