package com.pp.springbootwebapp2.Controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pp.springbootwebapp2.Repository.RuoliRepository;
import com.pp.springbootwebapp2.Repository.UserRepository;
import com.pp.springbootwebapp2.transferdata.UserDTO;
import com.pp.springbootwebapp2.model.Ruolo;
import com.pp.springbootwebapp2.model.User;

@RestController
@RequestMapping("/api/au")
public class ApiController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RuoliRepository ruoliRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//LOGIN API
	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@RequestBody UserDTO userDTO){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userDTO.getName(),userDTO.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseEntity<>("Utente loggato con successo!", HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
		
		if(userRepository.existsByName(userDTO.getName())) {
			return new ResponseEntity<>("Name già in uso !", HttpStatus.BAD_REQUEST);
		}
		
		User user = new User();
		user.setName(userDTO.getName());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		Ruolo ruoli = ruoliRepository.findByName("ROLE_ADMIN").get();
		user.setRuoli(Collections.singleton(ruoli));
		
		userRepository.save(user);
		
		return new ResponseEntity<>("Utente registrato con successo",HttpStatus.OK);
	}
	
	

}
