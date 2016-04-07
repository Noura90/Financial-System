package com.esprit.service.gestionSector;

import java.util.List;
import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esprit.entity.Enterprise;
import com.esprit.entity.Sector;
import com.log.LogUtil;

@Stateless
public class GestionSector implements GestionSectorLocal {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public void save(Sector entity) {
		LogUtil.log("saving Sector instance", Level.INFO, null);
		try {
			entityManager.persist(entity);
			LogUtil.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	
	@Override
	public void delete(Sector entity) {
		LogUtil.log("deleting Sector instance", Level.INFO, null);
		try {
			entity = entityManager.getReference(Sector.class,
					entity.getRefSector());
			entityManager.remove(entity);
			LogUtil.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	
	@Override
	public Sector update(Sector entity) {
		LogUtil.log("updating Sector instance", Level.INFO, null);
		try {
			Sector result = entityManager.merge(entity);
			LogUtil.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			LogUtil.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public Sector findById(int refProject) {
		LogUtil.log("finding Sector instance with id: " + refProject, Level.INFO,
				null);
		try {
			Sector instance = entityManager.find(Sector.class, refProject);
			return instance;
		} catch (RuntimeException re) {
			LogUtil.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllSector() {
		// TODO Auto-generated method stub
		String query = "select libelleSector from Sector";
		return entityManager.createQuery(query).getResultList();
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Sector> findAll() {
		LogUtil.log("finding all Sector instances", Level.INFO, null);
		try {
			final String queryString = "select model from Sector model";
			Query query = entityManager.createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	

	@Override
	public void removeSector(Sector e) {
		entityManager.remove(entityManager.merge(e));
	}
	
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Sector> findByLibelle(String libelleSector) {
		return entityManager
				.createQuery(
						"select p from Sector p where p.libelleSector like :plibelleSector ")
				.setParameter("plibelleSector", libelleSector).getResultList();

	}

	



	@Override
	@SuppressWarnings("unchecked")
	public List<Sector> findByDescription(String description) {
		return entityManager
				.createQuery(
						"select p from Sector p where p.description like :pdescription ")
				.setParameter("pdescription", description).getResultList();
	}



	@Override
	@SuppressWarnings("unchecked")
	public List<Sector> findByMatEnterprise(String matriculeEnseigant) {
		 return entityManager
				 .createQuery(
				 "select e from Sector e where e.enterprise.matriculeEnseigant = :matriculeEnseigant ")
				 .setParameter("matriculeEnseigant", matriculeEnseigant).getResultList();

	}


	@Override
	public Sector findByRef(int ref) {
		return entityManager.find(Sector.class, ref);

		
	}


	@Override
	public void deleteByRef(int ref) {
		entityManager.remove(entityManager.find(Sector.class,ref));
		System.out.println("ok");
		
	}


	@Override
	public void addProject(Sector sector) {
		entityManager.persist(sector);
		
	}

	@PostConstruct
	public void init() {
		save(new Sector("FOOD","FOOD"));
		save(new Sector("INSURANCE","INSURANCE"));
		save(new Sector("BANKING","BANKING"));
		save(new Sector("CHEMISTRY","CHEMISTRY"));
		save(new Sector("AUTO","AUTO"));
		save(new Sector("DISTRIBUTION","DISTRIBUTION"));
		save(new Sector("FINANCIAL","FINANCIAL"));
		save(new Sector("REALESTATE","REALESTATE"));
		save(new Sector("PHARMACEUTICAL","PHARMACEUTICAL"));
		
		
		
	}
	

}