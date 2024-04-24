package com.rawen.plats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rawen.plats.entities.Plat;
import com.rawen.plats.repos.PlatRepository;

@Service
public class PlatServiceImpl implements PlatService{
	@Autowired
	PlatRepository platRepository;
	  

	@Override
	public Plat savePlat(Plat p) {
		return platRepository.save(p);
	}

	@Override
	public Plat updatePlat(Plat p) {
		return platRepository.save(p);

	}

	@Override
	public void deletePlat(Plat p) {
		 platRepository.delete(p);

		
	}

	@Override
	public void deletePlatById(Long id) {
		 platRepository.deleteById(id);

		
	}

	@Override
	public Plat getPlat(Long id) {
		return platRepository.findById(id).get();}

	@Override
	public List<Plat> getAllPlats() {
		return platRepository.findAll();

		
	}
		@Override
		public Page<Plat> getAllPlatsParPage(int page, int size) {
		return platRepository.findAll(PageRequest.of(page, size));
		}

		
	}
	

