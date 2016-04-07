package com.esprit.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: TypeSector
 *
 */
@Entity

public class TypeSector implements Serializable {

	private Integer idType;
	private String libelleType;
	
	private Sector sector;
	private Enterprise enterprise;
	private List<TypeSectorSectorEnterprise> typeSectorSectorEnterprises;
	
	private static final long serialVersionUID = 1L;

	public TypeSector() {
		super();
	}   
	
	
	
	
	public TypeSector(String libelleType) {
		super();
		this.libelleType = libelleType;
	}




	@Id    
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdType() {
		return this.idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}   
	public String getLibelleType() {
		return this.libelleType;
	}

	public void setLibelleType(String libelleType) {
		this.libelleType = libelleType;
	}
	
	@ManyToOne
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	@ManyToOne
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	@OneToMany(mappedBy = "typeSector", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<TypeSectorSectorEnterprise> getTypeSectorSectorEnterprises() {
		return typeSectorSectorEnterprises;
	}
	public void setTypeSectorSectorEnterprises(
			List<TypeSectorSectorEnterprise> typeSectorSectorEnterprises) {
		this.typeSectorSectorEnterprises = typeSectorSectorEnterprises;
	}
	
	
   
}
