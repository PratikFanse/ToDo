package com.app.toDoApp.auth.service;

import java.util.ArrayList;

import com.app.toDoApp.admin.graphReport.GraphDataService;
import com.app.toDoApp.userInfo.UserInfo;
import com.app.toDoApp.userInfo.UserInfoRepository;
import com.app.toDoApp.userInfo.UserInfoService;
//import com.app.toDoApp.userInfo.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.toDoApp.auth.dao.UserDao;
import com.app.toDoApp.auth.model.DAOUser;
import com.app.toDoApp.auth.model.UserDTO;

import javax.mail.internet.InternetAddress;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private GraphDataService graphDataService;

	void sendEmail(String name, String username, boolean forVerify) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(username);
		if(forVerify) {
			msg.setSubject("ToDoApp Email Verifictaion");
			msg.setText("Hello " + name + ", Please verify your email by clicking following link:- " + "http://localhost:8080/emailVerification/"+username);
			javaMailSender.send(msg);
		}else{
			msg.setSubject("ToDoApp Email Verifictaion");
			msg.setText("Hello " + name + ", Your Verification done Successfully..");
			javaMailSender.send(msg);
		}
	}

	public String emailVerified(String email){
		UserInfo user = userInfoRepository.findById(email).get();
		sendEmail(user.getName(),user.getUsername(),false);
		user.setEmailstatus(true);
		userInfoRepository.save(user);
		return "Your email successfully verified thank you!!";
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	public int loadUserIdByUsername(String username){
		System.out.println("Test"+ username);
		DAOUser user= userDao.findByUsername(username);
		System.out.println(user);
		return userDao.findByUsername(username).getId();
	}
	public DAOUser save(DAOUser user) {
		return userDao.save(user);
	}

	public DAOUser save(DAOUser user, UserInfo userInfo) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		userDao.save(newUser);
		userInfo.setId(userDao.findByUsername(user.getUsername()).getId());
		userInfoRepository.save(userInfo);
		System.out.println(userInfo.getName()+"  "+user.getUsername());
		sendEmail(userInfo.getName(),user.getUsername(),true);
		graphDataService.updateRegUsers();
//		UserInfo u= new UserInfo();
//		u.setUsername(userInfo.getUsername());
//		u.setName(userInfo.getName());
//		u.setLastname(userInfo.getLastname());
//		u.setEmailstatus(userInfo.getEmailstatus());
//		u.setAccstatus(userInfo.getAccstatus());
//		u.setRole(userInfo.getRole());
//		u.setRegdate(userInfo.getRegdate());
//		u.setBirthdate(userInfo.getBirthdate());
//		userInfoRepository.save(u);
		return userDao.findByUsername(user.getUsername());
	}

//	public void sendVerificationEmail(String email) {
//		String encryptedString = AES.encrypt(email) ;
//	}
}