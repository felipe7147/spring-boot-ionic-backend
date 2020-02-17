package com.felipealmeida.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.felipealmeida.cursomc.security.UserSS;

public class UserService {

	public static UserSS autheticated() {
		try {

			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
