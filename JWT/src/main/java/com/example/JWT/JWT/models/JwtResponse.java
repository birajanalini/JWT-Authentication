package com.example.JWT.JWT.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

	private String jwtToken;
	public JwtResponse(String jwtToken) {
		// TODO Auto-generated constructor stub
		this.jwtToken=jwtToken;
	}
	
	public String getjwtToken() {
		// TODO Auto-generated method stub
		return jwtToken;
	}
	
}
