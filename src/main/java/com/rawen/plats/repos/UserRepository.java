package com.rawen.plats.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rawen.plats.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
