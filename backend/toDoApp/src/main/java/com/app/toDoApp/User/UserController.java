//package com.app.toDoApp.User;
//
////import com.app.toDoApp.auth.model.JwtRequest;
////import com.app.toDoApp.auth.model.JwtResponse;
//import com.app.toDoApp.userInfo.UserInfo;
////import com.app.toDoApp.userInfo.UserInfoController;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
////    @Autowired
////    private UserInfoController userInfoController;
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public void saveUser(@RequestBody User user) throws Exception {
//         userRepository.save(user);
//    }
//
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public UserInfo authUser(@RequestBody UserCredential userCredential) throws Exception {
//        List<User> user= userRepository.findAll();
//        System.out.println(userCredential);
//        for (User u: user) {
//            if(u.getUsername().equals(userCredential.getUsername()) && u.getPassword().equals(userCredential.getPassword()))
//            {
//                System.out.println("Works");
//                return new UserInfo(u.getId(),u.getName(),u.getUsername(),u.getAccstatus(),u.getEmailstatus(),u.getRole());
//            }
//        }
//        return null ;
//    }
//
//}
