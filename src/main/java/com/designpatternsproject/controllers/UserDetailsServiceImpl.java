package com.designpatternsproject.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.designpatternsproject.entities.Role;
import com.designpatternsproject.entities.User;
import com.designpatternsproject.metier.IBidsMetier;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private IBidsMetier m;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		User user=m.findUserByUsername(arg0);
		if(user==null) throw new UsernameNotFoundException("Unknown username");
		
		Collection<GrantedAuthority> auth= new ArrayList<GrantedAuthority>();
		for (Role role:user.getRoles()) {
			auth.add(new GrantedAuthorityImpl(role.getRoleName()));
		}
		org.springframework.security.core.userdetails.User securityUser= 
				new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, auth);
		  
		return securityUser;
	}

}
