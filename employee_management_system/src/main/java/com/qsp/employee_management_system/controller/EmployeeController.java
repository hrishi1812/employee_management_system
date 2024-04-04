package com.qsp.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.service.EmployeeService;
import com.qsp.employee_management_system.util.ResponseStructure;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@PostMapping("/signup")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	@GetMapping("/login")
	public String logIn(String email,String password) {
		return service.logIn(email, password);
	}
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<Employee>> find(int id) {
		return service.find(id);
		
	}
	@PostMapping("/save/all")
	public ResponseEntity<ResponseStructure<List<Employee>>> saveAll(@RequestBody List<Employee> list) {
		return service.saveAll(list);
		
	}
	@GetMapping("/find/all")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {
		return service.findAll();
	}
	@GetMapping("/find/phone")
	public ResponseEntity<ResponseStructure<Employee>> findByPhone(long phone) {
		return service.findByPhone(phone);
	}
	@GetMapping("/find/email")
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email) {
		return service.findByEmail(email);
	}
	@GetMapping("/find/name")
	public ResponseEntity<ResponseStructure<List<Employee>>> findByPhone(String name) {
		return service.findByName(name);
	}
	@GetMapping("/find/designation")
	public ResponseEntity<ResponseStructure<List<Employee>>> findByDesignation(String designation) {
		return service.findByDesignation(designation);
	}
	@GetMapping("/find/address")
	public ResponseEntity<ResponseStructure<List<Employee>>> findByAddress(String address) {
		return service.findByAddress(address);
	}
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> update(int id,@RequestBody Employee employee) {
		return service.updateEmployee(id,employee);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Employee>> delete(int id) {
		return service.delete(id);
		
	}
	@DeleteMapping("/delete/phone")
	public ResponseEntity<ResponseStructure<Employee>> deleteByPhone(long phone) {
		return service.deleteByPhone(phone);
		
	}
	@DeleteMapping("/delete/email")
	public ResponseEntity<ResponseStructure<Employee>> deleteByEmail(String email) {
		return  service.deleteByEmail(email) ;
		
	}
	@PatchMapping("/update/salary")
	public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id,double salary) {
		return service.updateSalary(id, salary);
	}
	@PatchMapping("/update/designation")
	public ResponseEntity<ResponseStructure<Employee>> updateDesignation(int id,String designation) {
		return service.updatedesignation(id, designation);
	}
	@PatchMapping("/update/phone")
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id,long phone) {
		return service.updatePhone(id, phone);
	}
	@PatchMapping("/update/email")
	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id,String email) {
		return service.updateemail(id, email);
	}
	@PatchMapping("/update/address")
	public ResponseEntity<ResponseStructure<Employee>> updateAddress(int id,String address) {
		return service.updateAddress(id, address);
	}
	@GetMapping("/find/grade")
	public ResponseEntity<ResponseStructure<List<Employee>>> findByGrade(char grade) {
		return service.findByGrade(grade);
	}
	@GetMapping("/find/lessthan")
	public ResponseEntity<ResponseStructure<List<Employee>>> findByLessThan(double sal) {
		return service.findByLessThan(sal);
		
	}
	@GetMapping("/find/greaterthan")
	public ResponseEntity<ResponseStructure<List<Employee>>> findByGreaterThan(double sal) {
		return service.findByGreaterThan(sal);
		
	}
	@GetMapping("/find/between")
	public ResponseEntity<ResponseStructure<List<Employee>>> findBySalBetn(double sal1, double sal2) {
		return service.findBySalBetn(sal1, sal2);

	}

}
