package com.tka.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.springboot.entity.Employee;
import com.tka.springboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/insrt-emp")
	public String addEmployeeData(@RequestBody Employee employee) {
		String emp = service.addEmployeeData(employee);

		return emp;

	}

	@GetMapping("/get-all-emp")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}

	@DeleteMapping("/delete-emp/{id}")
	public String deleteEmployee(@PathVariable long id) {
		return service.deleteEmployee(id);
	}

	@PutMapping("/update-emp/{id}")
	public String updateEmployee(@PathVariable long id,@RequestBody Employee employee) {

		return service.updateEmployee(id, employee);
	}
	
	@GetMapping("/get-by-id/{id}")
	public Object getByIdEmployee(@PathVariable long id) {
		return service.getByIdEmployee(id);
	}
	
	@GetMapping("/get-all-emp-by-city-name")
	public List<Employee>getAllEmployeByCityName(@RequestParam String city)
	{
		return service.getAllEmployeByCityName(city);
	}
	
	@GetMapping("/get-emp-salary")
	public List<Employee>getEmpBySal(@RequestParam double salary){
		return service.getEmpBySal(salary);
	}
	
	

}
