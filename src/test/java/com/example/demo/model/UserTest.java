package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	 @Test
	    void testConstructorAndGetters() {
	        // Arrange
	        User user = new User();
	        user.setUser_id(1L);
	        user.setName("John Doe");
	        user.setEmail("john@example.com");
	        user.setPassword("password");
	        // Set other properties as needed

	        // Act
	        Long userId = user.getUser_id();
	        String name = user.getName();
	        String email = user.getEmail();
	        String password = user.getPassword();
	        // Get other properties as needed

	        // Assert
	        assertEquals(1L, userId);
	        assertEquals("John Doe", name);
	        assertEquals("john@example.com", email);
	        assertEquals("password", password);
	        // Assert other properties as needed
	    }


}
