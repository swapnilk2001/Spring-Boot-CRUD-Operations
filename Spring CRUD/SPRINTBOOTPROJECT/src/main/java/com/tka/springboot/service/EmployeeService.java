package com.tka.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.springboot.dao.EmployeeDao;
import com.tka.springboot.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;

	public String addEmployeeData(Employee employee) {
		String emp=dao.addEmployeeData(employee);
		
		return emp;
		
	}

	public List<Employee> getAllEmployee() {
		
		return dao.getAllEmployee();
	}

	public String deleteEmployee(long id) {
		return dao.deleteEmployee(id);
	}

	public String updateEmployee(long id,Employee employee) {
		
		return dao.updateEmployee(id, employee);
	}

	public Object getByIdEmployee(long id) {
		
		return dao.getByIdEmployeeEmp(id);
	}

	public List<Employee> getAllEmployeByCityName(String city) {
		
		return dao.getAllEmployeByCityName(city);
	}

	public List<Employee> getEmpBySal(double salary) {
		
		return dao.getEmpBySal(salary);
	}

}
