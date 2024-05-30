package com.tka.springboot.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	private long id;
	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 18 && age <= 50) {

			this.age = age;
		}
	}

	private String designation;
	private double salary;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee(long id, String name, int age, String designation, double salary, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", designation=" + designation + ", salary="
				+ salary + ", address=" + address + "]";
	}

}
