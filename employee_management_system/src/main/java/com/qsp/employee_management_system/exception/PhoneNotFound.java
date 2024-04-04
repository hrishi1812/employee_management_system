package com.qsp.employee_management_system.exception;

import lombok.Data;

@Data
public class PhoneNotFound  extends RuntimeException{
	private String message;
	public PhoneNotFound(String message) {
		this.message=message;
	}
   @Override
   public String getMessage() {
	return message;
	   
   }

}
