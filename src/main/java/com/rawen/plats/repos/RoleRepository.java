package com.rawen.plats.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rawen.plats.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}