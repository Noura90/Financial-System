package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import tn.esprit.estrading.controller.AuthentificationController;

import com.estrading.entity.Bonds;
import com.estrading.entity.Customer;
import com.estrading.service.BondsServiceLocal;
import com.estrading.service.CustomerServiceLocal;

@ManagedBean(name = "registerBond")
@ViewScoped
public class RegisterBond {

	@EJB
	BondsServiceLocal Bondejb;
	@EJB
	CustomerServiceLocal Customerejb;

	private Bonds bond = new Bonds();
	 private String destination="C:/Users/Amine/git/estrading/ESTRADING/WebContent/resources/UploadedImages";
	private String fileNamee;

	@ManagedProperty(value = "#{authenticationController}")
	private AuthentificationController messageBean;

	private int message;

	public int getMessage() {
		if (messageBean != null) {
			message = messageBean.getMessage();
		}
		return message;
	}

	public void upload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();
			fileNamee = fileName;
			System.out.println(fileNamee);
			System.out.println(fileName + " New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String doAddBond() {
		getMessage();
		Customer cust = Customerejb.getById(message);
		System.out.println(cust.getLogin_user());

		if (fileNamee == null) {
			bond.setImageLink("billiard2.jpg");
		} else {
			bond.setImageLink(fileNamee);
		}

		bond.setProfessionel(cust);
		Bondejb.insertBonds(bond);
		return "MyBonds?faces-redirect=true";
	}

	public Bonds getBond() {
		return bond;
	}

	public void setBond(Bonds bond) {
		this.bond = bond;
	}

	public void setMessageBean(AuthentificationController message) {
		this.messageBean = message;
	}

}
