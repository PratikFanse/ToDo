import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, Validators  } from '@angular/forms';
import { User } from 'src/app/shared/user.model';
import { HttpService } from 'src/app/shared/http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent implements OnInit {
  @Output() formMode= new EventEmitter<string>();
  user:User;
  error:string;
  signUpStatus=false;
  constructor(private fb:FormBuilder, private httpService:HttpService, private router:Router ) { }
  
  ngOnInit(): void {}
  
  signUpForm = this.fb.group({
    fname: ['',Validators.required],
    lname: ['',Validators.required],
    bdate: ['',Validators.required],
    email: ['',[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
    pass: ['',[Validators.required,Validators.pattern('((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{1,})')]],
    cpass: ['',Validators.required]
  });
  
    get fname(){return this.signUpForm.get("fname")}
    get lname(){return this.signUpForm.get("lname")}
    get bdate(){return this.signUpForm.get("bdate")}
    get email(){return this.signUpForm.get("email")}
    get pass(){return this.signUpForm.get("pass")}
    get cpass(){return this.signUpForm.get("cpass")}
    
    changeMode(){
      this.router.navigate(['/authentication/'])
    }

  onSubmit(){
    const diff:number= new Date().getFullYear()- new Date(this.signUpForm.value.bdate).getFullYear();
    if(this.signUpForm.valid &&  diff>=18){
      this.error=null;
    const u= this.signUpForm.value;
    this.user= new User(u.email,u.pass,u.fname,u.lname,new Date(u.bdate));
    this.signUpStatus=this.httpService.register(this.user);
    } else if(diff<18){
      this.error="Age should be more than 18"
    } 
    this.changeMode();

  }
  
}
