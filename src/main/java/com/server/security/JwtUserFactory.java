package com.server.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.server.entities.Admin;
import com.server.entities.enums.AdminRoles;



public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * Converte e gera um JwtUser com base nos dados de um funcionário.
	 * 
	 * @param admin
	 * @return JwtUser
	 */
	public static JwtUser create(Admin admin) {
		return new JwtUser(admin.getId(), admin.getEmail(), admin.getPassword(),
				mapToGrantedAuthorities(admin.getRoles()));
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 * 
	 * @param adminRoles
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(AdminRoles adminRoles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(adminRoles.toString()));
		return authorities;
	}
}
