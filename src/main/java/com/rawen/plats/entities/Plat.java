package com.rawen.plats.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity

public class Plat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlat;
	
	@NotNull
	@Size (min = 4,max = 15)

	private String nomPlat;
	
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixPlat;

	
	
	@Temporal(TemporalType.DATE)

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent

	private Date dateCreation;
	@ManyToOne
	private Style style;

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

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}
	 public Plat(String nomPlat, Double prixPlat, Date dateCreation, Style style) {
	        super();
	        this.nomPlat = nomPlat;
	        this.prixPlat = prixPlat;
	        this.dateCreation = dateCreation;
	        this.style = style;
	    }

}
