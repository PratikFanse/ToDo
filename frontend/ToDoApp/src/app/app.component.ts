import { Component, OnInit, OnChanges } from '@angular/core';
import { HttpService } from './shared/http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnChanges{
  title = 'ToDoApp';
  activeStatus= false;

  constructor(private httpService:HttpService, private route: Router){}

  ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
    throw new Error("Method not implemented.");
  }
  ngOnInit(): void {
    this.activeStatus=this.httpService.isUserLogin();
    console.log(this.activeStatus)
    if(!this.activeStatus){
      this.route.navigate(['/authentication'])
    }else{
      this.route.navigate(['/'])
    }

  }

  loginStatus(status:boolean){
    console.log("Test")
    this.activeStatus=status;
    console.log(this.activeStatus)
    
  }

  

}
