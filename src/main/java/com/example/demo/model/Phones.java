package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PHONES")
public class Phones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long phone_id;

    private long number;

    @Column(name = "city_code")
    private int cityCode;

    @Column(name = "country_code")
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

