package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.estrading.controller.AuthentificationController;

import com.estrading.entity.Bonds;
import com.estrading.entity.Customer;
import com.estrading.service.BondsServiceLocal;
import com.estrading.service.CustomerServiceLocal;



@ManagedBean(name = "MyBondsController")
@ViewScoped
public class MyBondsController {
	
	private List<Bonds> bonds;
	
	@EJB
	BondsServiceLocal Bondsejb;
	CustomerServiceLocal Customerejb;
	

	private boolean display = false;
	private Bonds Bond = new Bonds();
	
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
		   
		   public String doAddBond() {
				getMessage();
				Customer cust = Customerejb.getById(message);
				
				
				Bond.setStateBond("Available");

				Bond.setProfessionel(cust);

				Bondsejb.insertBonds(Bond);
				return "Bonds?faces-context=true";
			}
		   
		   @PostConstruct
			public void init() {
				getMessage();
				System.out.println(message);
			bonds = Bondsejb.retrieveByPG(message);
			}
		   
			public String doUpdateBond() {
				Bondsejb.updateBonds(Bond);
				display = false;
				return "Bonds?faces-redirect=true";
			}

			public String doCancelUpdateBond() {
				display = false;
				return "Bonds?faces-redirect=true";
			}
			public int BondsNumber()
			{
				List<Bonds> bonds = Bondsejb.getAll();
				return bonds.size();
			}

			public String doDeleteBond() {
				Bondsejb.deleteBonds(Bond);
				bonds = Bondsejb.retrieveByPG(message);
				return "Bonds?faces-context=true";
			}
			public List<Bonds> getBonds() {
				return bonds;
			}
			public void setBonds(List<Bonds> bonds) {
				this.bonds = bonds;
			}
			public Bonds getBond() {
				return Bond;
			}
			public void setBond(Bonds bond) {
				Bond = bond;
			}
			public boolean isDisplay() {
				return display;
			}

			public void setDisplay(boolean display) {
				this.display = display;
			}
}