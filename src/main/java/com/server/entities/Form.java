package com.server.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form")
public class Form implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	//dados da viagem
	private String requesterSector;
	private Date requestDate;
	private String destination;
	private String purpose;
	
	//dados do solicitante
	private String name;
	private String phone;
	
	//datas e horas da viagem
	private Date travelDate;
	private Date departureHour;
	private Date returnDate;
	private Date returnHour;
	private String departurePoint;
	private String address;
	
	//passageiros no aeroporto
	
	private Date arrivalTime;
	private String flightNumber;
	private String airCompany;
	private String travelOrigin;
	
	//responsável pela diarias do motorista
	private String driverSectorResponsibility;
	
	private String requestJustification;
	private String status;
	
	//construtor padrão
	public Form () {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequesterSector() {
		return requesterSector;
	}

	public void setRequesterSector(String requesterSector) {
		this.requesterSector = requesterSector;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date date) {
		this.travelDate = date;
	}

	public Date getDepartureHour() {
		return departureHour;
	}

	public void setDepartureHour(Date departureHour) {
		this.departureHour = departureHour;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getReturnHour() {
		return returnHour;
	}

	public void setReturnHour(Date returnHour) {
		this.returnHour = returnHour;
	}

	public String getDeparturePoint() {
		return departurePoint;
	}

	public void setDeparturePoint(String departurePoint) {
		this.departurePoint = departurePoint;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirCompany() {
		return airCompany;
	}

	public void setAirCompany(String airCompany) {
		this.airCompany = airCompany;
	}

	public String getTravelOrigin() {
		return travelOrigin;
	}

	public void setTravelOrigin(String travelOrigin) {
		this.travelOrigin = travelOrigin;
	}

	public String getDriverSectorResponsibility() {
		return driverSectorResponsibility;
	}

	public void setDriverSectorResponsibility(String driverSectorResponsibility) {
		this.driverSectorResponsibility = driverSectorResponsibility;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRequestJustification() {
		return requestJustification;
	}

	public void setRequestJustification(String requestJustification) {
		this.requestJustification = requestJustification;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Form other = (Form) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}