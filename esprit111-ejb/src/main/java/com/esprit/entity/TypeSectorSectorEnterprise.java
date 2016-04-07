package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: TypeSectorSectorEnterprise
 * 
 */
@Entity
public class TypeSectorSectorEnterprise implements Serializable {

	private TypeSectorSectorEnterprisePK typeSectorSectorEnterprisePK;
	private TypeSector typeSector;
	private Enterprise enterprise;
	private Sector sector;

	private boolean statut;
	private int num;
	private int owner;
	private int reputation;
	
	private List<Enterprise> enterprises;

	private static final long serialVersionUID = 1L;

	public TypeSectorSectorEnterprise(TypeSector typeSector,
			Enterprise enterprise, Sector sector, boolean statut,
			int num, int owner, int reputation) {
		super();
		this.typeSector = typeSector;
		this.enterprise = enterprise;
		this.sector = sector;
		this.statut = statut;
		this.num = num;
		this.owner = owner;
		this.reputation = reputation;
		this.typeSectorSectorEnterprisePK = new TypeSectorSectorEnterprisePK(
				sector.getRefSector(), enterprise.getMatriculeEnterprise(),
				typeSector.getIdType());
	}

	public TypeSectorSectorEnterprise() {
		super();
	}

	public boolean getStatut() {
		return this.statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getOwner() {
		return this.owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getReputation() {
		return this.reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	@EmbeddedId
	public TypeSectorSectorEnterprisePK getTypeSectorSectorEnterprisePK() {
		return typeSectorSectorEnterprisePK;
	}

	public void setTypeSectorSectorEnterprisePK(
			TypeSectorSectorEnterprisePK typeSectorSectorEnterprisePK) {
		this.typeSectorSectorEnterprisePK = typeSectorSectorEnterprisePK;
	}

	@ManyToOne
	@JoinColumn(name = "idType", referencedColumnName = "idType", insertable = false, updatable = false)
	public TypeSector getTypeSector() {
		return typeSector;
	}

	public void setTypeSector(TypeSector typeSector) {
		this.typeSector = typeSector;
	}

	@ManyToOne
	@JoinColumn(name = "matriculeEnterprise", referencedColumnName = "matriculeEnterprise", insertable = false, updatable = false)
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@ManyToOne
	@JoinColumn(name = "refSector", referencedColumnName = "refSector", insertable = false, updatable = false)
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@OneToMany(mappedBy = "typePEnterprise", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

}
