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

import com.estrading.entity.Shares;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 * Session Bean implementation class ShareUse
 */
@Stateless
@LocalBean
public class ShareUse implements ShareUseRemote, ShareUseLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public ShareUse() {
       
    }

	@Override
	public void insertShare(Shares share) {
		em.merge(share);
		
	}

	@Override
	public void updateShare(Shares share) {
		em.merge(share);
		
	}

	@Override
	public void deleteShare(Shares share) {
		em.remove(em.merge(share));
		
	}

	@Override
	public Shares getById(int id) {
		return em.find(Shares.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shares> getAll() {
		javax.persistence.Query query = em.createQuery("select e from Shares e");
		return query.getResultList();
	}
	public List<Shares>  retrieveByP(int id) {
		TypedQuery<Shares> query=em.createNamedQuery("retrieveByP",Shares  .class);
		query.setParameter("nom", id);
		return query.getResultList();
	}
	
	/*@PostConstruct
	public void initialisation() {
		
		Document doc;
		try {
		doc = Jsoup.connect("http://www.ilboursa.com/marches/aaz.aspx").get();
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
			String val6 = tds.get(6).text();
			String val7 = tds.get(7).text();

			Shares b = new Shares();
			b.setShareName(val);
			b.setOpeningUp(val1); System.out.println(val1);
			b.setHigh(val2);
			b.setLow(val3);
			b.setVolumeValues(val4);
			b.setVolumeDT(val5);
			b.setLast(val6);
			b.setVariation(val7);
			b.setNbrCapital(Integer.parseInt(val5));
			try {
			

			 insertShare(b);

			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

} catch (IOException e) {

	e.printStackTrace();
}

		
		
	}*/

	
}

