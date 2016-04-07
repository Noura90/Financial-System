package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import tn.esprit.estrading.controller.AuthentificationController;

import com.estrading.entity.Customer;
import com.estrading.entity.Shares;
import com.estrading.service.CustomerServiceLocal;
import com.estrading.service.ShareUseLocal;


@ManagedBean(name = "MyShareController")
@ViewScoped
public class MyShareController {
	
	@EJB
	ShareUseLocal Shareejb;
	CustomerServiceLocal Customerejb;
	private List<Shares> Shares;
	private boolean display = false;
	private Shares share = new Shares();
	
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
	   

	public String doAddShare() {
		getMessage();
		System.out.println(message);
		Customer cust = Customerejb.getById(message);
		share.setCustomer(cust);
		System.out.println(share.getCustomer().getLogin_user());
		Shareejb.insertShare(share);
		return "shares?faces-context=true";
	}
	
	
	@PostConstruct
	public void init() {
		getMessage();
		System.out.println(message);
		Shares = Shareejb.retrieveByP(message);
	
	}

	public String doUpdateShare() {
		Shareejb.updateShare(share);
		display = false;
		return "shares?faces-redirect=true";
	}

	public String doCancelUpdateShare() {
		display = false;
		return "shares?faces-redirect=true";
	}

	public String doDeleteShare() {
		Shareejb.deleteShare(share);
		Shares = Shareejb.retrieveByP(message);
		return "shares?faces-context=true";
	}

	public List<Shares> getShares() {
		return Shares;
	}

	public void setShares(List<Shares> shares) {
		Shares = shares;
	}

	public Shares getShare() {
		return share;
	}

	public void setShare(Shares share) {
		this.share = share;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}
	
	

}
