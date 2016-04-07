package com.estrading.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SectorBond
 *
 */
@Entity

public class SectorBond implements Serializable {

	
	private int IdSectorBond;
	private String LibelleSectorBond;
	private String Description;
	private static final long serialVersionUID = 1L;
	private List<Bonds> bond; 

	public SectorBond() {
		super();
	}   
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdSectorBond() {
		return this.IdSectorBond;
	}

	public void setIdSectorBond(int IdSectorBond) {
		this.IdSectorBond = IdSectorBond;
	}   
	

	public String getLibelleSectorBond() {
		return LibelleSectorBond;
	}
	public void setLibelleSectorBond(String libelleSectorBond) {
		LibelleSectorBond = libelleSectorBond;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@OneToMany(mappedBy="categorie" , cascade = CascadeType.REFRESH)

	public List<Bonds> getBond() {
		return bond;
	}
	public void setBond(List<Bonds> bond) {
		this.bond = bond;
	}
   
}
