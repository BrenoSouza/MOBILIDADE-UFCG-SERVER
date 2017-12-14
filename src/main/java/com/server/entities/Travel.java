package com.server.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Travel implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name = "id_travel")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_form")
	private Form form;
	
	@OneToOne
	@JoinColumn(name="id_vehicle")
	private Vehicle vehicle;
	
	@OneToOne
	@JoinColumn(name="id_driver")
	private Driver driver;	
	
	static private Long  Nrequest = (long) 0;
	
	@Column(name = "request_id")
	private Long  request;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date travelDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
	
	private String status;
	
	public Travel() {
		Nrequest++;
		request = Nrequest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Long getRequest() {
		return request;
	}

	public void setRequest(Long n_request) {
		this.request = n_request;
	}

	
	
	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Travel [id=" + id + ", form=" + form + ", vehicle=" + vehicle + ", driver=" + driver + ", request="
				+ request + ", travelDate=" + travelDate + ", returnDate=" + returnDate + ", status=" + status + "]";
	}
	
	
}
