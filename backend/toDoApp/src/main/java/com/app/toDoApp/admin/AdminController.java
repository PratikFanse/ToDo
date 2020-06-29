package com.app.toDoApp.admin;

import com.app.toDoApp.admin.graphReport.GraphData;
import com.app.toDoApp.admin.graphReport.GraphDataService;
import com.app.toDoApp.admin.graphReport.UserLog;
import com.app.toDoApp.userInfo.UserInfo;
//import com.app.toDoApp.userInfo.UserLogService;
import com.app.toDoApp.userInfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private GraphDataService graphDataService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/fetchAllUser",method = RequestMethod.GET)
    public List<UserInfo> getAllUser(){
        return adminService.getAllUser();
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    public List<UserInfo> updateUser(@RequestBody UserInfo userInfo){
        System.out.println(userInfo.getUsername()+" change status "+" "+userInfo.getAccstatus());
        return adminService.updateUser(userInfo);
    }

//    @RequestMapping(value = "/userActivity",method = RequestMethod.GET)
//    public List<GraphData> getLastActive(){
//        return adminService.activeUser();
//    }

    @RequestMapping(value = "/userActivity",method = RequestMethod.GET)
    public List<GraphData> getLastActive(){
        return graphDataService.getGraphData();
    }

    @RequestMapping(value = "/userLog",method = RequestMethod.GET)
    public List<UserLog> userLog(){
        return userInfoService.getUserLog();
    }
}

