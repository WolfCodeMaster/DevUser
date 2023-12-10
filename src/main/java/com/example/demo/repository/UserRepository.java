package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


	@Query("SELECT u FROM User u INNER JOIN FETCH u.phones p WHERE u.user_id = :userId")
	Optional<User> findByIdWithPhones(@Param("userId") Long userId);
	
	@Query("SELECT u FROM User u INNER JOIN FETCH u.phones p")
	List<User> findAllWithPhones();
	
	@Modifying
	@Query("UPDATE User u SET u.session_token = :token WHERE u.user_id = :userId")
    void updateSessionToken(@Param("userId") Long userId, @Param("token") String token);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByUsername(@Param("email") String email);

	 
}
