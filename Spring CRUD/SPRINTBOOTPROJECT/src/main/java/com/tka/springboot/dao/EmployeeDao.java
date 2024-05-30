package com.tka.springboot.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.springboot.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory sf;

	public String addEmployeeData(Employee employee) {
		String msg;
		try {
			Session session = sf.openSession();
			Employee emp = session.get(Employee.class, employee.getId());
			if (emp == null) {
				session.save(employee);
				session.beginTransaction().commit();
				msg = "Employeee Record Added Successfully";
			} else {
				msg = "Employee already exist";
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong";
		}

		return msg;

	}

	public List<Employee> getAllEmployee() {
		Session session = sf.openSession();
		List<Employee> emp = null;
		Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
		emp = query.list();
		query.stream().forEach(e -> {
			System.out.println(e);
		});

		return emp;
	}

	public String deleteEmployee(long id) {
		String msg;
		try {
			Session session = sf.openSession();
			Employee employee = session.get(Employee.class, id);
			if (employee != null) {
				session.delete(employee);
				session.beginTransaction().commit();
				msg = "Employee deleted successfully";
			} else {
				msg = "Employee not exist";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong" + e.getMessage();

		}
		return msg;
	}

	public String updateEmployee(long id, Employee employee) {
		String msg;
		try {
			Session session = sf.openSession();
			Employee employee2 = session.get(Employee.class, id);
			if (employee2 != null) {
				employee2.setName(employee.getName());
				employee2.setAge(employee.getAge());
				employee2.setDesignation(employee.getDesignation());
				employee2.setSalary(employee.getSalary());
				employee2.setAddress(employee.getAddress());
				session.update(employee2);
				session.beginTransaction().commit();
				msg = "Employee Updated successfully";
			} else {
				msg = "Employee is not Exist";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong" + e.getMessage();

		}

		return msg;
	}

	public Object getByIdEmployeeEmp(long id) {
		Employee employee2 = null;
		String msg;
		try {
			Session session = sf.openSession();
			employee2 = session.get(Employee.class, id);
			if (employee2 != null) {
				msg = " " + employee2.toString();
				;

			} else {
				msg = "Employee not found or exist";
			}
		} catch (Exception e) {
			msg = "Something went wrong" + e.getMessage();

		}
		return employee2;
	}

	public List<Employee> getAllEmployeByCityName(String city) {
		Session session = sf.openSession();
		Query<Employee> cities = session.createQuery("SELECT e FROM Employee e WHERE e.address.city= :cityName",
				Employee.class);
		cities.setParameter("cityName", city);
		List<Employee> city1 = cities.list().stream().collect(Collectors.toList());
		return city1;
	}

	public List<Employee> getEmpBySal(double salary) {
		Session session = sf.openSession();
		Query<Employee> salaryis = session.createQuery("FROM Employee WHERE salary >= :salaryValue", Employee.class);
		salaryis.setParameter("salaryValue", salary);
		salaryis.list().stream().collect(Collectors.toList());
		List<Employee> sal = salaryis.list().stream().collect(Collectors.toList());
		return sal;
	}

}
