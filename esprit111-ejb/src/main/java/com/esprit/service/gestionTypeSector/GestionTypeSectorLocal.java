package com.esprit.service.gestionTypeSector;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.TypeSector;

/**
 * Local interface for GestionSector.
 * 
 * @author MyEclipse Persistence Tools
 */
@Local
public interface GestionTypeSectorLocal {

	public void save(TypeSector entity);

	public void delete(TypeSector entity);

	public TypeSector update(TypeSector entity);

	public List<TypeSector> findAll();

	public void removeTypeSector(TypeSector e);

	public List<String> findAllTypeSector();

	public TypeSector findById(int id);

	void deleteById(int id);

	public List<TypeSector> findByLibelle(String libelleTypeSector);

	public List<TypeSector> findByMatEnterprise(String matriculeEnseigant);
	
	
}