package com.estrading.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: SectorShare
 *
 */
@Entity
public class SectorShare implements Serializable {

	
	private int IdSectorShare;
	private String LibelleSectorShare;
	private String Description;
	private List<Shares> shares;

	private static final long serialVersionUID = 1L;

	public SectorShare() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdSectorShare() {
		return this.IdSectorShare;
	}

	public void setIdSectorShare(int IdSectorShare) {
		this.IdSectorShare = IdSectorShare;
	}   
	public String getLibelleSectorShare() {
		return this.LibelleSectorShare;
	}

	public void setLibelleSectorShare(String LibelleSectorShare) {
		this.LibelleSectorShare = LibelleSectorShare;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@OneToMany(mappedBy="categorie",cascade=CascadeType.REFRESH)

	public List<Shares> getShares() {
		return shares;
	}
	public void setShares(List<Shares> shares) {
		this.shares = shares;
	}
   
}
