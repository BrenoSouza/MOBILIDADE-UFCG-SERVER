package com.server.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.server.security.JwtUserFactory;
import com.server.services.AdminService;
import com.server.entities.Admin;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdminService AdminService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = this.AdminService.findByEmail(username);

		if (admin != null) {
			return JwtUserFactory.create(admin);
		}
		
		admin = this.AdminService.findByCpf(username);
		
		if(admin != null) {
			return JwtUserFactory.create(admin);
		}

		throw new UsernameNotFoundException("Email or cpf not found.");
	}

}
