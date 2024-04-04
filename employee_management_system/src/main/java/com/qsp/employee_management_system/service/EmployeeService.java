package com.qsp.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.employee_management_system.util.ResponseStructure;
import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.exception.AddressNotFound;
import com.qsp.employee_management_system.exception.DesignationNotFound;
import com.qsp.employee_management_system.exception.EmailNotFound;
import com.qsp.employee_management_system.exception.EmployeeNotPresentException;
import com.qsp.employee_management_system.exception.GradeNotFound;
import com.qsp.employee_management_system.exception.IdNotFoundException;
import com.qsp.employee_management_system.exception.NameNotFound;
import com.qsp.employee_management_system.exception.PhoneNotFound;
import com.qsp.employee_management_system.exception.SalaryNotFound;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		double sal = employee.getEmployeeSalary();
		if (sal <= 10000) {
			employee.setEmployeeGrade('D');

		} else if (sal > 10000 && sal <= 20000) {
			employee.setEmployeeGrade('C');

		} else if (sal > 20000 && sal <= 40000) {
			employee.setEmployeeGrade('B');

		} else {
			employee.setEmployeeGrade('A');
		}
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setMessage("SignUp Succesfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmployee(employee));

		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id, Employee employee) {
		Employee employee1 = dao.getEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee1 != null) {
			employee.setEmployeeId(id);
			double sal = employee.getEmployeeSalary();
			if (sal <= 10000) {
				employee.setEmployeeGrade('D');

			} else if (sal > 10000 && sal <= 20000) {
				employee.setEmployeeGrade('C');

			} else if (sal > 20000 && sal <= 40000) {
				employee.setEmployeeGrade('B');

			} else {
				employee.setEmployeeGrade('A');
			}

			structure.setMessage("update Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.saveEmployee(employee));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("Id not found");

		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id, double salary) {
		Employee employee = dao.getEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee != null) {
			double sal = employee.getEmployeeSalary();
			if (sal <= 10000) {
				employee.setEmployeeGrade('D');

			} else if (sal > 10000 && sal <= 20000) {
				employee.setEmployeeGrade('C');

			} else if (sal > 20000 && sal <= 40000) {
				employee.setEmployeeGrade('B');

			} else {
				employee.setEmployeeGrade('A');
			}
			structure.setMessage("update Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.saveEmployee(employee));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("Id not found");
		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> saveAll(List<Employee> list) {
		for (Employee employee : list) {
			double sal = employee.getEmployeeSalary();
			if (sal <= 10000) {
				employee.setEmployeeGrade('D');

			} else if (sal > 10000 && sal <= 20000) {
				employee.setEmployeeGrade('C');

			} else if (sal > 20000 && sal <= 40000) {
				employee.setEmployeeGrade('B');

			} else {
				employee.setEmployeeGrade('A');
			}
			dao.saveEmployee(employee);

		}
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		structure.setMessage("SignUp Succesfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(list);

		return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Employee>> find(int id) {
		Employee employee = dao.getEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee != null) {

			structure.setMessage("Find Succesfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(dao.getEmployee(id));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {

			throw new IdNotFoundException("Id not found");
		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {
		List<Employee> list = dao.findAll();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (!list.isEmpty()) {

			structure.setMessage("Find all Succesfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		} else {
			throw new EmployeeNotPresentException("Employee is not present");
		}

	}

	public String logIn(String email, String password) {
		Employee employee = dao.findByEmail(email);
		if (employee != null) {
			if (employee.getEmployeePassword().equals(password)) {
				return "Login successfull";
			} else {
				return "password not Found";
			}

		} else {
			throw new EmailNotFound("Email Not found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> findByPhone(long phone) {
		Employee employee = dao.findByPhone(phone);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee != null) {

			structure.setMessage("Find Succesfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(dao.findByPhone(phone));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {

			throw new PhoneNotFound("Phone Not found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email) {
		Employee employee = dao.findByEmail(email);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee != null) {

			structure.setMessage("Find Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.findByEmail(email));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {

			throw new EmailNotFound("email not Found");

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByName(String name) {
		List<Employee> list = dao.findByName(name);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (!list.isEmpty()) {
			structure.setMessage("Find Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.findByName(name));
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		} else {

			throw new NameNotFound("Name not Found");
		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByAddress(String address) {
		List<Employee> list = dao.findByAddress(address);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (!list.isEmpty()) {
			structure.setMessage("Find Succesfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(dao.findByAddress(address));
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		} else {

			throw new AddressNotFound("Address not Found");
		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByDesignation(String designation) {
		List<Employee> list = dao.findByDesignation(designation);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (!list.isEmpty()) {
			structure.setMessage("Find Succesfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(dao.findByDesignation(designation));
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		} else {

			throw new DesignationNotFound("Designation Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> delete(int id) {
		Employee employee = dao.getEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee != null) {

			structure.setMessage("Delete Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.delete(id));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("Id Not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> deleteByPhone(long phone) {
		Employee employee = dao.findByPhone(phone);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee != null) {

			structure.setMessage("Delete Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.delete(employee.getEmployeeId()));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {

			throw new PhoneNotFound("Phone Not found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> deleteByEmail(String email) {
		Employee employee = dao.findByEmail(email);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee != null) {

			structure.setMessage("Delete Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.delete(employee.getEmployeeId()));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {

			throw new EmailNotFound("email not Found");			
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id, long phone) {
		Employee employee = dao.getEmployee(id);
		if (employee != null) {

			employee.setEmployeePhone(phone);
			ResponseStructure<Employee> structure = new ResponseStructure<>();
			structure.setMessage("update Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.saveEmployee(employee));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("Id Not found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateemail(int id, String email) {
		Employee employee = dao.getEmployee(id);
		if (employee != null) {
			employee.setEmployeeEmail(email);
			ResponseStructure<Employee> structure = new ResponseStructure<>();
			structure.setMessage("update Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.saveEmployee(employee));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("Id Not found");
		}

		

	}

	public ResponseEntity<ResponseStructure<Employee>> updateAddress(int id, String address) {
		Employee employee = dao.getEmployee(id);
		if (employee != null) {
			employee.setEmployeeAddress(address);
			ResponseStructure<Employee> structure = new ResponseStructure<>();
			structure.setMessage("update Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.saveEmployee(employee));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("Id Not found");
		}


	}

	public ResponseEntity<ResponseStructure<Employee>> updatedesignation(int id, String designation) {
		Employee employee = dao.getEmployee(id);
		if (employee != null) {
			employee.setEmployeeDesignation(designation);
			ResponseStructure<Employee> structure = new ResponseStructure<>();
			structure.setMessage("update Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(dao.saveEmployee(employee));

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("Id Not found");
		}


	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByGrade(char grade) {
		List<Employee> list=dao.findByGrade(grade);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (!list.isEmpty()) {
			structure.setMessage("Find Succesfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(dao.findByGrade(grade));

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
			
		} else {
             throw new GradeNotFound("Grade Not Found");
		}
		
		

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByLessThan(double sal) {
		List<Employee> list=dao.findByLessThan(sal);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (!list.isEmpty()) {
		structure.setMessage("Find Succesfull");
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(dao.findByLessThan(sal));
		return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		
		} else {
			throw new SalaryNotFound("salary Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByGreaterThan(double sal) {
		List<Employee> list=dao.findByGreaterThan(sal);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (!list.isEmpty()) {
		structure.setMessage("Find Succesfull");
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(dao.findByGreaterThan(sal));
		return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		
		} else {
			throw new SalaryNotFound("salary Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findBySalBetn(double sal1, double sal2) {
		List<Employee> list=dao.findBySalBetn(sal1, sal2);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (!list.isEmpty()) {
		structure.setMessage("Find Succesfull");
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(dao.findBySalBetn(sal1, sal2));
		return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		
		} else {
			throw new SalaryNotFound("salary Not Found");
		}

		

	}

}
