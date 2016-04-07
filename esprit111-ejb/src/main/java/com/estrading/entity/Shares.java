package com.estrading.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Share
 *
 */
@Entity
@NamedQuery(name="retrieveByP", query ="select p from Shares p where p.customer.id_user= :nom")
public class Shares implements Serializable {

	
	private int idShare;
	private String typeShare;
	private int nbrCapital;
	private String Description;
	private String shareName;
	private String ImageLink;
	private String openingUp;
	private String high;
	private String low;
	private String volumeValues;
	private String volumeDT;
	private String last;
	private String variation;
	
	private int nbRating;
	private static final long serialVersionUID = 1L;
    private Customer customer;
    private SectorShare categorie;
    private List<TransactionBShare> transaction;
    public Shares() {
		super();
	}   
	@Id
	@GeneratedValue
	public int getIdShare() {
		return this.idShare;
	}

	public void setIdShare(int idShare) {
		this.idShare = idShare;
	}   
	public String getTypeShare() {
		return this.typeShare;
	}

	public void setTypeShare(String typeShare) {
		this.typeShare = typeShare;
	}   
	public int getNbrCapital() {
		return this.nbrCapital;
	}

	public void setNbrCapital(int nbrCapital) {
		this.nbrCapital = nbrCapital;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@ManyToOne

	public SectorShare getCategorie() {
		return categorie;
	}
	public void setCategorie(SectorShare categorie) {
		this.categorie = categorie;
	}
	@OneToMany(mappedBy="share")

	public List<TransactionBShare> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<TransactionBShare> transaction) {
		this.transaction = transaction;
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
	public int getNbRating() {
		return nbRating;
	}
	public void setNbRating(int nbRating) {
		this.nbRating = nbRating;
	}
	
	public String getOpeningUp() {
		return openingUp;
	}
	public void setOpeningUp(String openingUp) {
		this.openingUp = openingUp;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getVolumeValues() {
		return volumeValues;
	}
	public void setVolumeValues(String volumeValues) {
		this.volumeValues = volumeValues;
	}
	public String getVolumeDT() {
		return volumeDT;
	}
	public void setVolumeDT(String volumeDT) {
		this.volumeDT = volumeDT;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getVariation() {
		return variation;
	}
	public void setVariation(String variation) {
		this.variation = variation;
	}
	public String getShareName() {
		return shareName;
	}
	public void setShareName(String shareName) {
		this.shareName = shareName;
	}
	
}
