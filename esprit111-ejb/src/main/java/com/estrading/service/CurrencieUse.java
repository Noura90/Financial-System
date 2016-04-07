package com.estrading.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.estrading.entity.Currencies;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 * Session Bean implementation class CurrencieUse
 */
@Stateless
@LocalBean
public class CurrencieUse implements  CurrencieUseLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public CurrencieUse() {
       
    }

	@Override
	public void insertCurrencie(Currencies currencie) {
		em.merge(currencie);
		
	}

	@Override
	public void updateCurrencie(Currencies currencie) {
		em.merge(currencie);
		
	}

	@Override
	public void deleteCurrencie(Currencies currencie) {
		em.remove(em.merge(currencie));
		
	}

	@Override
	public Currencies getById(int id) {
		return em.find(Currencies.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Currencies> getAll() {
		javax.persistence.Query query = em.createQuery("select e from Currencies e");
		return query.getResultList();
	}
	public List<Currencies>  retrieveByPCurrencies(int id) {
		TypedQuery<Currencies> query=em.createNamedQuery("retrieveByPPCurrencies",Currencies  .class);
		query.setParameter("nom", id);
		return query.getResultList();
	}
	
	/*@PostConstruct
	public void init() {
		
		insertCurrencie(new Currencies("Dirham UAE","AED","10","5.132","5.274"));
		insertCurrencie(new Currencies("Dinar Bahrainien","BHD","1","5","5.137"));
		insertCurrencie(new Currencies("Dollar Canadien","CAD","1","1.566","1.61"));
		insertCurrencie(new Currencies("Franc Suisse","CHF","10","20.037","20.585"));
		insertCurrencie(new Currencies("Couronne Danoise","DKK","100","28.1","28.869"));
		insertCurrencie(new Currencies("Euro","EUR","1","2.098","2.156"));
		insertCurrencie(new Currencies("Livre Sterling","GBP","1","2.909","2.989"));
		insertCurrencie(new Currencies("Yen Japonais","JPY","1000","15.86","16.294"));
		insertCurrencie(new Currencies("Dinar Koweitien","KWD","1","6.248","6.42"));
		insertCurrencie(new Currencies("Couronne Norvégienne ","NOK","100","25.034","25.719"));
		insertCurrencie(new Currencies("Ryal Quatarien ","QAR","10","5.179","5.321"));
		insertCurrencie(new Currencies("Ryal Saoudien ","SAR","10","5.027","5.165"));
		insertCurrencie(new Currencies("Couronne Suédoise ","SEK","10","2.259","2.322"));
		insertCurrencie(new Currencies("Dollar des Etats-Unis","USD","1","1.886","1.936"));
		
		
		
	/*	Document doc;
		try {
		doc = Jsoup.connect("http://www.boursereflex.com/bourse/Devises").get();
		String titre = doc.title();
		System.out.println(titre);

		Element table = doc.select("table").get(0);
		Element tbody = table.select("tbody").get(0);
		Elements rows = tbody.select("tr");
		for (int i = 1; i < rows.size(); i++) {
			Element row = rows.get(i);
			Elements tds = row.select("td");

			// System.out.println(tds.text());
			String val = tds.get(0).text();
			String val1 = tds.get(1).text();
			String val2 = tds.get(2).text();
			String val3 = tds.get(3).text();
			String val4 = tds.get(4).text();
			String val5 = tds.get(5).text();
			

			Currencies b = new Currencies();
			b.setCurrency(val);
			b.setTnd(val1); System.out.println(val1);
			b.setEur(val2);
			b.setGbp(val3);
			b.setJpy(val4);
			b.setUsd(val5);
		
		
			try {
			

			 insertCurrencie(b);

			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

} catch (IOException e) {

	e.printStackTrace();
}


		
		
	} */

	
}

