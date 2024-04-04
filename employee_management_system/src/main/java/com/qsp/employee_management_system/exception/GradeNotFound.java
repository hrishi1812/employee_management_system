package com.qsp.employee_management_system.exception;

import lombok.Data;

@Data
public class GradeNotFound extends RuntimeException{
	private String message;
	public GradeNotFound(String message) {
		this.message=message;
	}
   @Override
   public String getMessage() {
	return message;
	   
   }
	

}
