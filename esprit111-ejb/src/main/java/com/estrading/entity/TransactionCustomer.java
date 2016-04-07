package com.estrading.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TransactionB
 * 
 */
@Entity
@NamedQuery(name="retrieveByPT", query ="select p from TransactionCustomer p where p.customer.id_user= :nom")

public class TransactionCustomer implements Serializable {

	private int IdTransactionCus;
	private String DateTransactionCus;
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private String typetransaction;
	private String nomp2;
	private String deliveryaddress;
	
	
	private int nbrCapital;
	private String shareName;
	private String openingUp;
	private String high;
	private String low;
	private String volumeValues;
	private String volumeDT;
	private String last;
	private String variation;
	private String purshase;
	private String sell;

	public String getTypetransaction() {
		return typetransaction;
	}

	public void setTypetransaction(String typetransaction) {
		this.typetransaction = typetransaction;
	}

	public TransactionCustomer() {
		super();
	}

	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTransactionCus() {
		return this.IdTransactionCus;
	}

	public void setTransactionCus(int IdTransactionB) {
		this.IdTransactionCus = IdTransactionB;
	}

	public String getDateTransactionCus() {
		return this.DateTransactionCus;
	}

	public void setDateTransactionCus(String DateTransactionB) {
		this.DateTransactionCus = DateTransactionB;
	}

	public String getNomp2() {
		return nomp2;
	}

	public void setNomp2(String nomp2) {
		this.nomp2 = nomp2;
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}

	public int getIdTransactionCus() {
		return IdTransactionCus;
	}

	public void setIdTransactionCus(int idTransactionCus) {
		IdTransactionCus = idTransactionCus;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
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

	public int getNbrCapital() {
		return nbrCapital;
	}

	public void setNbrCapital(int nbrCapital) {
		this.nbrCapital = nbrCapital;
	}

	public String getPurshase() {
		return purshase;
	}

	public void setPurshase(String purshase) {
		this.purshase = purshase;
	}

	public String getSell() {
		return sell;
	}

	public void setSell(String sell) {
		this.sell = sell;
	}

}
