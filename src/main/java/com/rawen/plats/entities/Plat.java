package com.rawen.plats.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Plat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlat;
	private String nomPlat;
	private Double prixPlat;
	private Date dateCreation;
	public Plat() {
	super();
	}
	public Plat(String nomPlat, Double prixPlat, Date dateCreation) {
	super();
	this.nomPlat = nomPlat;
	this.prixPlat = prixPlat;
	this.dateCreation = dateCreation;
	}
	public Long getIdPlat() {
	return idPlat;
	}
	public void setIdPlat(Long idPlat) {
	this.idPlat = idPlat;
	}
	public String getNomPlat() {
	return nomPlat;
	}
	public void setNomPlat(String nomPlat) {
	this.nomPlat = nomPlat;
	}
	public Double getPrixPlat() {
	return prixPlat;
	}
	public void setPrixPlat(Double prixPlat) {
	this.prixPlat = prixPlat;
	}
	public Date getDateCreation() {
	return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Plat [idPlat=" + idPlat + ", nomPlat=" + nomPlat + ", prixPlat=" + prixPlat + ", dateCreation="
				+ dateCreation + "]";
	}

	

}
