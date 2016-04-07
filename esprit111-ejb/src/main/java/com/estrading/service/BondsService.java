package com.estrading.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.esprit.entity.Enterprise;
import com.estrading.entity.Bonds;



/**
 * Session Bean implementation class BondsService
 */
@Stateless
@LocalBean
public class BondsService implements BondsServiceRemote, BondsServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
    public BondsService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insertBonds(Bonds bonds) {
		// TODO Auto-generated method stub
		entityManager.persist(bonds);
		
	}

	@Override
	public void updateBonds(Bonds bonds) {
		// TODO Auto-generated method stub
		entityManager.merge(bonds);
		
	}

	@Override
	public void deleteBonds(Bonds bonds) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(bonds));
	}

	@Override
	public Bonds getById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Bonds.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bonds> getAll() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = entityManager.createQuery("select g from Bonds g");
		return query.getResultList();
	}

	public List<Bonds>  retrieveByPG(int id) {
		// TODO Auto-generated method stub
		
		
		TypedQuery<Bonds> query=entityManager.createNamedQuery("retrieveByPG",Bonds  .class);
		query.setParameter("nom", id);
		return query.getResultList();
	}
	
	
	/*@PostConstruct
	public void init() {
		insertBonds(new Bonds("BOND1",1,"very high option","yes",100 ));
		insertBonds(new Bonds("BOND1",1,"very high option","yes",100 ));
		insertBonds(new Bonds("BOND1",1,"very high option","yes",100 ));
		insertBonds(new Bonds("BOND1",1,"very high option","yes",100 ));
		insertBonds(new Bonds("BOND1",1,"very high option","yes",100 ));
		insertBonds(new Bonds("BOND1",1,"very high option","yes",100 ));
		insertBonds(new Bonds("BOND1",1,"very high option","yes",100 ));
		insertBonds(new Bonds("BOND1",1,"very high option","yes",100 ));
	
	
	
	
	}*/
}
