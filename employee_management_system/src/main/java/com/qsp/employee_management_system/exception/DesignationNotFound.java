package com.qsp.employee_management_system.exception;

import lombok.Data;

@Data
public class DesignationNotFound extends RuntimeException{
	private String message;
	public DesignationNotFound(String message) {
		this.message=message;
	}
   @Override
   public String getMessage() {
	return message;
	   
   }

}
