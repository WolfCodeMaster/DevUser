package com.example.demo.dto;

import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhonesResponse {

	
    @JsonProperty("id")
    private Long id;

    @JsonProperty("number")
    private Long number;

    @JsonProperty("cityCode")
    private Integer cityCode;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("user")
    private User user;
}
