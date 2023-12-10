package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.UserUtils;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
    	List<User> u = userRepository.findAllWithPhones();
    	return u;
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);
		return true;
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByIdWithPhones(id).orElse(null));
        existingUser.ifPresentOrElse(
                user -> {
                    log.info(user.toString());
                    Optional.of(UserUtils.updateUser(existingUser,
    						updatedUser));
                    userRepository.save(user);
                },
                () -> {
                    log.warn("el usuario no existe {}" + id );
                    // Manejar el caso en que el usuario no existe
                }
            );	
		return updatedUser;
    }

	public void updateSessionToken(Long userId, String nuevoToken) {
		userRepository.updateSessionToken(userId, nuevoToken);
		
	}
}

