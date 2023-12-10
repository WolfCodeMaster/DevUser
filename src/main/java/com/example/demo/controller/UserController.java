package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")  //Read
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
    	try {
    		log.info(">>>>>  id:" + id);
            User user = userService.getUserById(id);
            if (user != null) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Map<String, Object> errorResponse = Collections.singletonMap("error", Collections.singletonList(
                    Map.of(
                            "timestamp", LocalDateTime.now(),
                            "codigo", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "detail", "Ocurrió un error durante el procesamiento de la solicitud. Detalles: " + e.getMessage()
                    )
            ));
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")  //Create
    public ResponseEntity<Object> createUser(@RequestBody User user) {
    	try {
            // Intenta guardar el usuario
            User createdUser = userService.saveUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            // Si hay un error, manejar la excepción y construir la respuesta personalizada
            Map<String, Object> errorResponse = Collections.singletonMap("error", Collections.singletonList(
                    Map.of(
                            "timestamp", LocalDateTime.now(),
                            "codigo", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "detail", "Ocurrió un error durante el procesamiento de la solicitud. Detalles: " + e.getMessage()
                    )
            ));
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{userId}")  //Update
    public ResponseEntity<Object> updateUser(@PathVariable Long userId, @RequestBody User user) {
    	try {
            User updatedUser = userService.updateUser(userId, user);
            if (updatedUser != null) {
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            } else {
            	 Map<String, Object> errorResponse = Collections.singletonMap("error", Collections.singletonList(
                         Map.of(
                                 "timestamp", LocalDateTime.now(),
                                 "codigo", HttpStatus.NOT_FOUND.value(),
                                 "detail", "Ocurrió un error durante el procesamiento de la solicitud. Detalles: User no encontrado")
                         )
                 );
                 return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
      
            }
        } catch (Exception e) {
            Map<String, Object> errorResponse = Collections.singletonMap("error", Collections.singletonList(
                    Map.of(
                            "timestamp", LocalDateTime.now(),
                            "codigo", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "detail", "Ocurrió un error durante el procesamiento de la solicitud. Detalles: " + e.getMessage()
                    )
            ));
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Read/{userId}")  //Delete
    public ResponseEntity<Object> deleteUser(@PathVariable Long userId) {
    	try {
            boolean deleted = userService.deleteUser(userId);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Map<String, Object> errorResponse = Collections.singletonMap("error", Collections.singletonList(
                    Map.of(
                            "timestamp", LocalDateTime.now(),
                            "codigo", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "detail", "Ocurrió un error durante el procesamiento de la solicitud. Detalles: " + e.getMessage()
                    )
            ));
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
