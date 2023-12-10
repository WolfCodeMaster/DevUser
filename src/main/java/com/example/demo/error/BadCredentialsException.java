package com.example.demo.error;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BadCredentialsException extends Exception {

 
	public BadCredentialsException(String string) {
		log.error(string);
	}

	private static final long serialVersionUID = -1033347927959903490L;

}
