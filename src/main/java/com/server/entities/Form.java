package com.server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "form")
public class Form implements Serializable{

	private Long id;
	
	//dados da viagem
	private String requesterSector;
	private String requestDate;
	private String destination;
	private String purpose;
	
	//dados do solicitante
	private String name;
	private String phone;
	
	//datas e horas da viagem
	private String travelDate;
	private String departureHour;
	private String likelyReturn;
	private String hour;
	private String departurePoint;
	
	//passageiros no aeroporto
	
	private String arrivalTime;
	private String flightNumber;
	private String airCompany;
	private String travelOrigin;
	
	//responsável pela diarias do motorista
	private String driverSectorResponsibility;
	
	//construtor padrão
	public Form () {
		
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
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

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
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

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String date) {
		this.travelDate = date;
	}

	public String getDepartureHour() {
		return departureHour;
	}

	public void setDepartureHour(String departureHour) {
		this.departureHour = departureHour;
	}

	public String getLikelyReturn() {
		return likelyReturn;
	}

	public void setLikelyReturn(String likelyReturn) {
		this.likelyReturn = likelyReturn;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDeparturePoint() {
		return departurePoint;
	}

	public void setDeparturePoint(String departurePoint) {
		this.departurePoint = departurePoint;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
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
	
}