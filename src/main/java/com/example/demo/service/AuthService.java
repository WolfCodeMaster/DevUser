package com.example.demo.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.error.BadCredentialsException;
import com.example.demo.error.UsernameNotFoundException;
import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	UserRepository userRepository;

	public  Optional<User> loadUserByUsername(String username){
		return userRepository.findByUsername(username);
	}

	public String authenticate(String username, String password) throws BadCredentialsException, UsernameNotFoundException {
		// Si las credenciales son válidas, genera un token JWT
		 Optional<User> userDetails = loadUserByUsername(username);
		if (userDetails.isPresent()) {
		    User user = userDetails.get();
		    if (passwordMatches(password, user.getPassword())) {
				return jwtTokenProvider.generateToken(username);
			} else {
				// credenciales inválidas
				throw new BadCredentialsException("Credenciales inválidas"+ username);
			}
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado: " + username);
		}
	 
	}

	private boolean passwordMatches(String rawPassword, String encodedPassword) {
		return rawPassword.matches(encodedPassword);
	}

}
