package com.charvikent.issuetracking.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.charvikent.issuetracking.dao.UserDao;
import com.charvikent.issuetracking.model.User;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	private final UserDao userRepository;
	private final UserDao userRolesRepository;
	
	@Autowired
    public CustomUserDetailsService(UserDao userRepository,UserDao userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository=userRolesRepository;
    }
	
        
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUserName(username);
		if(null == user){
			//return null;
		throw new UsernameNotFoundException("No user present with username: "+username);
		}else{
			List<String> userRoles=userRolesRepository.findRoleByUserName(username);
			return new CustomUserDetails(user,userRoles);
		}
		
	}
		
}
