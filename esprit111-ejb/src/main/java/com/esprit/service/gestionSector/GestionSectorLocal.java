package com.esprit.service.gestionSector;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.Sector;

/**
 * Local interface for GestionSector.
 * 
 * @author MyEclipse Persistence Tools
 */
@Local
public interface GestionSectorLocal {
	/**
	 * Perform an initial save of a previously unsaved Sector entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method.
	 * 
	 * @param entity
	 *            Sector entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Sector entity);

	/**
	 * Delete a persistent Sector entity.
	 * 
	 * @param entity
	 *            Sector entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Sector entity);

	/**
	 * Persist a previously saved Sector entity and return it or a copy of it to
	 * the sender. A copy of the Sector entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity.
	 * 
	 * @param entity
	 *            Sector entity to update
	 * @return Sector the persisted Sector entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Sector update(Sector entity);

	public Sector findById(int id);

	/**
	 * Find all Sector entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Sector property to query
	 * @param value
	 *            the property value to match
	 * @return List<Sector> found by query
	 */

	/**
	 * Find all Sector entities.
	 * 
	 * @return List<Sector> all Sector entities
	 */
	public List<Sector> findAll();

	public void removeSector(Sector e);

	public List<String> findAllSector();

	public Sector findByRef(int ref);

	void deleteByRef(int ref);

	public List<Sector> findByLibelle(String libelleSector);

	public List<Sector> findByDescription(String description);

	public List<Sector> findByMatEnterprise(String matriculeEnseigant);

	public void addProject(Sector sector);
}