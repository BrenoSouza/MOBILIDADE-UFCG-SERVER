package com.server.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String category;
	
	private int capacity;
	
	private Date year;
	
	private String brand;
	
	private String crlv;

	public Vehicle(Long id, String category, int capacity, Date year, String brand, String crlv) {
		this.id = id;
		this.category = category;
		this.capacity = capacity;
		this.year = year;
		this.brand = brand;
		this.crlv = crlv;
	}
	
	// constructor default
	public Vehicle() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCrlv() {
		return crlv;
	}

	public void setCrlv(String crlv) {
		this.crlv = crlv;
	}

}
