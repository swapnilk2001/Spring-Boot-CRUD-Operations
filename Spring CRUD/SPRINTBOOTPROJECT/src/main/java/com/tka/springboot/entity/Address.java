package com.tka.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
	
	@Id
	private long houseNo;
	private String streat;
	private String city;
	

	public long getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(long houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreat() {
		return streat;
	}

	public void setStreat(String streat) {
		this.streat = streat;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public Address(long houseNo, String streat, String city) {
		super();
		this.houseNo = houseNo;
		this.streat = streat;
		this.city = city;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", streat=" + streat + ", city=" + city +  "]";
	}
	
	
	
	
	

}
