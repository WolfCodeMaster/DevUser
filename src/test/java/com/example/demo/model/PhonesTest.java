package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhonesTest {

    @Test
    public void testGetterAndSetter() {
        Phones phone = new Phones();
        phone.setPhone_id(1L);
        phone.setNumber(1234567890);
        phone.setCityCode(123);
        phone.setCountryCode("US");

        assertEquals(1L, phone.getPhone_id());
        assertEquals(1234567890, phone.getNumber());
        assertEquals(123, phone.getCityCode());
        assertEquals("US", phone.getCountryCode());
    }

    // Agrega más pruebas según sea necesario para cubrir otros métodos o lógica de la clase Phones
}
