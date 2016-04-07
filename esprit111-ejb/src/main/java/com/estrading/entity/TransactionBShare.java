package com.estrading.entity;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TransactionBS
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class TransactionBShare extends TransactionCustomer implements Serializable {

	
	private String description;
	private static final long serialVersionUID = 1L;
    private Shares share;
	public TransactionBShare() {
		super();
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne

	public Shares getShare() {
		return share;
	}
	public void setShare(Shares share) {
		this.share = share;
	}
   
}
