package com.app.toDoApp.userInfo;

import com.app.toDoApp.admin.graphReport.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo getUserInfo(String username){
        return userInfoRepository.findById(username).get();
    }

    public void setUserInfo(UserInfo user){
        userInfoRepository.save(user);
    }

    public void updateLog(String username){
        UserInfo user= getUserInfo(username);
        user.setLastactive(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        user.setLastactive(new Date());
        userInfoRepository.save(user);
    }

    public List<UserLog> getUserLog(){
        List<UserLog> userLogs= new ArrayList<>();
        List<UserInfo> users= userInfoRepository.findAll();
        System.out.println(users);
        Map<String, Integer> logMap= new TreeMap<>();
        for(int i=0; i<7;i++){
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -i);
            logMap.put(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()),0);
            System.out.println();
        }

        for(UserInfo u: users){
            System.out.println(u.getLastactive());
            if(logMap.get(u.getLastactive())!=null)
                logMap.put(u.getLastactive(),logMap.get(u.getLastactive())+1);
        }
        for (String s: logMap.keySet())
            userLogs.add(new UserLog(s,logMap.get(s)));

        return userLogs;
    }


}
