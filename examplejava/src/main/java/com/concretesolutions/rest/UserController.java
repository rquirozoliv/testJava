package com.concretesolutions.rest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.concretesolutions.dto.UserDTO;
import com.concretesolutions.exception.LoginUserException;
import com.concretesolutions.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@ResponseBody
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> saveUser(@RequestBody UserDTO userDto) {
		ResponseEntity<String> rs = null;
		try {
			String ffdf = userService.saveUser(userDto).toString();
			rs = new ResponseEntity<>(ffdf, HttpStatus.OK); //revisar 
		} catch (Exception e) {
			rs = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return rs;
	}
	
	
	@ResponseBody
	@GetMapping(value = "/login")
	public ResponseEntity<String> login(
			@RequestParam(name = "email", required = true) String  email,
			@RequestParam(name = "password", required = true) String  password) {
		ResponseEntity<String> responseEntity = null;
		try {
			String akshd = userService.loginUser(email, password).toString();
			responseEntity = new ResponseEntity<>(akshd, HttpStatus.OK); 
			
		} 
		catch (LoginUserException e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED); 
		}
		catch (Exception e) {
//			logger.error(e.getMessage(), e);
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}

}
	