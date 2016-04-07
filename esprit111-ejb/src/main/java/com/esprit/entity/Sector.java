package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: Sector
 * 
 */
@Entity
public class Sector implements Serializable {

	private int refSector;
	private String libelleSector;
	private String description;
//	private List<SectorEnterprise> SectorEnterprises;
	
	private List<Enterprise> enterprises;
	private Enterprise enterprise;

	private List<TypeSector> typeSectors;
	private TypeSector typeSector;
	private List<TypeSectorSectorEnterprise> typeSectorSectorEnterprises;
	private TypeSectorSectorEnterprise typeSectorSectorEnterprise;
	
	private static final long serialVersionUID = 1L;

	public Sector() {
		super();
	}
	
	

	public Sector(String libelleSector, String description) {
		super();
		this.libelleSector = libelleSector;
		this.description = description;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRefSector() {
		return refSector;
	}

	public void setRefSector(int refSector) {
		this.refSector = refSector;
	}

	public String getLibelleSector() {
		return libelleSector;
	}

	public void setLibelleSector(String libelleSector) {
		this.libelleSector = libelleSector;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	@OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
//	@LazyCollection(LazyCollectionOption.FALSE)
//	public List<sectorEnterprise> getSectorEnterprises() {
//		return sectorEnterprises;
//	}
//
//	public void setSectorEnterprises(List<SectorEnterprise> SectorEnterprises) {
//		this.sectorEnterprises = sectorEnterprises;
//	}

	
	//********************* affichage par Sector ******************
	
	@OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

	@ManyToOne
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<TypeSector> getTypeSectors() {
		return typeSectors;
	}

	public void setTypeSectors(List<TypeSector> typeSectors) {
		this.typeSectors = typeSectors;
	}

	@ManyToOne
	public TypeSector getTypeSector() {
		return typeSector;
	}

	public void setTypeSector(TypeSector typeSector) {
		this.typeSector = typeSector;
	}

	@OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<TypeSectorSectorEnterprise> getTypeSectorSectorEnterprises() {
		return typeSectorSectorEnterprises;
	}

	public void setTypeSectorSectorEnterprises(
			List<TypeSectorSectorEnterprise> typeSectorSectorEnterprises) {
		this.typeSectorSectorEnterprises = typeSectorSectorEnterprises;
	}

	public TypeSectorSectorEnterprise getTypeSectorSectorEnterprise() {
		return typeSectorSectorEnterprise;
	}

	public void setTypeSectorSectorEnterprise(TypeSectorSectorEnterprise typeSectorSectorEnterprise) {
		this.typeSectorSectorEnterprise = typeSectorSectorEnterprise;
	}

	
	
}
