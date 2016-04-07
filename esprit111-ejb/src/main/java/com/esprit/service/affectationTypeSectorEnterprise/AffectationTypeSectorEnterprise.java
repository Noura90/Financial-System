package com.esprit.service.affectationTypeSectorEnterprise;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.Enterprise;
import com.esprit.entity.Sector;
import com.esprit.entity.TypeSector;
import com.esprit.entity.TypeSectorSectorEnterprise;

/**
 * Session Bean implementation class AffectationUniteEnterprisePromotion
 */
@Stateless
@LocalBean
public class AffectationTypeSectorEnterprise implements AffectationTypeSectorEnterpriseLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AffectationTypeSectorEnterprise() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createEnterprise(Enterprise enterprise) {
		entityManager.persist(enterprise);

	}

	@Override
	public void createTypeSector(TypeSector typeSector) {
		entityManager.persist(typeSector);

	}

	@Override
	public void createSector(Sector sector) {
		entityManager.persist(sector);

	}

	@Override
	public Enterprise getEnterpriseByMat(String matriculeEnseigant) {
		return entityManager.find(Enterprise.class, matriculeEnseigant);

	}

	@Override
	public TypeSector getTypeSectorById(int id) {
		return entityManager.find(TypeSector.class, id);

	}

	@Override
	public Sector getSectorById(int id) {
		return entityManager.find(Sector.class, id);

	}

	@Override
	public void createAffectationETPP(Enterprise enterprise,TypeSector typeSector, Sector Sector, int semestre,int volumeHoraire, boolean statut, int periode) {
		TypeSectorSectorEnterprise typeSectorSectorEnterprise = new TypeSectorSectorEnterprise(
				entityManager.merge(typeSector),
				entityManager.merge(enterprise), entityManager.merge(Sector),
				statut, volumeHoraire, semestre, periode);
		entityManager.persist(typeSectorSectorEnterprise);
		
		

	}

	@Override
	public List<TypeSectorSectorEnterprise> findAllByNomEnterprise(String nomEnterprise) {
		return entityManager
				.createQuery(
						"select p from TypeSectorSectorEnterprise p where p.enterprise.nom like :pnom ")
				.setParameter("pnom", nomEnterprise).getResultList();
	}

	@Override
	public List<TypeSectorSectorEnterprise> findAllByNomType(String nom) {
		return entityManager
				.createQuery(
						"select p from TypeSectorSectorEnterprise p where p.typeSector.libelleType like :pnom ")
				.setParameter("pnom", nom).getResultList();
	}

	@Override
	public List<TypeSectorSectorEnterprise> findAllByNomSector(String nom) {
		return entityManager
				.createQuery(
						"select p from TypeSectorSectorEnterprise p where p.sector.libelleSector like :pnom ")
				.setParameter("pnom", nom).getResultList();
	}

}
