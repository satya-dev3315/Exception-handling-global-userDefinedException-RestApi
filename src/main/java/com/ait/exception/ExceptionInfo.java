package com.ait.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionInfo {
	
	private String excCode;
	private String excMsg;
	private LocalDateTime excDate;

}
