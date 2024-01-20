package com.ait.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class) // only this type exception will be catched
	public ResponseEntity<ExceptionInfo> exceptionHandler(UserNotFoundException e) {
		//here we have exception obj, so here also we can use log but here we will only get exception but we cant know in which class exception is there
		ExceptionInfo exceptionInfo = new ExceptionInfo();
		exceptionInfo.setExcCode("SBI-003");
		exceptionInfo.setExcMsg(e.getMessage());
		exceptionInfo.setExcDate(LocalDateTime.now());
		
		return new ResponseEntity<>(exceptionInfo, HttpStatus.BAD_REQUEST);
	}

}
