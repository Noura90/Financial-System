package controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



import com.estrading.entity.Transactions;
import com.estrading.service.TransactionUseLocal;


@ManagedBean(name = "TransactionPortfolioController")
@ViewScoped
public class TransactionPortfolioController {
	
	@EJB
	TransactionUseLocal Transactionejb;
	private List<Transactions> Transactions;
	private boolean display = false;
	private Transactions Transaction = new Transactions();

	@PostConstruct
	private void init()  {
		Transactions = Transactionejb.getAll();
		
		}
	

	public String doUpdateTransaction() {
		Transactionejb.updateTransaction(Transaction);
		display = false;
		return "Transactions?faces-redirect=true";
	}

	public String doCancelUpdateTransaction() {
		return "Transactions?faces-redirect=true";
	}

	public String doDeleteTransaction() {
		Transactionejb.deleteTransaction(Transaction);
		return "Transactions?faces-context=true";
	}

	public int CountTransactions()
	{
		Transactions = Transactionejb.getAll();
		return Transactions.size();
	}

	public List<Transactions> getTransactions() {
		return Transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		Transactions = transactions;
	}

	public Transactions getTransaction() {
		return Transaction;
	}

	public void setTransaction(Transactions transaction) {
		this.Transaction = transaction;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

}
