package com.qsp.employee_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.employee_management_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	Employee findByEmployeePhone(long pnone);
	Employee findByEmployeeEmail(String email);
	List<Employee> findByEmployeeName(String name);
	List<Employee> findByEmployeeAddress(String address);
	List<Employee> findByEmployeeDesignation(String designation);
	List<Employee> findByEmployeeGrade(char grade);
	@Query("SELECT employee FROM Employee employee WHERE employeeSalary<=?1")
	List<Employee> findByEmployeeSalaryLessThan(double sal);
	List<Employee> findByEmployeeSalaryGreaterThan(double sal);
	@Query("SELECT employee FROM Employee employee WHERE employeeSalary>=?1 AND employeeSalary<=?2")
	List<Employee> findByEmployeeSalaryBetn(double sal1,double sal2);
}
