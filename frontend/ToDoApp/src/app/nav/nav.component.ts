import { Component, OnInit } from '@angular/core';
import { HttpService } from '../shared/http.service';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { ActiveUser } from '../shared/activeUser/active-user';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
username:string;
user:ActiveUser;
admin=false;

  constructor(private httpService:HttpService,private router:Router, private appComponent:AppComponent) { }

  ngOnInit(): void {
    this.user =JSON.parse(sessionStorage.getItem('activeUser'))
    this.username= this.user.name;
    if(this.user.role==='admin'){
      this.admin=true
      console.log(this.user.role)
    }
    // this.router.navigate(['/ToDo'])
    
    // if(!this.httpService.isUserLogin()){
    //   this.appComponent.loginStatus(false);
    // }

  }

  onLogout(){
    this.appComponent.loginStatus(false);
    this.httpService.logout();
    this.router.navigate(['/authentication']);
  }
}
