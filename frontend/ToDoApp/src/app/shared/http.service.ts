import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActiveUser } from './activeUser/active-user';
import { User } from './user.model';
import { Task } from './task/task';
import { map } from 'rxjs/operators';
import { Subject } from 'rxjs';
// import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  taskChanged = new Subject<Task[]>();
  userCred:{username:string,password:string}

  constructor(private http:HttpClient,private router: Router) { }

  login(username:string, password:string){
  this.userCred={username,password}
  console.log(this.userCred.username+" "+ this.userCred.password)
    this.http.post<any>("http://localhost:8080/authenticate",this.userCred).toPromise().then(
      data => {
        sessionStorage.setItem("token", "Bearer "+ data.token)
        console.log(sessionStorage.getItem("token"))
        console.log(data);
        sessionStorage.setItem("username", username)
        const user =sessionStorage.getItem("username")
        if(user!=null)this.http.get<ActiveUser>("http://localhost:8080/activeUser").toPromise().then(
          data =>{
            console.log("SetUserDone")
            sessionStorage.setItem("activeUser", JSON.stringify(data))
            console.log(data.emailstatus+" Email.Status ")
            if(!data.emailstatus){
              this.router.navigate(['/logError'])
            }else this.router.navigate(['/']);
          })
      }
    )
  }

  register(user:User){
    let status= false;
    this.http.post("http://localhost:8080/register",user).subscribe(data=> {status=true})
    return status
  }

  isUserLogin(){
    const user =sessionStorage.getItem("activeUser")  
    return user!=null
  }
  
  logout(){
    sessionStorage.removeItem("activeUser")
    sessionStorage.removeItem("username");
    sessionStorage.removeItem("token");
  }

  addToList(name:string, id:number){
    let tasks:Task[]=[];
    let activeUser:ActiveUser = JSON.parse(sessionStorage.getItem("activeUser"))
    const task = new Task(id,name,"pending",activeUser.id)
    console.log(task.userid+" "+task.task)
    return this.http.post<Task[]>("http://localhost:8080/toDoTaskPut",task).toPromise()
  }

  onComplete(name:string, id:number){
    let activeUser:ActiveUser = JSON.parse(sessionStorage.getItem("activeUser"))
    const task = new Task(id,name,"completed",activeUser.id)
    console.log(task.status)
    return this.http.post<Task[]>("http://localhost:8080/toDoTaskPut",task).toPromise()
  }
  getTasksList(){
    let u:ActiveUser= JSON.parse(sessionStorage.getItem("activeUser"))
    return this.http.get<Task[]>("http://localhost:8080/toDoTask/"+u.id).toPromise()
  }

}
