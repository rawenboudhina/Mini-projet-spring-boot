package com.rawen.plats;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rawen.plats.entities.Plat;
import com.rawen.plats.service.PlatService;

@SpringBootApplication
public class PlatsApplication  implements CommandLineRunner {
	@Autowired
	PlatService platService;
	
	
	public static void main(String[] args) {
	SpringApplication.run(PlatsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		/*
		 * platService.savePlat(new Plat("couscous", 260000.0, new Date()));
		 * platService.savePlat(new Plat("Pasta", 280000.0, new Date()));
		 * platService.savePlat(new Plat("Lasagne", 250000.0, new Date()));
		 */
	}}
