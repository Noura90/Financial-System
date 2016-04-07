package controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.estrading.controller.AuthentificationController;

import com.estrading.entity.TransactionCustomer;
import com.estrading.service.TransactionCustomerService;
import com.estrading.service.TransactionCustomerServiceLocal;



@ManagedBean(name= "deliveryController")
@ViewScoped
public class deliveryController {
	
	
	public List<TransactionCustomer> transactioncustomers;
	
	
	@EJB
	TransactionCustomerServiceLocal deliveryejb;
	
	
	private boolean display = false;
	private TransactionCustomer transactionb=new TransactionCustomer();
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
	
		   
		   
		   @PostConstruct
			public void init() {
				getMessage();
				System.out.println(message);
				transactioncustomers = deliveryejb.retrieveByPT(message);
			}
		   
			public String doUpdateAddress() {
				deliveryejb.updateTransactionCustomer(transactionb);
				display = false;
				return "TransactionCustomer?faces-redirect=true";
			}

			public int TransactionCNumber()
			{
				List<TransactionCustomer> transactionn = deliveryejb.getAll();
				return transactionn.size();
			}
			public List<TransactionCustomer> getTransactioncustomers() {
				return transactioncustomers;
			}
			public void setTransactioncustomers(
					List<TransactionCustomer> transactioncustomers) {
				this.transactioncustomers = transactioncustomers;
			}
			public TransactionCustomerServiceLocal getDeliveryejb() {
				return deliveryejb;
			}
			public void setDeliveryejb(TransactionCustomerService deliveryejb) {
				this.deliveryejb = deliveryejb;
			}
			public boolean isDisplay() {
				return display;
			}
			public void setDisplay(boolean display) {
				this.display = display;
			}
			
			
			
			
			
			public TransactionCustomer getTransactionb() {
				return transactionb;
			}
			public void setTransactionb(TransactionCustomer transactionb) {
				this.transactionb = transactionb;
			}
			public AuthentificationController getMessageBean() {
				return messageBean;
			}
			public void setMessage(int message) {
				this.message = message;
			}



	

	
	
	
}
