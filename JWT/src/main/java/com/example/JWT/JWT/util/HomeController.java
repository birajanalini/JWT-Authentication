package com.example.JWT.JWT.util;

import org.springframework.web.bind.annotation.RestController;

import com.example.JWT.JWT.models.JwtRequest;
import com.example.JWT.JWT.models.JwtResponse;
import com.example.JWT.JWT.services.MyUserDeatilsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
//import com.example.JWT.JWT.services.MyUserDeatilsService;

@RestController
public class HomeController {

	@Autowired
	private MyUserDeatilsService userDetailsService;
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/hello") 
	public ResponseEntity<?> home()
	{
		return ResponseEntity.ok("welcome");
	}
	@PostMapping("/authenticate")
	public ResponseEntity<?>  authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

	    try{
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        jwtRequest.getUsername(),
	                        jwtRequest.getPassword()
	                )
	        );
	    } catch (BadCredentialsException e) {
	        throw new Exception("Invalid Credentials", e);
	    }
	    System.out.println("username "+jwtRequest.getUsername());
	    final UserDetails userDetails
	            = userDetailsService.loadUserByUsername(jwtRequest.getUsername());

	    final String token =
	            jwtUtility.generateToken(userDetails);
	    System.out.println("token "+token);

	    return ResponseEntity.ok(new JwtResponse(token));
	}
}
