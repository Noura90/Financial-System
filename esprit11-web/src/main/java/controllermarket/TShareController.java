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
import javax.transaction.Transaction;

import tn.esprit.estrading.controller.AuthentificationController;

import com.estrading.entity.Customer;
import com.estrading.entity.Shares;
import com.estrading.entity.TransactionCustomer;
import com.estrading.entity.Transactions;
import com.estrading.service.CustomerServiceLocal;
import com.estrading.service.ShareUseLocal;
import com.estrading.service.TransactionCustomerServiceLocal;
import com.estrading.service.TransactionUseLocal;


/**
 * transaction share controller
 * @author Chams
 *
 */

@ManagedBean(name = "TShareController")
@SessionScoped
public class TShareController {
@EJB	

ShareUseLocal Shareejb;
private Shares  Share=new Shares();
private List<Shares> Shares;
@EJB
TransactionCustomerServiceLocal transactionejb;

@EJB
TransactionUseLocal transactionPortfolioejb;


private List<TransactionCustomer> transactionCustomers;


@EJB
CustomerServiceLocal customerejb;
@ManagedProperty(value="#{authenticationController}")
private AuthentificationController messageBean;

private int message;


public int getMessage() {
	      if(messageBean != null){
	         message = messageBean.getMessage();
	      }       
	      return message;
	   }


	   public void setMessageBean(AuthentificationController message) {
	      this.messageBean = message;
	   }
	   
	   
public void doDeleteShare() {
Shareejb.deleteShare(Share);	
}

/**
 * renvoyer l'action
 * @author Chams
 * @return share
 */
public Shares getShare() {
	return Share;
}

/**
 * renvoie les listes des actions
 * @author Chams
 * @return shares 
 */
public List<Shares> getShares() {
	Shares=Shareejb.getAll();
	return Shares;
}
public void setShare(Shares share) {
	this.Share = share;
}
public void setShares(List<Shares> shares) {
	this.Shares = shares;
}

/**
 * ajouter la transaction au portefeuille et a la liste de transaction
 * @author Chams
 */
public void addTransaction(){
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	TransactionCustomer transaction=new TransactionCustomer();
	Transactions transactionPortfolio=new Transactions();

	transaction.setTypetransaction("Share Transaction");
	getMessage();
	System.out.println(message);
	Customer cust = customerejb.getById(message);
	System.out.println(cust.getLogin_user());
	//if(cust.getId_user()==Share.getCustomer().getId_user())
	//{
		
	//	FacesContext.getCurrentInstance().addMessage("formLogin:authFormMsg",new FacesMessage("this is your own share ", "Please choose another :p"));


//	}
//	else{
	transaction.setNbrCapital(Share.getNbrCapital());
	transaction.setShareName(Share.getShareName());
	transaction.setOpeningUp(Share.getOpeningUp());
	transaction.setHigh(Share.getHigh());
	transaction.setLow(Share.getLow());
	transaction.setVolumeValues(Share.getVolumeValues());
	transaction.setVolumeDT(Share.getVolumeDT());
	transaction.setLast(Share.getLast());
	transaction.setVariation(Share.getVariation());
	transaction.setCustomer(cust);
	transaction.setDateTransactionCus(dateFormat.format(date));
	
	
	transactionPortfolio.setName(Share.getShareName());
	transactionPortfolio.setTypeTrans("ACHAT");
	transactionPortfolio.setDateTransaction(dateFormat.format(date));
	transactionPortfolio.setCustomer(cust);
	
	
	

	
	
	
	
	transactionPortfolioejb.insertTransaction(transactionPortfolio);
	transactionejb.insertTransactionCustomer(transaction);
//	Customer customer=customerejb.getById(Share.getCustomer().getId_user());
	FacesContext.getCurrentInstance().addMessage("formLogin:authFormMsg",new FacesMessage("votre transaction est fait ", "vérifier votre portefeuille SVP !!"));

	int p=Share.getNbrCapital();
	int pr=(int)p/2;
	cust.setLiquidity(pr+cust.getLiquidity());
	cust.setNbre_capital_P(cust.getNbre_capital_P()-p);
	customerejb.updatecustomer(cust);		
	//customer.setLiquidity(pr+customer.getLiquidity());
	//customer.setNbre_capital_P(p+customer.getNbre_capital_P());
	//customerejb.updatecustomer(customer);
}

public List<TransactionCustomer> getTransactionCustomers() {
	return transactionCustomers;
}
public void setTransactionCustomers(
		List<TransactionCustomer> transactionCustomers) {
	this.transactionCustomers = transactionCustomers;
}


}
