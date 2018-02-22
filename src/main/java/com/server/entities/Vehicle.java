package com.server.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name = "id_vehicle")
	private Long id;
	
	@OneToOne(mappedBy="vehicle")
	private Travel travel;
	
	@NotNull
	@Size(max = 300)
	private String vehicle;
	
	@NotNull
	@Max(value = 50)
	private int capacity;
	
	@NotNull
	@Min(value = 1970)
	private int year;
	
	@NotNull
	@Size(max = 300)
	private String brand;
	
	@NotNull
	@Size(max = 300)
	private String plate;
	
	@NotNull
	@Size(max = 300)
	private String conservationState;
	
	@NotNull
	@Size(max = 300)
	private String fuel;
	
	@NotNull
	@Size(max = 300)
	private String color;
	
	public Vehicle(Long id, String vehicle, int capacity, int year, String brand, String plate,
			String conservationState, String fuel, String color) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.capacity = capacity;
		this.year = year;
		this.brand = brand;
		this.plate = plate;
		this.conservationState = conservationState;
		this.fuel = fuel;
		this.color = color;
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

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getConservationState() {
		return conservationState;
	}

	public void setConservationState(String conservationState) {
		this.conservationState = conservationState;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((plate == null) ? 0 : plate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (plate == null) {
			if (other.plate != null)
				return false;
		} else if (!plate.equals(other.plate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicle=" + vehicle + ", year=" + year + ", plate=" + plate + ", brand=" + brand
				+ ", conservationState=" + conservationState + ", fuel=" + fuel + ", color=" + color
				+ ", capacity="+ capacity + "]";
	}

}
