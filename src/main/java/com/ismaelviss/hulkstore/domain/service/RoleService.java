package com.ismaelviss.hulkstore.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismaelviss.hulkstore.domain.model.ERole;
import com.ismaelviss.hulkstore.domain.model.Role;
import com.ismaelviss.hulkstore.domain.model.User;
import com.ismaelviss.hulkstore.persistence.repository.RoleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService {
	
	@Autowired
    private final RoleRepository roleRepository;
	
	
	public Optional<Role> findByName(ERole name){
		return roleRepository.findByName(name); 
	}
	
}
