package com.estrading.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Currencies
 *
 */
@Entity
@NamedQuery(name = "retrieveByPCurrencies", query = "select p from Currencies p ")
public class Currencies implements Serializable {

	private int idCurrencie;
	private String designation;
	private String currency;
	private String unity;
	private String sale;
	private String purchase;
	
	public Currencies() {
		super();
	}

	public Currencies( String designation, String currency,String unity, String sale, String purchase) {
		super();
		
		this.designation = designation;
		this.currency = currency;
		this.unity = unity;
		this.sale = sale;
		this.purchase = purchase;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getPurchase() {
		return purchase;
	}

	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue
	public int getIdCurrencie() {
		return this.idCurrencie;
	}

	public void setIdCurrencie(int idCurrencie) {
		this.idCurrencie = idCurrencie;
	}

	/**
	 * currency Name
	 * 
	 * @author Chams
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
