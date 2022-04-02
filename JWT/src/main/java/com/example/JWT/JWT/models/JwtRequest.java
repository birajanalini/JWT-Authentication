package com.example.JWT.JWT.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {
	
	private String username;
	private String password;
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username= username;
	}
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}


}
