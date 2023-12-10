package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Phones;

public interface PhonesRepository extends JpaRepository<Phones, Long> {

	List<Phones> findByNumber(long number);

    // Puedes agregar consultas personalizadas según tus necesidades
    // Por ejemplo, findByNumber, findByCityCode, etc.
}

