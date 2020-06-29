package com.app.toDoApp.admin.graphReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GraphDataService {
    @Autowired
    GraphReportRepository graphReportRepository;

    public List<GraphData> getGraphData(){
        List<GraphData> graphinfo = graphReportRepository.getGraphData();
        List<GraphData> graphData = new ArrayList<>();
        Map<String, GraphData> logMap= new TreeMap<>();
        for(int i=0; i<7;i++){
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -i);
            logMap.put(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()),null);
        }
        for(GraphData u: graphinfo){
            if(logMap.keySet().contains(u.getDate())){
                System.out.println(u);
                logMap.put(u.getDate(),u);
            }
//            else logMap.put()
        }
        for (String s: logMap.keySet()) {
         if (logMap.get(s)!=null)
            graphData.add(logMap.get(s));
         else graphData.add(new GraphData(s,0,0));
        }
        return graphData;
    }


    public void updateRegUsers(){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        GraphData graphData;
        if(graphReportRepository.findByDate(date.format(new Date()))!=null)
        {
            graphData = graphReportRepository.findByDate(date.format(new Date()));
            graphData.setRegcount(graphData.getRegcount()+1);
            graphReportRepository.save(graphData);
        }
        else graphData = new GraphData(date.format(new Date()),1,0);
        graphReportRepository.save(graphData);
    }

    public void updateTaskCount(){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        GraphData graphData;
        if(graphReportRepository.findByDate(date.format(new Date()))!=null)
        {
            graphData = graphReportRepository.findByDate(date.format(new Date()));
            graphData.setTaskcount(graphData.getTaskcount()+1);
            graphReportRepository.save(graphData);
        }
        else graphData = new GraphData(date.format(new Date()),0,1);
        graphReportRepository.save(graphData);
    }

}
