package com.server.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entities.Admin;
import com.server.repositories.AdminRepository;
import com.server.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin findByEmail(String email) {
		return this.adminRepository.findByEmail(email);
	}

	@Override
	public Admin findByCpf(String cpf) {
		return this.adminRepository.findByCpf(cpf);
	}

	@Override
	public void save(Admin admin) {
		this.adminRepository.save(admin);
		
	}

	@Override
	public List<Admin> getAll() {
		return this.adminRepository.findAll();
	}

}
