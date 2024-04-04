package com.qsp.employee_management_system.exception;

import lombok.Data;

@Data
public class EmailNotFound extends RuntimeException {
	private String message;
	public EmailNotFound(String message) {
		this.message=message;
	}
   @Override
   public String getMessage() {
	return message;
	   
   }
}
