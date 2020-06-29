import { Component, OnInit,EventEmitter, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AppComponent } from 'src/app/app.component';
import { HttpService } from 'src/app/shared/http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Output() formMode= new EventEmitter<string>();
  
  constructor(private httpService:HttpService, private router:Router ) { }
  changeMode(){
    this.router.navigate(['/authentication/signup'])
  }

  onSubmit(form:NgForm){
    this.httpService.login(form.value.username, form.value.password);
    console.log(form.value.username+ " " +form.value.password)
    
  }


  ngOnInit(): void {
  }

}
