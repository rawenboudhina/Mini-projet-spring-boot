package com.rawen.plats.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rawen.plats.entities.Plat;
import com.rawen.plats.service.PlatService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PlatRestController {
	@Autowired
	PlatService platService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Plat> getAllPlats() {
	return platService.getAllPlats();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Plat getPlatById(@PathVariable("id") Long id) {
	return platService.getPlat(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Plat createPlat(@RequestBody Plat plat) {
	return platService.savePlat(plat);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePlat(@PathVariable("id") Long id)
	{
	platService.deletePlatById(id);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Plat updatePlat(@RequestBody Plat plat) {
	return platService.updatePlat(plat);
	}
	@RequestMapping(value="/platsStyle/{idStyle}",method = RequestMethod.GET)
	public List<Plat> getPlatsByStyleIdStyle(@PathVariable("idStyle") Long idStyle) {
	return platService.findByStyleIdStyle(idStyle);
	}





}
