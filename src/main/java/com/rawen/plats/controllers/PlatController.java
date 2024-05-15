package com.rawen.plats.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rawen.plats.entities.Plat;
import com.rawen.plats.entities.Style;
import com.rawen.plats.service.PlatService;

import jakarta.validation.Valid;

@Controller
public class PlatController {
	@Autowired
	PlatService platService;

	
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}

	@RequestMapping("/listePlats")
	public String listePlats(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Plat> plats = platService.getAllPlatsParPage(page, size);
		modelMap.addAttribute("plats", plats);
		modelMap.addAttribute("pages", new int[plats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listePlats";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("plat", new Plat());
		List<Style> styles = platService.getAllStyles();

		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("styles", styles);


		return "formPlat";

	}

	@RequestMapping("/savePlat")
	public String savePlat(@Valid Plat plat, BindingResult bindingResult, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		int currentPage;
		boolean isNew = false;
		// conversion de la date
		/*SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		plat.setDateCreation(dateCreation);

		Plat savePlat = platService.savePlat(plat);
		String msg = "plat enregistré avec Id " + savePlat.getIdPlat();
		modelMap.addAttribute("msg", msg);
		return "createPlat";*/
		if (bindingResult.hasErrors()) return "formPlat";
		 if(plat.getIdPlat()==null) //ajout
			    isNew=true;
		  			   
		  	platService.savePlat(plat);
		  	if (isNew) //ajout
		  	{
		  		Page<Plat> plats = platService.getAllPlatsParPage(page, size);
		  		currentPage = plats.getTotalPages()-1;
		  	}
		  	else //modif
		  		currentPage=page;
		//return "formPlat";
		//return ("redirect:/listePlats");
		return ("redirect:/listePlats?page="+currentPage+"&size="+size);


	}

	@RequestMapping("/supprimerPlat")
	public String supprimerPlat(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		platService.deletePlatById(id);
		Page<Plat> plats = platService.getAllPlatsParPage(page, size);
		modelMap.addAttribute("plats", plats);
		modelMap.addAttribute("pages", new int[plats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listePlats";
	}

	@RequestMapping("/modifierPlat")
	public String editerPlat(@RequestParam("id") Long id, ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)  {
		Plat p = platService.getPlat(id);
		List<Style> styles = platService.getAllStyles();

		modelMap.addAttribute("plat", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("styles", styles);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);


		return "formPlat";
	}

	@RequestMapping("/updatePlat")
	public String updatePlat(@ModelAttribute("plat") Plat plat, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		plat.setDateCreation(dateCreation);

		platService.updatePlat(plat);
		List<Plat> plats = platService.getAllPlats();
		modelMap.addAttribute("plats", plats);
		return "listePlats";
	}

}
