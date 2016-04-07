package controllermarket;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.estrading.controller.AuthentificationController;

import com.estrading.entity.Customer;
import com.estrading.entity.TransactionCustomer;
import com.estrading.entity.Transactions;
import com.estrading.service.BondsServiceLocal;
import com.estrading.service.CustomerServiceLocal;
import com.estrading.service.TransactionCustomerServiceLocal;
import com.estrading.service.TransactionUseLocal;

/**
 * Transaction Controller pour le client
 * @author Chams
 *
 */
@ManagedBean(name = "TransactionController")
@SessionScoped
public class TransactionController {
	@EJB	
	TransactionCustomerServiceLocal transactionejb;
	@EJB
	CustomerServiceLocal customerejb;
	
	@EJB
	TransactionUseLocal transactionPortfolioejb;
	
	@ManagedProperty(value="#{authenticationController}")
	private AuthentificationController messageBean;

	private int message;
     
	
	@EJB
	BondsServiceLocal Bondsejb;
	CustomerServiceLocal Customerejb;

	public int getMessage() {
		      if(messageBean != null){
		         message = messageBean.getMessage();
		      }       
		      return message;
		   }
		   public void setMessageBean(AuthentificationController message) {
		      this.messageBean = message;
		   }
	private List<TransactionCustomer> transactionCustomers;
	private TransactionCustomer transactionCustomer;
	
	
	/**
	 * liste des transactions des clients 
	 * @return transactionCustomers
	 * @author Chams
	 */
	public List<TransactionCustomer> getTransactionCustomers() {
		getMessage();
		System.out.println(message);
		Customer cust = customerejb.getById(message);
		int id;
		id=cust.getId_user();
		transactionCustomers=transactionejb.retrieveByPT(id);

		return transactionCustomers;
	}
	public int TransactionsNumber()
	{
		transactionCustomers=transactionejb.getAll();
		return transactionCustomers.size();
	}
	

	
	
	
	public TransactionCustomer getTransactionCustomer() {
		return transactionCustomer;
	}
	public void setTransactionCustomers(
			List<TransactionCustomer> transactionCustomers) {
		this.transactionCustomers = transactionCustomers;
	}
	public void setTransactionCustomer(TransactionCustomer transactionCustomer) {
		this.transactionCustomer = transactionCustomer;
	}
	public void doDeleteTransaction() {
		transactionejb.deleteTransactionCustomer(transactionCustomer);	}
	
	/**
	 * delete tansaction in the portfolio in sale
	 * @param nothing
	 * @author Chams
	 */
	public void doDeleteTransaction1() {

		
		Customer cust = customerejb.getById(message);
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Transactions transactionPortfolio=new Transactions();
		int p=transactionCustomer.getNbrCapital();
		
		int pr=(int)p/2;
		cust.setLiquidity(cust.getLiquidity()-pr);
		cust.setNbre_capital_P(cust.getNbre_capital_P()+pr);
		customerejb.updatecustomer(cust);
		transactionejb.deleteTransactionCustomer(transactionCustomer);
		
		transactionPortfolio.setTypeTrans("VENTE");
		transactionPortfolio.setDateTransaction(dateFormat.format(date));
		transactionPortfolio.setCustomer(cust);
		transactionPortfolio.setName(transactionCustomer.getShareName());;
		
		
		transactionPortfolioejb.insertTransaction(transactionPortfolio);
	}
	
	
	public void transformpoints()
	   { 
		   getMessage();
		Customer cust = customerejb.getById(message);
		int a=(int)cust.getLiquidity()/5;

		if(cust.getLiquidity()>5)
		{cust.setLiquidity(cust.getLiquidity()%5);
		cust.setNbre_capital_P(cust.getNbre_capital_P()+a);
	customerejb.updatecustomer(cust);}
		else{
			
			FacesContext.getCurrentInstance().addMessage("formLogin:authFormMsg",new FacesMessage("Failed!!","you don't have enougth capitals"));

		}
	   }
	   public Customer iscust()
	   {
		 getMessage();
		 return customerejb.getById(message);
		   
	   }
			
}
