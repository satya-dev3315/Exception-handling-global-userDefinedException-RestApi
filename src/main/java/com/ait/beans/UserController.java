package com.ait.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ait.exception.UserNotFoundException;

@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/user/{userId}")
	public String getUser(@PathVariable("userId") int userId) {
		if (userId <= 100) {
			return "User found";
		} else {
			throw new UserNotFoundException("User not found");
		}
	}
	
	//main way to write global or user defind exception : we need to write try catch n in catch block because there we have exception obj, log n rethrow the user defined exception class 
	//By doing this we will get in which method exception occurs as we r writing logger.info("myuser() method started");
	//Also we can know :what is the error because catch (Exception e) {
	//logger.error("Error due to number divided by zero");
	//throw new UserNotFoundException("user nt found here...");

	@GetMapping("/myrest")
	public ResponseEntity<String> myuser() {
		logger.info("myuser() method started");
		// throwing exception
		try {
			int i = 10 / 0;
			System.out.println(i);
		} catch (Exception e) {
			logger.error("Error due to number divided by zero");
			throw new UserNotFoundException("user nt found here...");
		}
		return new ResponseEntity<>("Hello...Exc", HttpStatus.OK);
	}
	
}
