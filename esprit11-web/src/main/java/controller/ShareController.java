package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.estrading.entity.Shares;
import com.estrading.service.ShareUseLocal;


@ManagedBean(name = "ShareController")
@ViewScoped
public class ShareController {
	
	@EJB
	ShareUseLocal Shareejb;
	private List<Shares> Shares;
	private boolean display = false;
	private Shares Share = new Shares();

	@PostConstruct
	private void init()  {
		Shares = Shareejb.getAll();
		
		}
	

	public String doUpdateShare() {
		Shareejb.updateShare(Share);
		display = false;
		return "shares?faces-redirect=true";
	}

	public String doCancelUpdateShare() {
		return "shares?faces-redirect=true";
	}

	public String doDeleteShare() {
		Shareejb.deleteShare(Share);
		return "shares?faces-context=true";
	}

	public int CountShares()
	{
		Shares = Shareejb.getAll();
		return Shares.size();
	}

	public List<Shares> getShares() {
		return Shares;
	}

	public void setShares(List<Shares> shares) {
		Shares = shares;
	}

	public Shares getShare() {
		return Share;
	}

	public void setShare(Shares share) {
		this.Share = share;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

}
