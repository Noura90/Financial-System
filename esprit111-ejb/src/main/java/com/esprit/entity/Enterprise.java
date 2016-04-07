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
 * Entity implementation class for Entity: Enterprise
 * 
 */
@Entity
public class Enterprise implements Serializable {

	

	// *********** chams add ******************
	
	
	private String nom;
	private String nominalValue;
	private String cours;
	
	private String lastClosingVariation;

	private String bid;
	private String ask;
	private String capitalMarket;
	private String mMtwentyMMfifty;
	private String anualAverageExchangeQuotation;
	
	private String sharesNumber;
	private String priceEarningsRatio;
    private String beneficePerAction;
    private String lastDividend;
    private String distributionDate;
    private String AnnuelVariation;
    private String rdtAjustéDepuisLe31_12_2014;
    private String advance_Decline ;
    private String matriculeEnterprise;

	
	
	
	
 




	public Enterprise(String nom, String nominalValue, String cours,
			String lastClosingVariation, String bid, String ask,
			String capitalMarket, String mMtwentyMMfifty,
			String anualAverageExchangeQuotation, String sharesNumber,
			String priceEarningsRatio, String beneficePerAction,
			String lastDividend, String distributionDate,
			String annuelVariation, String rdtAjustéDepuisLe31_12_2014,
			String advance_Decline, String matriculeEnterprise) {
		super();
		this.nom = nom;
		this.nominalValue = nominalValue;
		this.cours = cours;
		this.lastClosingVariation = lastClosingVariation;
		this.bid = bid;
		this.ask = ask;
		this.capitalMarket = capitalMarket;
		this.mMtwentyMMfifty = mMtwentyMMfifty;
		this.anualAverageExchangeQuotation = anualAverageExchangeQuotation;
		this.sharesNumber = sharesNumber;
		this.priceEarningsRatio = priceEarningsRatio;
		this.beneficePerAction = beneficePerAction;
		this.lastDividend = lastDividend;
		this.distributionDate = distributionDate;
		this.AnnuelVariation = annuelVariation;
		this.rdtAjustéDepuisLe31_12_2014 = rdtAjustéDepuisLe31_12_2014;
		this.advance_Decline = advance_Decline;
		this.matriculeEnterprise = matriculeEnterprise;
	}


	public Enterprise() {
		super();
	}


	public String getNominalValue() {
		return nominalValue;
	}

	public void setNominalValue(String nominalValue) {
		this.nominalValue = nominalValue;
	}

	public String getLastClosingVariation() {
		return lastClosingVariation;
	}

	public void setLastClosingVariation(String lastClosingVariation) {
		this.lastClosingVariation = lastClosingVariation;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getCapitalMarket() {
		return capitalMarket;
	}

	public void setCapitalMarket(String capitalMarket) {
		this.capitalMarket = capitalMarket;
	}

	
	public String getAnualAverageExchangeQuotation() {
		return anualAverageExchangeQuotation;
	}

	public void setAnualAverageExchangeQuotation(
			String anualAverageExchangeQuotation) {
		this.anualAverageExchangeQuotation = anualAverageExchangeQuotation;
	}

	public String getSharesNumber() {
		return sharesNumber;
	}

	public void setSharesNumber(String sharesNumber) {
		this.sharesNumber = sharesNumber;
	}


	public String getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(String lastDividend) {
		this.lastDividend = lastDividend;
	}

	


	
	


	public String getmMtwentyMMfifty() {
		return mMtwentyMMfifty;
	}

	public void setmMtwentyMMfifty(String mMtwentyMMfifty) {
		this.mMtwentyMMfifty = mMtwentyMMfifty;
	}

	public String getPriceEarningsRatio() {
		return priceEarningsRatio;
	}

	public void setPriceEarningsRatio(String priceEarningsRatio) {
		this.priceEarningsRatio = priceEarningsRatio;
	}

	public String getBeneficePerAction() {
		return beneficePerAction;
	}

	public void setBeneficePerAction(String beneficePerAction) {
		this.beneficePerAction = beneficePerAction;
	}

	public String getDistributionDate() {
		return distributionDate;
	}

	public void setDistributionDate(String distributionDate) {
		this.distributionDate = distributionDate;
	}

	public String getRdtAjustéDepuisLe31_12_2014() {
		return rdtAjustéDepuisLe31_12_2014;
	}

	public void setRdtAjustéDepuisLe31_12_2014(String rdtAjustéDepuisLe31_12_2014) {
		this.rdtAjustéDepuisLe31_12_2014 = rdtAjustéDepuisLe31_12_2014;
	}

	public String getAdvance_Decline() {
		return advance_Decline;
	}

	public void setAdvance_Decline(String advance_Decline) {
		this.advance_Decline = advance_Decline;
	}








	private List<TypeSectorSectorEnterprise> typeSectorSectorEnterprises;

	private List<TypeSector> typeSectors;
	private List<Sector> sectors;
	private Sector sector;
	private TypeSector typeSector;
	
	
	private TypeSectorSectorEnterprise typePEnterprise;
	

	

	private static final long serialVersionUID = 1L;



	@Id
	
	public String getMatriculeEnterprise() {
		return matriculeEnterprise;
	}

	public void setMatriculeEnterprise(String matriculeEnterprise) {
		this.matriculeEnterprise = matriculeEnterprise;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



	
	



	// ********** affichage par Sector **************

	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	@ManyToOne
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	

	

	


	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
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

	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<TypeSectorSectorEnterprise> getTypeSectorSectorEnterprises() {
		return typeSectorSectorEnterprises;
	}

	public void setTypeSectorSectorEnterprises(
			List<TypeSectorSectorEnterprise> typeSectorSectorEnterprises) {
		this.typeSectorSectorEnterprises = typeSectorSectorEnterprises;
	}
	
	//********************** affichage details pas Enterprise ****************

	
	@ManyToOne
	public TypeSectorSectorEnterprise getTypePEnterprise() {
		return typePEnterprise;
	}

	public void setTypePEnterprise(TypeSectorSectorEnterprise typePEnterprise) {
		this.typePEnterprise = typePEnterprise;
	}

	public String getCours() {
		return cours;
	}

	public void setCours(String cours) {
		this.cours = cours;
	}


	public String getAnnuelVariation() {
		return AnnuelVariation;
	}


	public void setAnnuelVariation(String annuelVariation) {
		AnnuelVariation = annuelVariation;
	}

	

}
