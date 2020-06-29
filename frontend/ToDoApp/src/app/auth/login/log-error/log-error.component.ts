import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from 'src/app/shared/http.service';
import { ActiveUser } from 'src/app/shared/activeUser/active-user';

@Component({
  selector: 'app-log-error',
  templateUrl: './log-error.component.html',
  styleUrls: ['./log-error.component.css']
})
export class LogErrorComponent implements OnInit {
  user:ActiveUser
  userErrStatus:string;
  constructor(private router:Router, private http:HttpService) {
    this.user= JSON.parse(sessionStorage.getItem("activeUser"));
    if(this.user.emailstatus){
      this.userErrStatus="Your account deactivated by admin, please contact admin!! Thank you.."
    }else {this.userErrStatus="Please Verify your email address!!! Thank you..."}
      setTimeout(() => {
        http.logout()
        router.navigate(['/authentication'])},5000)
   }

  ngOnInit(): void {
  }

}
