package com.esprit.service.gestionEnterprise;

import java.util.List;
import javax.ejb.Local;

import com.esprit.entity.Enterprise;

/**
 * Local interface for GestionEnterprise.
 * 
 * @author MyEclipse Persistence Tools
 */
@Local
public interface GestionEnterpriseLocal {
	/**
	 * Perform an initial save of a previously unsaved Enterprise entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method.
	 * 
	 * @param entity
	 *            Enterprise entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Enterprise entity);

	/**
	 * Delete a persistent Enterprise entity.
	 * 
	 * @param entity
	 *            Enterprise entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
//	public void delete(Enterprise entity);

	/**
	 * Persist a previously saved Enterprise entity and return it or a copy of
	 * it to the sender. A copy of the Enterprise entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity.
	 * 
	 * @param entity
	 *            Enterprise entity to update
	 * @return Enterprise the persisted Enterprise entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Enterprise update(Enterprise entity);

	public Enterprise findByMat(String mat);
	public List<Enterprise> findAllByMat(String mat);
	

	
	/**
	 * Find all Enterprise entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Enterprise property to query
	 * @param value
	 *            the property value to match
	 * @return List<Enterprise> found by query
	 */
	public List<Enterprise> findByProperty(String propertyName, Object value);

	/**
	 * Find all Enterprise entities.
	 * 
	 * @return List<Enterprise> all Enterprise entities
	 */
	public List<Enterprise> findAll();

	public List<String> findAllEnterprise();

	public Enterprise findByUser(String login, String pwd);

	public void removeEnterprise(Enterprise e);

	public List<Enterprise> findByNomPrenom(String nom, String prenom);

	public List<Enterprise> findByLoginPwd(String login, String password);

	public List<Enterprise> findByNom(String nom);

	public List<Enterprise> findByRefSector(int refSector);

	public List<Enterprise> findByNomSector(String libelleSector);

	public List<Enterprise> findByRefActivite(int refActivite);

	public List<Enterprise> findByNomActivite(String nomActivite);

	public void deleteByMat(String mat);
	
	public int volumeHoraireTotalParEnterprise(String matEnterprise);
	
	public int volumeHoraireTotalParEnterpriseActivite(String matEnterprise);


}