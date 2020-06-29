import { Component, OnInit } from '@angular/core';
import { UserLog } from './data/UserLog.model';
import { GraphData } from './data/GraphData.model';
import { GraphService } from './graph.service';
import { GoogleChartComponent } from 'angular-google-charts';

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css']
})
export class GraphComponent implements OnInit {
  userLog:UserLog[];
  regCountPer=0;
  taksCount=0;
  activeCount=0;
  graphData:GraphData[];
  changeGraph='new';
  myData=[];
  // options={'title':'How Much Pizza I Ate Last Night',
  // 'width':800,
  // 'height':300}
  myType = 'AreaChart';
  options = {
    title: 'Company Performance',
    is3D: true,
    hAxis: {title: 'Date',  titleTextStyle: {color: '#333'}},
    vAxis: {minValue: 0}
  }
  
  constructor(private graphService:GraphService) { }

  ngOnInit(): void {
  this.graphService.getGraphDetails().then(
    data => {this.graphData= data;
      for(let i=0; i<=data.length-1;i++){
      this.regCountPer += data[i].regcount;
      this.taksCount+=data[i].taskcount;
      
    this.newUser();
    }
    }
  )
  this.graphService.getUserLog().then(
    data=>{ this.userLog=data;
    for(let i=0; i<=data.length-1;i++){
      console.log(data[0].date)
    this.activeCount += data[i].count;
  }
}

  )
  }
  
  getPercent(per:number,total:number){
   return per/total*100; 
  }

  newUser(){
    this.changeGraph="new";
    this.myData=[];
    for(let i=0; i<=this.graphData.length-1;i++){
      // this.myData.push([new UserLog(data[0].date,data[0].count)])
      this.myData.push([this.graphData[i].date.substr(5,),this.graphData[i].regcount])
    }
  }

  addedTasks(){
    this.changeGraph="tasks";
    this.myData=[];
    for(let i=0; i<=this.graphData.length-1;i++){
      // this.myData.push([new UserLog(data[0].date,data[0].count)])
      this.myData.push([this.graphData[i].date.substr(5,),this.graphData[i].taskcount])
    }
  }

  lastActive(){
    this.changeGraph="active";
    this.myData=[];
    for(let i=0; i<=this.userLog.length-1;i++){
      // this.myData.push([new UserLog(data[0].date,data[0].count)])
      this.myData.push([this.userLog[i].date.substr(5,),this.userLog[i].count])
    }
  }



 
}
