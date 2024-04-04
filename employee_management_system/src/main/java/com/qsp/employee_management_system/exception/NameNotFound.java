package com.qsp.employee_management_system.exception;

import lombok.Data;

@Data
public class NameNotFound extends RuntimeException{
	private String message;
	public NameNotFound(String message) {
		this.message=message;
	}
   @Override
   public String getMessage() {
	return message;
	   
   }


}
