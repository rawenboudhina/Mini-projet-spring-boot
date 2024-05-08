package com.rawen.plats.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rawen.plats.entities.Plat;
import com.rawen.plats.entities.Style;
@RepositoryRestResource(path = "rest")

public interface PlatRepository extends JpaRepository<Plat, Long> {
	List<Plat> findByNomPlat(String nom);
	List<Plat> findByNomPlatContains(String nom);
	/*@Query("select p from Plat p where p.nomPlat like %?1 and p.prixPlat > ?2")
	List<Plat> findByNomPrix (String nom, Double prix);*/
	
	
	@Query("select p from Plat p where p.nomPlat like %:nom and p.prixPlat > :prix")
	List<Plat> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	@Query("select p from Plat p where p.style = ?1")
	List<Plat> findByStyle (Style style);
	List<Plat> findByStyleIdStyle(Long id);
	List<Plat> findByOrderByNomPlatAsc();
	@Query("select p from Plat p order by p.nomPlat ASC, p.prixPlat ASC")
	List<Plat> trierPlatsNomsPrix ();
	


	

}
