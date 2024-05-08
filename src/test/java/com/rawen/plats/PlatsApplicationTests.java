package com.rawen.plats;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.rawen.plats.entities.Plat;
import com.rawen.plats.entities.Style;
import com.rawen.plats.repos.PlatRepository;
import com.rawen.plats.service.PlatService;

@SpringBootTest
class PlatsApplicationTests {
	@Autowired

	private PlatRepository platRepository;
	@Autowired
	private PlatService platService;

	@Test
	public void testCreatePlat() {
	Plat plat = new Plat("pasta",175000.0,new Date());
	platRepository.save(plat);
	}
	 @Test
	 public void testFindPlat()
	 {
	 Plat p = platRepository.findById(1L).get(); 
	 System.out.println(p);
	 }
	 /*@Test
	 public void testUpdatePlat() {
	 Plat p = platRepository.findById(1L).get();
	 p.setPrixPlat(100000.0);
	 platRepository.save(p);
	 }
	 @Test
	 public void testDeletePlat()
	 {
	 platRepository.deleteById(1L);;
	 }
	  
	 @Test
	 public void testListerTousPlats()
	 {
	 List<Plat> plats = platRepository.findAll();
	 for (Plat p : plats)
	 {
	 System.out.println(p);
	 }
	 }
	 //@Test
	 /*public void testFindByNomPlatContains()
	 {
	 Page<Plat> plats = platService.getAllPlatsParPage(0,2);
	 System.out.println(plats.getSize());
	 System.out.println(plats.getTotalElements());
	 System.out.println(plats.getTotalPages());
	 plats.getContent().forEach(p -> {System.out.println(p.toString());
	  });
	 /*ou bien
	 for (Plat p : plats)
	 {
	 System.out.println(p);
	 } 
	 }*/
	 @Test
	 public void testFindByNomPlat()
	 {
	 List<Plat> plats = platRepository.findByNomPlat("Pasta");
	 for (Plat p : plats)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testFindByNomPlatContains ()
	 {
	 List<Plat> plats=platRepository.findByNomPlatContains("p");
	 for (Plat p : plats)
	 {
	 System.out.println(p);
	 } }
	 public void testFindByNomPrix() {
		 List<Plat> plats = platRepository.findByNomPrix("pasta", 28000.0);
		 for (Plat p : plats)
		 {
		 System.out.println(p);
		 }

		 
	 }
	 @Test
	 public void testfindByStyle()
	 {
	 Style style = new Style();
	 style.setIdStyle(1L);
	 List<Plat> plats = platRepository.findByStyle(style);
	 for (Plat p : plats)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void findByStyleIdStyle()
	 {
	 List<Plat> plats = platRepository.findByStyleIdStyle(1L);
	 for (Plat p : plats)
	 {
	 System.out.println(p);
	 }
	  }
	 @Test
	 public void testfindByOrderByNomPlatAsc()
	 {
	 List<Plat> plats = 
	 platRepository.findByOrderByNomPlatAsc();
	 for (Plat p : plats)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testTrierPlatsNomsPrix()
	 {
	 List<Plat> plats = platRepository.trierPlatsNomsPrix();
	 for (Plat p : plats)
	 {
	 System.out.println(p);
	 }
	 }



	 

}
