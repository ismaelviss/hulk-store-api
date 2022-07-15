package com.ismaelviss.hulkstore.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismaelviss.hulkstore.domain.model.User;
import com.ismaelviss.hulkstore.persistence.repository.AuthRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
	
	@Autowired
    private final AuthRepository authRepository;


    public void save(User user) {
        authRepository.save(user);
    }
    
    public Boolean existsByUsername(String username) {
    	return authRepository.existsByUsername(username);
    }
    
    public Boolean existsByEmail(String email) {
    	return authRepository.existsByUsername(email);
    }
    
	
	public Optional<User> findByUsername(String username){
		return authRepository.findByUsername(username);
	}

}
