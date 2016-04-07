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

import com.estrading.entity.Bonds;
import com.estrading.entity.Customer;
import com.estrading.entity.TransactionCustomer;
import com.estrading.service.BondsServiceLocal;
import com.estrading.service.CustomerServiceLocal;
import com.estrading.service.TransactionCustomerServiceLocal;

@ManagedBean(name = "TbondController")
@SessionScoped

public class TbondController {
	@EJB	

	BondsServiceLocal bondejb;

	private Bonds  bond=new Bonds();
	private List<Bonds> bonds;
	@EJB
	TransactionCustomerServiceLocal transactionejb;
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

	public void addTransaction(){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		TransactionCustomer transaction=new TransactionCustomer();
		
		
		transaction.setTypetransaction("Bond Transaction");
		getMessage();
		System.out.println(message);
		Customer cust = customerejb.getById(message);
		System.out.println(cust.getLogin_user());
		if(cust.getId_user()==bond.getProfessionel().getId_user())
		{
			
			FacesContext.getCurrentInstance().addMessage("formLogin:authFormMsg",new FacesMessage("this is your own bond ", "Please choose another :p"));


		}	
		
		
		
		else{
		transaction.setCustomer(cust);
		transaction.setDateTransactionCus(dateFormat.format(date));
		
transaction.setNomp2(bond.getProfessionel().getName_user());


int comparaison = "At Home".compareTo(bond.getDeleveryType());

if(comparaison==0)
{
	transaction.setDeliveryaddress(cust.getAddress_Customer());	
}

else 
{
transaction.setDeliveryaddress("At Store:  1048 Avenue Mont Parnasse Mont Plaisir Tunisie");
}
	
	
transactionejb.insertTransactionCustomer(transaction);
FacesContext.getCurrentInstance().addMessage("formLogin:authFormMsg",new FacesMessage("your transaction is done ", "Please check your list of transaction :p"));
		
Customer customer=customerejb.getById(bond.getProfessionel().getId_user());


       

int p=bond.getNombreCapital();
int pr=(int)p/10;

cust.setLiquidity(pr+cust.getLiquidity());
cust.setNbre_capital_P(cust.getNbre_capital_P()-p);
customerejb.updatecustomer(cust);		
customer.setLiquidity(pr+customer.getLiquidity());
customer.setNbre_capital_P(p+customer.getNbre_capital_P());
customerejb.updatecustomer(customer);
		bond.setStateBond("Perchased");
		bond.setAddressBuyer(cust.getAddress_Customer());
		bondejb.updateBonds(bond);
		
		
		
	}}
	public void doDeleteservice() {
bondejb.deleteBonds(bond);	}
	public Bonds getBond() {
		return bond;
	}
	public List<Bonds> getBonds() {
		bonds=bondejb.getAll();
		return bonds;
	}
	public List<TransactionCustomer> getTransactionCustomers() {
		return transactionCustomers;
	}
	public void setBond(Bonds bond) {
		this.bond = bond;
	}
	public void setBonds(List<Bonds> bonds) {
		this.bonds = bonds;
	}
	public void setTransactionCustomers(
			List<TransactionCustomer> transactionCustomers) {
		this.transactionCustomers = transactionCustomers;
	}


}
