package com.app.toDoApp.userInfo;

import com.app.toDoApp.ToDoAppApplication;
import com.app.toDoApp.auth.dao.UserDao;
import com.app.toDoApp.auth.model.DAOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService ;

    @RequestMapping(value = "/activeUser", method = RequestMethod.GET)
    public UserInfo findUserId(){
        UserInfo u=userInfoService.getUserInfo(ToDoAppApplication.reqUser);
        System.out.println(u.getUsername());
        return u;
    }

}
