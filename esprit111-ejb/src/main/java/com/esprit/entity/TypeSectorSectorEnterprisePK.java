package com.esprit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TypeSectorSectorEnterprisePK implements Serializable{
	
	private int refSector;
	private String matriculeEnterprise;
	private Integer idType;

	private static final long serialVersionUID = 1L;

	public TypeSectorSectorEnterprisePK(int refSector,
			String matriculeEnterprise, Integer idType) {
		super();
		this.refSector = refSector;
		this.matriculeEnterprise = matriculeEnterprise;
		this.idType = idType;
	}

	public TypeSectorSectorEnterprisePK() {
	}

	public int getRefSector() {
		return refSector;
	}

	public void setRefSector(int refSector) {
		this.refSector = refSector;
	}

	public String getMatriculeEnterprise() {
		return matriculeEnterprise;
	}

	public void setMatriculeEnterprise(String matriculeEnterprise) {
		this.matriculeEnterprise = matriculeEnterprise;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime
				* result
				+ ((matriculeEnterprise == null) ? 0 : matriculeEnterprise
						.hashCode());
		result = prime * result + refSector;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeSectorSectorEnterprisePK other = (TypeSectorSectorEnterprisePK) obj;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		if (matriculeEnterprise == null) {
			if (other.matriculeEnterprise != null)
				return false;
		} else if (!matriculeEnterprise.equals(other.matriculeEnterprise))
			return false;
		if (refSector != other.refSector)
			return false;
		return true;
	}

	

}
