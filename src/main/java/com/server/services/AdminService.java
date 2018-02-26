package com.server.services;

import java.util.List;

import com.server.entities.Admin;

public interface AdminService {

	Admin findByEmail(String email);
	
	Admin findByCpf(String cpf);
	
	void save(Admin admin);
	
	List<Admin> getAll();
}
