package com.estrading.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bonds
 *
 */
@Entity
@NamedQuery(name="retrieveByPG", query ="select p from Bonds p where p.professionel.id_user= :nom")

public class Bonds implements Serializable {

	
	private int idBond;
	private String typeBond;
	private int nombreCapital;
	private String Description;
	private String ImageLink;
	private String deleveryType;
	private int nbRatingG;
	private static final long serialVersionUID = 1L;
	private SectorBond categorie;
    private Customer customer;
    private List<TransactionBBond> transactions;
	private String stateBond="Available";
	
	private String addressBuyer;

	
	public Bonds() {
		super();
	}  
	
	
	
	public Bonds(String typeBond, int nombreCapital, String description,
			String deleveryType, int nbRatingG) {
		super();
		this.typeBond = typeBond;
		this.nombreCapital = nombreCapital;
		this.Description = description;
		this.deleveryType = deleveryType;
		this.nbRatingG = nbRatingG;
	}



	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdBond() {
		return this.idBond;
	}

	public void setIdBond(int idBond) {
		this.idBond = idBond;
	}   
	public String getTypeBond() {
		return this.typeBond;
	}

	public void setTypeBond(String typeBond) {
		this.typeBond = typeBond;
	}   
	public int getNombreCapital() {
		return this.nombreCapital;
	}

	public void setNombreCapital(int nombreCapital) {
		this.nombreCapital = nombreCapital;
	}
	@ManyToOne(cascade = CascadeType.REFRESH)

	public SectorBond getCategorie() {
		return categorie;
	}
	public void setCategorie(SectorBond categorie) {
		this.categorie = categorie;
	}
	@ManyToOne(cascade = CascadeType.REFRESH)

	public Customer getProfessionel() {
		return customer;
	}
	public void setProfessionel(Customer customer) {
		this.customer = customer;
	}
	@OneToMany(mappedBy="bond")

	public List<TransactionBBond> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionBBond> transactions) {
		this.transactions = transactions;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getImageLink() {
		return ImageLink;
	}
	public void setImageLink(String imageLink) {
		ImageLink = imageLink;
	}
	public String getDeleveryType() {
		return deleveryType;
	}
	public void setDeleveryType(String deleveryType) {
		this.deleveryType = deleveryType;
	}
	public String getStateBond() {
		return stateBond;
	}
	public void setStateBond(String stateBond) {
		this.stateBond = stateBond;
	}
	
	public String getAddressBuyer() {
		return addressBuyer;
	}
	public void setAddressBuyer(String addressBuyer) {
		this.addressBuyer = addressBuyer;
	}
	public int getNbRatingG() {
		return nbRatingG;
	}
	public void setNbRatingG(int nbRatingG) {
		this.nbRatingG = nbRatingG;
	}
	
}
