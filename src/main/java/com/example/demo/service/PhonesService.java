package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Phones;
import com.example.demo.repository.PhonesRepository;

import java.util.List;

@Service
public class PhonesService {

    private final PhonesRepository phonesRepository;

    @Autowired
    public PhonesService(PhonesRepository phonesRepository) {
        this.phonesRepository = phonesRepository;
    }

    public List<Phones> getAllPhones() {
        return phonesRepository.findAll();
    }

    public Phones getPhonesById(Long phonesId) {
        return phonesRepository.findById(phonesId).orElse(null);
    }

    public List<Phones> getPhonesByNumber(long number) {
        return phonesRepository.findByNumber(number);
    }

    // Puedes agregar métodos adicionales según tus necesidades
}
