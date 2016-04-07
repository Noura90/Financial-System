package com.estrading.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TransactionBG
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class TransactionBBond extends TransactionCustomer implements Serializable {

	
	private String description;
	private static final long serialVersionUID = 1L;
	private Bonds bond;

	public TransactionBBond() {
		super();
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne

	public Bonds getBond() {
		return bond;
	}
	public void setBond(Bonds bond) {
		this.bond = bond;
	}
   
}
