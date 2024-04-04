package com.qsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.repo.EmployeeRepo;


import lombok.Data;

@Data
@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee getEmployee(int id) {
		Optional<Employee> optional = employeeRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	public List<Employee> saveAll(List<Employee> list) {
		return employeeRepo.saveAll(list);

	}

	public List<Employee> findAll() {
		return employeeRepo.findAll();

	}

	public Employee findByPhone(long phone) {

		return employeeRepo.findByEmployeePhone(phone);
	}

	public Employee findByEmail(String email) {
		return employeeRepo.findByEmployeeEmail(email);

	}

	public List<Employee> findByName(String name) {
		return employeeRepo.findByEmployeeName(name);

	}

	public List<Employee> findByAddress(String address) {
		return employeeRepo.findByEmployeeAddress(address);

	}

	public List<Employee> findByDesignation(String designation) {
		return employeeRepo.findByEmployeeDesignation(designation);

	}

	public Employee delete(int id) {
		Optional<Employee> optional = employeeRepo.findById(id);
		if (optional.isPresent()) {
			employeeRepo.deleteById(id);
			return optional.get();
		} else {
			return null;
		}

	}

	public List<Employee> findByGrade(char grade) {
		return employeeRepo.findByEmployeeGrade(grade);

	}

	public List<Employee> findByLessThan(double sal) {
		return employeeRepo.findByEmployeeSalaryLessThan(sal);

	}

	public List<Employee> findByGreaterThan(double sal) {
		return employeeRepo.findByEmployeeSalaryGreaterThan(sal);

	}

	public List<Employee> findBySalBetn(double sal1, double sal2) {
		return employeeRepo.findByEmployeeSalaryBetn(sal1, sal2);

	}


}
