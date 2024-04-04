package com.qsp.employee_management_system.exception;

import lombok.Data;

@Data
public class IdNotFoundException extends RuntimeException {
	private String message;
	 IdNotFoundException(String message) {
		this.message=message;
	}
	 @Override
   public String getMessage() {
	   return message;
   }
}
