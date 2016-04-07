package com.esprit.service.gestionTypeSector;

import java.util.List;
import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esprit.entity.Sector;
import com.esprit.entity.TypeSector;
import com.log.LogUtil;

@Stateless
public class GestionTypeSector implements GestionTypeSectorLocal {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TypeSector entity) {
		LogUtil.log("saving TypeSector instance", Level.INFO, null);
		try {
			entityManager.persist(entity);
			LogUtil.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public void delete(TypeSector entity) {
		LogUtil.log("deleting TypeSector instance", Level.INFO, null);
		try {
			entity = entityManager.getReference(TypeSector.class,
					entity.getIdType());
			entityManager.remove(entity);
			LogUtil.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public TypeSector update(TypeSector entity) {
		LogUtil.log("updating TypeSector instance", Level.INFO, null);
		try {
			TypeSector result = entityManager.merge(entity);
			LogUtil.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			LogUtil.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllTypeSector() {
		// TODO Auto-generated method stub
		String query = "select libelleType from TypeSector";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TypeSector> findAll() {
		LogUtil.log("finding all TypeSector instances", Level.INFO, null);
		try {
			final String queryString = "select model from TypeSector model";
			Query query = entityManager.createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public void removeTypeSector(TypeSector e) {
		entityManager.remove(entityManager.merge(e));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TypeSector> findByLibelle(String libelleTypeSector) {
		return entityManager
				.createQuery(
						"select p from TypeSector p where p.libelleType like :plibelleTypeSector ")
				.setParameter("plibelleTypeSector", libelleTypeSector)
				.getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TypeSector> findByMatEnterprise(String matriculeEnseigant) {
		return entityManager
				.createQuery(
						"select e from TypeSector e where e.enterprise.matriculeEnseigant = :matriculeEnseigant ")
				.setParameter("matriculeEnseigant", matriculeEnseigant)
				.getResultList();

	}

	@Override
	public TypeSector findById(int id) {
		return entityManager.find(TypeSector.class, id);

	}

	@Override
	public void deleteById(int id) {
		entityManager.remove(entityManager.find(TypeSector.class, id));
		System.out.println("ok");

	}
	
	@PostConstruct
	public void init() {
		save(new TypeSector("FOOD"));
		save(new TypeSector("INSURANCE"));
		save(new TypeSector("BANKING"));
		save(new TypeSector("CHEMISTRY"));
		save(new TypeSector("AUTO"));
		save(new TypeSector("DISTRIBUTION"));
		save(new TypeSector("FINANCIAL"));
		save(new TypeSector("REALESTATE"));
		save(new TypeSector("PHARMACEUTICAL"));
		
		}
	

}