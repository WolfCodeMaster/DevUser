package com.example.demo.util;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;

import com.example.demo.model.User;

public class UserUtils {

 
//	    public static void main(String[] args) {
//	        Optional<User> existingUser = new Optional<User>(1L, "Monica", "monica@gmail.cl", "gg", null);
//
//	        User updatedUser = new User(1L, "1","2","3", null);
//			try {
//				updatedUser = updateUser(existingUser,
//						updatedUser);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	        if (updatedUser != null) {
//	            System.out.println(updatedUser);
//	        } else {
//	            System.out.println("Manejar el caso en que el usuario no existe");
//	            // Manejar el caso en que el usuario no existe
//	        }
//	    }

	
 

	public static User updateUser(Optional<User> existingUser, User object) {
	    return existingUser.map(user -> new User(
	            user.getUser_id(),
	            Objects.requireNonNullElse(object.getName(), user.getName()),
	            Objects.requireNonNullElse(object.getEmail(), user.getEmail()),
	            Objects.requireNonNullElse(object.getPassword(), user.getPassword()),
	            user.getCreatedAt(),
	            user.getLastLogin(),
	            user.isActive(),
	            user.getSession_token(),
	            user.getPhones()
	        )
	    ).orElse(null);
	}

}



