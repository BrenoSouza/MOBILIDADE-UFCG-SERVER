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


import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tb_driver")
public class Driver implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name = "id_driver")
	private Long id;
	
	@OneToOne(mappedBy="vehicle")
	private Travel travel;
	
	private int registration;
	
	@NotEmpty(message = "Nome não pode ser vazio.")
	private String name;
	
	@NotEmpty(message = "Cpf não pode ser vazio.")
	private String cpf;
	
	@NotEmpty(message = "Cnh não pode ser vazio.")
	private String cnh;
	
	@NotEmpty(message = "Endereço não pode ser vazio.")
	private String address;
	
	@NotEmpty(message = "Telefone não pode ser vazio.")
	private String phone;
	
	public Driver(int registration, String name, String cpf, String cnh, String address, String phone) {
		super();
		this.registration = registration;
		this.name = name;
		this.cpf = cpf;
		this.cnh = cnh;
		this.address = address;
		this.phone = phone;
	}

	public Driver() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getRegistration() {
		return registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + registration;
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
		Driver other = (Driver) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (registration != other.registration)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", registration=" + registration + ", name=" + name + ", cpf=" + cpf + ", cnh="
				+ cnh + ", address=" + address + ", phone=" + phone + "]";
	}
	
}
