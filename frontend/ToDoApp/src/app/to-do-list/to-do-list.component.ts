import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm, FormGroup, FormControl, FormsModule } from '@angular/forms';
import { Task } from '../shared/task/task';
import { HttpService } from '../shared/http.service';
import { User } from '../shared/user.model';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ActiveUser } from '../shared/activeUser/active-user';

@Component({
  selector: 'app-to-do-list',
  templateUrl: './to-do-list.component.html',
  styleUrls: ['./to-do-list.component.css']
})
export class ToDoListComponent implements OnInit {
  tasks:Task[];
  iftaskChanged:Subscription;
  editMode = false;

  @ViewChild('tf') tlForm: NgForm;

  constructor(private httpService:HttpService, private route:Router) { }

  ngOnInit(): void {
    const u:ActiveUser = JSON.parse(sessionStorage.getItem("activeUser"));
    this.httpService.taskChanged.subscribe(data => this.tasks=data);
    this.httpService.getTasksList().then
    (data => {
      console.log("test get list" + data.length)
      this.tasks=data
    })
  
      console.log(u.emailstatus+" TEst for email")
      if(!u.emailstatus || !u.accstatus){
        this.route.navigate(['/logError'])
        }
    }
 
  onClear(){
    this.editMode=false;
    this.tlForm.reset();
  }

  onAddTask(form:NgForm){
    const value =  this.tlForm.value
    const id= value.id==="" ?  0:value.id;
    console.log(value.name+ " " + id)
    this.httpService.addToList(value.name, id).then(data => {
      console.log("test get list" + data.length)
      this.tasks=data
      return data
    }
      )
    this.onClear()
    
  }

  onEditTask(id:number){
    this.editMode =true
    console.log(this.tasks[id].taskid)
    this.tlForm.setValue(
      {name:this.tasks[id].task,
      id:this.tasks[id].taskid,
      status:this.tasks[id].status})
  }

  onComplete(){
    const value =  this.tlForm.value
    this.httpService.onComplete(value.name, value.id)
    .then(data => {
      console.log("test get list" + data.length)
      this.tasks=data
      return data
    })
    this.onClear()
  }

}
