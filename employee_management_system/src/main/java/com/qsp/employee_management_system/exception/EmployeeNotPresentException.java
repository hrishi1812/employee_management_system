package com.qsp.employee_management_system.exception;

import lombok.Data;

@Data
public class EmployeeNotPresentException extends RuntimeException{
	private String message;
	public EmployeeNotPresentException(String message) {
		this.message=message;
	}
   @Override
   public String getMessage() {
	return message;
	   
   }
	

}
