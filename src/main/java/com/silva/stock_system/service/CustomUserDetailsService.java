package com.silva.stock_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.silva.stock_system.model.User;
import com.silva.stock_system.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private final UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Optional.ofNullable(userRepository.findByUserName(username)).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
		List<GrantedAuthority> authorityListAdmin =  AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser =  AuthorityUtils.createAuthorityList("ROLE_USER");
		return new org.springframework.security.core.userdetails.User
				(user.getUserName(), user.getPassword(), user.getIsAdmin().equals("S") ? authorityListAdmin : authorityListUser);
	}
}
