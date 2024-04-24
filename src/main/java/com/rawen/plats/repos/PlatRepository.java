package com.rawen.plats.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rawen.plats.entities.Plat;

public interface PlatRepository extends JpaRepository<Plat, Long> {
	

}
