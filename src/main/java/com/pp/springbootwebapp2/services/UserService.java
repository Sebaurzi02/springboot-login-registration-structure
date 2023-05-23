package com.pp.springbootwebapp2.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pp.springbootwebapp2.Repository.UserRepository;
import com.pp.springbootwebapp2.model.User;

@Service
public class UserService implements UserDetailsService {
	
	private UserRepository userRepository;
	
	public UserService (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
		User user = userRepository.findByName(name).orElseThrow(() -> new UsernameNotFoundException("Username not found with :"+name));
		Set<GrantedAuthority> authority = user.getRuoli()
				.stream()
				.map((ruolo) -> new SimpleGrantedAuthority(ruolo.getName())).collect(Collectors.toSet());
		
		return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),authority);

	}
	
}
