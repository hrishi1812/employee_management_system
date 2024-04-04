package com.qsp.employee_management_system.exception;

import lombok.Data;

@Data
public class AddressNotFound extends RuntimeException{
	private String message;
	public AddressNotFound(String message) {
		this.message=message;
	}
   @Override
   public String getMessage() {
	return message;
	   
   }

}
