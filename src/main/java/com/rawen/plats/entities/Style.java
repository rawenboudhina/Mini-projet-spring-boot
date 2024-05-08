package com.rawen.plats.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Style {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStyle;
	private String nomStyle;
	private String descriptionStyle;

	@OneToMany(mappedBy = "style")	 
	@JsonIgnore	
	private List<Plat> plats;

	

	public Style(String nomStyle, String descriptionStyle, List<Plat> plats) {
		super();
		this.nomStyle = nomStyle;
		this.descriptionStyle = descriptionStyle;
		this.plats = plats;
	}

	public Long getIdStyle() {
		return idStyle;
	}

	public void setIdStyle(Long idStyle) {
		this.idStyle = idStyle;
	}

	public String getNomStyle() {
		return nomStyle;
	}

	public void setNomStyle(String nomStyle) {
		this.nomStyle = nomStyle;
	}

	public String getDescriptionStyle() {
		return descriptionStyle;
	}

	public void setDescriptionStyle(String descriptionStyle) {
		this.descriptionStyle = descriptionStyle;
	}

	public List<Plat> getPlats() {
		return plats;
	}

	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}

}
