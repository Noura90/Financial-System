package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



import com.estrading.entity.Currencies;
import com.estrading.service.CurrencieUseLocal;

/**
 * control des devises 
 * @author Chams
 *
 */

@ManagedBean(name = "CurrencieController")
@ViewScoped
public class CurrencieController {
	
	@EJB
	CurrencieUseLocal Currencieejb;
	private List<Currencies> Currencies;
	private boolean display = false;
	private Currencies Currencie = new Currencies();

	@PostConstruct
	private void init()  {
		Currencies = Currencieejb.getAll();
		
		}
	

	public String doUpdateCurrencie() {
		Currencieejb.updateCurrencie(Currencie);
		display = false;
		return "Currencies?faces-redirect=true";
	}

	public String doCancelUpdateCurrencie() {
		return "Currencies?faces-redirect=true";
	}

	public String doDeleteCurrencie() {
		Currencieejb.deleteCurrencie(Currencie);
		return "Currencies?faces-context=true";
	}

	public int CountCurrencies()
	{
		Currencies = Currencieejb.getAll();
		return Currencies.size();
	}
	
	
	/**
	 * 
	 * recuperer tout les devises en liste
	 * @get_currency
	 */

	public List<Currencies> getCurrencies() {
		return Currencies;
	}

	public void setCurrencies(List<Currencies> currencies) {
		Currencies = currencies;
	}

	public Currencies getCurrencie() {
		return Currencie;
	}

	public void setCurrencie(Currencies currencie) {
		this.Currencie = currencie;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

}
