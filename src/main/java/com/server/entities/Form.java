package com.server.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.server.entities.enums.FormStatus;

@Entity
@Table(name = "tb_form")
public class Form implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name = "id_form")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="travel_id")
	private Travel travel;
	
	//dados da viagem
	@NotNull
	@Size(max = 300)
	private String requesterSector;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date requestDate;
	
	@NotNull
	@Size(max = 300)
	private String destination;
	
	@NotNull
	@Size(max = 300)
	private String purpose;
	
	//dados do solicitante
	@NotNull
	@Size(max = 300)
	private String name;
	
	@NotNull
	private String phone;
	
	//datas e horas da viagem
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date travelDate;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date departureHour;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date returnDate;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date returnHour;
	
	@NotNull
	@Size(max = 300)
	private String departurePoint;

	private String address;
	
	//passageiros no aeroporto
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date arrivalTime;
	
	@Size(max = 10)
	private String flightNumber;
	
	@Size(max = 300)
	private String airCompany;
	
	@Size(max = 300)
	private String travelOrigin;
	
	//responsável pela diarias do motorista
	@NotNull
	@Size(max = 300)
	private String driverSectorResponsibility;
	
	@Size(max = 300)
	private String requestJustification;
	
	@Enumerated(EnumType.STRING)
	private FormStatus status;
	
	public Form(String requesterSector, Date requestDate, String destination, String purpose, String name, String phone,
			Date travelDate, Date departureHour, Date returnDate, Date returnHour, String departurePoint,
			String address, Date arrivalTime, String flightNumber, String airCompany, String travelOrigin,
			String driverSectorResponsibility, String requestJustification, FormStatus status) {
		super();
		this.requesterSector = requesterSector;
		this.requestDate = requestDate;
		this.destination = destination;
		this.purpose = purpose;
		this.name = name;
		this.phone = phone;
		this.travelDate = travelDate;
		this.departureHour = departureHour;
		this.returnDate = returnDate;
		this.returnHour = returnHour;
		this.departurePoint = departurePoint;
		this.address = address;
		this.arrivalTime = arrivalTime;
		this.flightNumber = flightNumber;
		this.airCompany = airCompany;
		this.travelOrigin = travelOrigin;
		this.driverSectorResponsibility = driverSectorResponsibility;
		this.requestJustification = requestJustification;
		this.status = status;
	}

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

	public FormStatus getStatus() {
		return status;
	}

	public void setStatus(FormStatus status) {
		this.status = status;
	}

	public void setTravel(Travel travel) {
        setTravel(travel, true);
    }
     
    void setTravel(Travel travel, boolean add) {
        this.travel = travel;
        if (travel != null && add) {
            travel.addForm(this, false);
        }
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

	@Override
	public String toString() {
		return "Form [id=" + id + ", requesterSector=" + requesterSector + ", requestDate=" + requestDate
				+ ", destination=" + destination + ", purpose=" + purpose + ", name=" + name + ", phone=" + phone
				+ ", travelDate=" + travelDate + ", departureHour=" + departureHour + ", returnDate=" + returnDate
				+ ", returnHour=" + returnHour + ", departurePoint=" + departurePoint + ", address=" + address
				+ ", arrivalTime=" + arrivalTime + ", flightNumber=" + flightNumber + ", airCompany=" + airCompany
				+ ", travelOrigin=" + travelOrigin + ", driverSectorResponsibility=" + driverSectorResponsibility
				+ ", requestJustification=" + requestJustification + ", status=" + status + "]";
	}
			
}