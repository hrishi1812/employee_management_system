package com.qsp.employee_management_system.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private String message;
	private int statusCode;
	private T data;
}

