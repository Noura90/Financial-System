package com.estrading.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.estrading.entity.SectorShare;

/**
 * Session Bean implementation class SectorShareService
 */
@Stateless
@LocalBean
public class SectorShareService implements SectorShareServiceRemote, SectorShareServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext

	EntityManager em;
    public SectorShareService() {
    	
        // TODO Auto-generated constructor stub
  
    }

	@Override
	public void insertSectorShare(SectorShare sectorshare) {
		// TODO Auto-generated method stub
		em.persist(sectorshare);
		
	}

	@Override
	public void updateSectorShare(SectorShare sectorshare) {
		// TODO Auto-generated method stub
		em.merge(sectorshare);
		
	}

	@Override
	public void deleteSectorShare(SectorShare sectorshare) {
		// TODO Auto-generated method stub
		em.remove(em.merge(sectorshare));

		
		
	}

	@Override
	public SectorShare getById(int id) {
		// TODO Auto-generated method stub
		return em.find(SectorShare.class, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SectorShare> getAll() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = em.createQuery("select c from SectorShare c");
		return query.getResultList();	}
	}


