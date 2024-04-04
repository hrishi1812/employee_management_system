package com.qsp.employee_management_system.exception;

import lombok.Data;

@Data
public class SalaryNotFound extends RuntimeException{
	private String message;
	public SalaryNotFound(String message) {
		this.message=message;
	}
   @Override
   public String getMessage() {
	return message;
	   
   }


}
