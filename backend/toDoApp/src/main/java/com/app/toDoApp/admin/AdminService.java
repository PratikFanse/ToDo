package com.app.toDoApp.admin;

import com.app.toDoApp.ToDoAppApplication;
import com.app.toDoApp.admin.graphReport.GraphData;
import com.app.toDoApp.admin.graphReport.GraphReportRepository;
import com.app.toDoApp.auth.dao.UserDao;
import com.app.toDoApp.auth.model.DAOUser;
import com.app.toDoApp.auth.model.UserDTO;
import com.app.toDoApp.userInfo.UserInfo;
import com.app.toDoApp.userInfo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AdminService {
    @Autowired
    private UserInfoRepository userDao;

    @Autowired
    private GraphReportRepository graphReportRepository;

    public List<UserInfo> getAllUser(){
        UserInfo user=userDao.findById(ToDoAppApplication.reqUser).get();
        System.out.println(user.getUsername());
        return userDao.findAllUsers();
        }

    public List<UserInfo> updateUser(UserInfo userInfo){
        UserInfo user=userDao.findById(userInfo.getUsername()).get();
        System.out.println(user);
        user.setAccstatus(!user.getAccstatus());
        userDao.save(user);
        System.out.println(userDao.findAllUsers());
        return userDao.findAllUsers();
    }

    //List of active user in last 7
//    public List<GraphData> activeUser(){
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, -7);
//        SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
//        System.out.println(date.format(new Date()));
//        return userDao.getActiveUser(date.format(cal.getTime()));
//    }

    //List of register user in last 7
//    public List<GraphData> registerUser(){
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, -7);
//        return userDao.getRegisterUser(cal.getTime());
//    }

//    public List<GraphData> registeredUser(){
//
//        return graphReportRepository.getUsersData();
//    }


}

