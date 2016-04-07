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

import com.estrading.entity.Customer;
import com.estrading.entity.Shares;
import com.estrading.service.CustomerServiceLocal;
import com.estrading.service.ShareUseLocal;


@ManagedBean(name = "registerShare")
@ViewScoped
public class RegisterShare {
	
	@EJB
	ShareUseLocal Shareejb;
	@EJB
	CustomerServiceLocal Customerejb;
	
	private Shares Share = new Shares();
	 private String destination="C:/Users/Amine/git/estradingweb/ESTRADING/WebContent/resources/UploadedImages";
	 private String fileNamee;
	 
	 
	 
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
	
	 public void upload(FileUploadEvent event) {  
		 System.out.println("TEST 1");
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
	                fileNamee=fileName;
	                System.out.println(fileNamee);
	                System.out.println(fileName+" New file created!");
	                } catch (IOException e) {
	                System.out.println(e.getMessage());
	                }
	    }
	
	
	
	public String doAddShare() {
		getMessage();
		System.out.println(message);
		Customer cust = Customerejb.getById(message);
		System.out.println(cust.getLogin_user());
		
		if(fileNamee==null)
		{
			Share.setImageLink("billiard2.jpg");
		}
		else
		{
			Share.setImageLink(fileNamee);
		}
		
		
		
		
		Share.setCustomer(cust);
		System.out.println(Share.getCustomer().getLogin_user());
		Shareejb.insertShare(Share);
		return "MyShares?faces-redirect=true";
	}


	public Shares getShare() {
		return Share;
	}

	public void setShare(Shares share) {
		this.Share = share;
	}



}
