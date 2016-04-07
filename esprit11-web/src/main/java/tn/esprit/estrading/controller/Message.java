package tn.esprit.estrading.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "message", eager = true)
@SessionScoped
public class Message {
	
	private String message = "Hello World!";
	
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}