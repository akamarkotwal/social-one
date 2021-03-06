package org.akcap.socialone.auth.controller;

import org.akcap.socialone.auth.model.JwtRequest;
import org.akcap.socialone.auth.model.JwtResponse;
import org.akcap.socialone.auth.service.JwtUserDetailsService;
import org.akcap.socialone.entity.UserInfomation;
import org.akcap.socialone.entity.Userlogin;
import org.akcap.socialone.userdetailes.service.UserRegisterServices;
import org.akcap.socialone.userdetailes.service.UserloginService;
import org.akcap.socialone.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin
@RequestMapping("/socialone")
public class JwtAuthenticationController {
	
	@Autowired
	private UserloginService userloginService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		Userlogin infomation= userloginService.findByUserLogin(authenticationRequest.getUsername());
		if(infomation==null) {
			return ResponseEntity.ok("Please entere valid creaditional");
		}

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
