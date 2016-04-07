package com.estrading.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.estrading.entity.SectorBond;

/**
 * Session Bean implementation class SectorBondService
 */
@Stateless
@LocalBean
public class SectorBondService implements SectorBondServiceRemote, SectorBondServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext

	EntityManager em;
    public SectorBondService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insertSectorBond(SectorBond sectorbond) {
		// TODO Auto-generated method stub
		em.persist(sectorbond);
	}

	@Override
	public void updateSectorBond(SectorBond sectorbond) {
		// TODO Auto-generated method stub
		em.merge(sectorbond);
	}

	@Override
	public void deleteSectorBond(SectorBond sectorbond) {
		// TODO Auto-generated method stub
		em.remove(em.merge(sectorbond));
	}

	@Override
	public SectorBond getById(int id) {
		// TODO Auto-generated method stub
		return em.find(SectorBond.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SectorBond> getAll() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = em.createQuery("select c from SectorBond c");
		return query.getResultList();
	}

}
