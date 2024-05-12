package com.rawen.plats.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rawen.plats.entities.Plat;
import com.rawen.plats.entities.Style;

public interface PlatService {
	Plat savePlat(Plat p);
	Plat updatePlat(Plat p);
	void deletePlat(Plat p);
	 void deletePlatById(Long id);
	Plat getPlat(Long id);
	List<Plat> getAllPlats();
	Page<Plat> getAllPlatsParPage(int page, int size);
	List<Plat> findByNomPlat(String nom);
	List<Plat> findByNomPlatContains(String nom);
	List<Plat> findByNomPrix (String nom, Double prix);
	List<Plat> findByStyle (Style style);
	List<Plat> findByStyleIdStyle(Long id);
	List<Plat> findByOrderByNomPlatAsc();
	List<Plat> trierPlatsNomsPrix();
	List<Style> getAllStyles();


}
