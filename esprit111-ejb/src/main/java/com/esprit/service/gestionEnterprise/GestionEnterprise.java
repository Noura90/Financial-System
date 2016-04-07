package com.esprit.service.gestionEnterprise;


import java.util.List;
import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





import com.esprit.entity.Enterprise;
import com.estrading.entity.Currencies;
import com.log.LogUtil;



@Stateless
public class GestionEnterprise implements GestionEnterpriseLocal{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Enterprise entity) {
		LogUtil.log("saving Enterprise instance", Level.INFO, null);
		try {
			entityManager.persist(entity);
			LogUtil.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	
	@Override
	public Enterprise update(Enterprise entity) {
		LogUtil.log("updating Enterprise instance", Level.INFO, null);
		try {
			Enterprise result = entityManager.merge(entity);
			LogUtil.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			LogUtil.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public Enterprise findByMat(String mat) {
		LogUtil.log("finding Enterprise instance with matricule: " + mat,
				Level.INFO, null);
		try {
			Enterprise instance = entityManager.find(Enterprise.class, mat);
			return instance;
		} catch (RuntimeException re) {
			LogUtil.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enterprise> findByProperty(String propertyName,
			final Object value) {
		LogUtil.log("finding Enterprise instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Enterprise model where model."
					+ propertyName + "= :propertyValue";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find by property name failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enterprise> findAll() {
		LogUtil.log("finding all Enterprise instances", Level.INFO, null);
		try {
			final String queryString = "select model from Enterprise model";
			Query query = entityManager.createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public Enterprise findByUser(String login, String pwd) {
		String query = "select u from User u where u.login='" + login
				+ "' and u.password='" + pwd + "'";
		System.out.println(query);
		Enterprise u = new Enterprise();
		u = (Enterprise) entityManager.createQuery(query).getResultList()
				.get(0);
		return u;
	}

	@Override
	public void removeEnterprise(Enterprise e) {
		entityManager.remove(entityManager.merge(e));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enterprise> findByNomPrenom(String nom, String prenom) {
		return entityManager
				.createQuery(
						"select e from Enterprise e where e.nom like :enom and e.prenom like :eprenom ")
				.setParameter("enom", nom).setParameter("eprenom", prenom)
				.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enterprise> findByLoginPwd(String login, String password) {
		return entityManager
				.createQuery(
						"select e from Enterprise e where e.login like :elogin and e.password like :epassword ")
				.setParameter("elogin", login)
				.setParameter("epassword", password).getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enterprise> findByNom(String nom) {
		return entityManager
				.createQuery(
						"select e from Enterprise e where e.nom like :enom ")
				.setParameter("enom", nom).getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enterprise> findByRefSector(int refSector) {
		return entityManager
				.createQuery(
						"select e from Enterprise e where e.sector.refSector = :refSector ")
				.setParameter("refSector", refSector).getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enterprise> findByNomSector(String libelleSector) {
		return entityManager
				.createQuery(
						"select e from Enterprise e where e.sector.libelleSector = :libelleSector ")
				.setParameter("libelleSector", libelleSector).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enterprise> findByRefActivite(int refActivite) {
		return entityManager
				.createQuery(
						"select e from Enterprise e where e.activite.refActivite = :refActivite ")
				.setParameter("refActivite", refActivite).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enterprise> findByNomActivite(String nomActivite) {
		return entityManager
				.createQuery(
						"select e from Enterprise e where e.activite.nomActivite = :nomActivite ")
				.setParameter("nomActivite", nomActivite).getResultList();
	}

	@Override
	public void deleteByMat(String mat) {
		entityManager.remove(entityManager.find(Enterprise.class, mat));

	}

	@Override
	public List<String> findAllEnterprise() {
		String query = "select nom from Enterprise";
		return entityManager.createQuery(query).getResultList();
	}

	

	

	@Override
	public List<Enterprise> findAllByMat(String mat) {
		return entityManager
				.createQuery(
						"select p from Enterprise p where p.matriculeEnseigant like :pnom ")
				.setParameter("pnom",mat).getResultList();
	}

	public int volumeHoraireTotalParEnterprise(String matEnterprise) {
		return 0;
	}

	public int volumeHoraireTotalParEnterpriseActivite(String matEnterprise) {
		return 0;
	}
	
	
	
	@PostConstruct
	public void init() {
save(new Enterprise("SFBT, Société Frigorifique et Brasserie de Tunis","1","31.010","0.03","31.080","31.010","2 790 900 000","29,946-28,421","25 506","90 000 000","24,81x/13,11x","1.25","0,650"," ","13.530->31.010","+37.82%","56 hausses / 39 baisses","1"));
save(new Enterprise("La Société de Production Agricole Téboulba","1","-0.9%","3.330","3.300	","38 981 250","3,238-3,148","10 286","11 812 500","82,50x/13,11x","0.040","0","0"," ","2.790->3.300","+9.63%","41 hausses/ 45 baisses","2"));
save(new Enterprise("Land'Or","1","6.420","-0.61%","6.420","6.250","30 174 000","6,601-6,814","7 314","4 700 000","n.dx/13,11x","-1.294","0"," ","10.480->6.420","+18.45%","25 hausses /29 baisses","3"));
save(new Enterprise("ELBENE INDUSTRIE","4","3.680","0","n.d","n.d","36 800 000","3,631-3,800","103","10 000 000","46,00x/13,11x","0.08","0"," ","3.980->3.680","-10.24%","8 hausses/  4 baisses","4"));
save(new Enterprise("BIAT, Banque Internationale Arabe de Tunisie","5","83.000","0","83.900","83.000","1 411 000 000","82,353-82,773","766","17 000 000","17,70x/13,11x","4.69","2.000","04/07/2010","62.500->83.000","+6.41%","46 hausses / 38 baisses","5"));
save(new Enterprise("ATB, Arab Tunisian Bank","1","4.680","0.64","4.680","4.600","468 000 000","4,445-4,690","2 276","100 000 000","15,10x/13,11x","0.310","0","03/06/2011","4.600->4.680","+7.09%","45 hausses  /40 baisses","6"));
save(new Enterprise("Attijari Bank de Tunisie","1","6.420","-0.61%","6.420","6.250","30 174 000","6,601-6,814","7 314","4 700 000","n.dx/13,11x","-1.294","0"," ","10.480->6.420","+18.45%","25 hausses / 29 baisses","7"));
save(new Enterprise("Société des Industries Pharmaceutiques de Tunisie - SIPHAT -, Société Frigorifique et Brasserie de Tunis","1","31.010","0.03","31.080","31.010","2 790 900 000","29,946-28,421","25 506","90 000 000","24,81x/13,11x","1.25","0,650"," ","13.530->31.010","+37.82%","56 hausses /  39 baisses","8"));
save(new Enterprise("ADWYA, Banque Internationale Arabe de Tunisie","5","83.000","0","83.900","83.000","1 411 000 000","82,353-82,773","766","17 000 000","17,70x/13,11x","4.69","2.000","04/07/2010","62.500->83.000","+6.41%","46 hausses / 38 baisses","9"));	
save(new Enterprise("ASTREE, Compagnie d'Assurances et de Réassurances","1","6.420","-0.61%","6.420","6.250","30 174 000","6,601-6,814","7 314","4 700 000","n.dx/13,11x","-1.294","0"," ","10.480->6.420","+18.45%","25 hausses / 29 baisses","10"));
save(new Enterprise("STAR, Société Tunisienne d'Assurances et de Réassurances","4","3.680","0","n.d","n.d","36 800 000","3,631-3,800","103","10 000 000","46,00x/13,11x","0.08","0"," ","3.980->3.680","-10.24%","8 hausses / 4 baisses","11"));
save(new Enterprise("ESSOUKNA","1","31.010","0.03","31.080","31.010","2 790 900 000","29,946-28,421","25 506","90 000 000","24,81x/13,11x","1.25","0,650"," ","13.530->31.010","+37.82%","56 hausses / 39 baisses","12"));
save(new Enterprise("SIMPAR, Société Immobilière et de participations","1","-0.9%","3.330","3.300	","38 981 250","3,238-3,148","10 286","11 812 500","82,50x/13,11x","0.040","0","0"," ","2.790->3.300","+9.63%","41 hausses / 45 baisses","13"));

	
	
	
	}
	
	
	}