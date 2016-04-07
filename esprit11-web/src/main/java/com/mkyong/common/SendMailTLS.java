package com.mkyong.common;

import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.estrading.entity.Customer;
import com.estrading.service.CustomerServiceLocal;

@ManagedBean
@SessionScoped
public class SendMailTLS {
	@EJB
	CustomerServiceLocal customerEJB;
	public String destinatioMail = "chamseddine.jbari@esprit.tn";
	public Customer customer = new Customer();
	

	public void sendmail() {

		
		
		final String username = "chamseddine.jbari@esprit.tn";
		final String password = "13604046";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			customer = customerEJB.retryByGmail(destinatioMail).get(0);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ESTRADING"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destinatioMail));
			message.setSubject("ESTRADING");
			message.setText("Dear customer your password is :"
					+ customer.getPassword_user());

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public String getDestinatioMail() {
		return destinatioMail;
	}

	public void setDestinatioMail(String destinatioMail) {
		this.destinatioMail = destinatioMail;
	}
}