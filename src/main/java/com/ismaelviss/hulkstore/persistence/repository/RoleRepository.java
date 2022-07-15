package com.ismaelviss.hulkstore.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ismaelviss.hulkstore.domain.model.ERole;
import com.ismaelviss.hulkstore.domain.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);

}
