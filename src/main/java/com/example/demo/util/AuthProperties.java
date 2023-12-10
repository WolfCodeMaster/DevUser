package com.example.demo.util;

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
public class AuthProperties {

	private String tokenExpirationTime;
	
	private String loginBasicUrl;
	
	private String tokenBearerPrefix;
	
	private String headerAuthorizacionKey;
}
