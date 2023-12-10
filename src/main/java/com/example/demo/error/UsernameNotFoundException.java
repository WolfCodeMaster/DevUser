package com.example.demo.error;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsernameNotFoundException extends Exception {

	public UsernameNotFoundException(String string) {
		log.error(string);
	}

	private static final long serialVersionUID = -2820996356414370040L;

}
