package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.BadCredentialsException;
import com.example.demo.error.UsernameNotFoundException;
import com.example.demo.model.AuthRequest;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody AuthRequest authRequest) {
	    try {
	        String username = authRequest.getUsername();
	        String password = authRequest.getPassword();

	        if (isValidCredentials(username, password)) {
	            String token = authService.authenticate(username, password);
	            return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
	        }

	        return new ResponseEntity<>(Map.of("error", Collections.singletonList(
	                Map.of("timestamp", LocalDateTime.now(), "codigo", HttpStatus.UNAUTHORIZED.value(),
	                        "detail", "Credenciales inválidas"))), HttpStatus.UNAUTHORIZED);
	    } catch (BadCredentialsException e) {
	        return new ResponseEntity<>(Map.of("error", Collections.singletonList(
	                Map.of("timestamp", LocalDateTime.now(), "codigo", HttpStatus.UNAUTHORIZED.value(),
	                        "detail", "Credenciales inválidas"))), HttpStatus.UNAUTHORIZED);
	    } catch (UsernameNotFoundException e) {
	        return new ResponseEntity<>(Map.of("error", Collections.singletonList(
	                Map.of("timestamp", LocalDateTime.now(), "codigo", HttpStatus.UNAUTHORIZED.value(),
	                        "detail", "Usuario no encontrado"))), HttpStatus.UNAUTHORIZED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(Map.of("error", Collections.singletonList(
	                Map.of("timestamp", LocalDateTime.now(), "codigo", HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                        "detail", "Ocurrió un error durante el procesamiento de la solicitud. Detalles: " + e.getMessage()))),
	                HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	private boolean isValidCredentials(String username, String password) {
		// Verifica que username y password no sean nulos ni vacíos
		return username != null && !username.isEmpty() && password != null && !password.isEmpty();
	}

}
