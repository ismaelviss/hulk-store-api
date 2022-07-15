package com.ismaelviss.hulkstore.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismaelviss.hulkstore.domain.model.User;
import com.ismaelviss.hulkstore.persistence.repository.AuthRepository;
import com.ismaelviss.hulkstore.web.security.MyUserDetails;

@Service
public class UsersDetailsService implements UserDetailsService {
    
	/*
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("esalvati", "{noop}esalvati", new ArrayList<>());
    }
    */
	
	@Autowired
	AuthService authService;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = authService.findByUsername(username)
    	        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    	return MyUserDetails.build(user);
    }
    
    /*
    public UserDetails loadUserByUsernameAndPassword(String username,String password) throws UsernameNotFoundException {
    	return new MyUserDetails.build(username,password);
	}
	*/

}