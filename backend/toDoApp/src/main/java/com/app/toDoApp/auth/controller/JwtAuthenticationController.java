package com.app.toDoApp.auth.controller;

import java.util.Objects;

import com.app.toDoApp.auth.model.UserStruct;
import com.app.toDoApp.auth.service.AES;
import com.app.toDoApp.userInfo.UserInfoService;
//import com.app.toDoApp.userInfo.UserLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.app.toDoApp.auth.service.JwtUserDetailsService;


import com.app.toDoApp.auth.config.JwtTokenUtil;
import com.app.toDoApp.auth.model.JwtRequest;
import com.app.toDoApp.auth.model.JwtResponse;
import com.app.toDoApp.auth.model.UserDTO;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private UserInfoService userInfoService;


	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		System.out.println("test");
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println(token);
		userInfoService.updateLog(authenticationRequest.getUsername());
		return ResponseEntity.ok(new JwtResponse(token)) ;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserStruct user) throws Exception {
		System.out.println(user.getDAOUser());
		return ResponseEntity.ok(userDetailsService.save(user.getDAOUser(),user.getUserInfo()));
	}

//	@Autowired
//	UserLogRepository userLogRepository;

	@RequestMapping(value = "/emailVerification/{email}", method = RequestMethod.GET)
	public String verifyEmail(@PathVariable String email){
		System.out.println(email);
		return userDetailsService.emailVerified(email);
	}


//	@RequestMapping(value = "/activeUser", method = RequestMethod.POST)
//	public ResponseEntity<?> saveUser(@RequestBody String userName) throws Exception {
//		return ResponseEntity.ok(userDetailsService.save(user)
//	}


	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			System.out.println("a");
			throw new Exception("USER_DISABLED", e);

		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);

		}
	}
}