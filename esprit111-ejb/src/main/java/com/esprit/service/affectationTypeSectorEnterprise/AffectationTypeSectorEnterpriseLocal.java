package com.esprit.service.affectationTypeSectorEnterprise;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.Enterprise;
import com.esprit.entity.Sector;
import com.esprit.entity.TypeSector;
import com.esprit.entity.TypeSectorSectorEnterprise;

@Local
public interface AffectationTypeSectorEnterpriseLocal {
	public void createEnterprise(Enterprise enterprise);

	public void createTypeSector(TypeSector typeSector);

	public void createSector(Sector sector);

	public Enterprise getEnterpriseByMat(String matriculeEnseigant);

	public TypeSector getTypeSectorById(int id);

	public Sector getSectorById(int idSector);

	public void createAffectationETPP(Enterprise enterprise,
			TypeSector typeSector, Sector sector,int semestre,int volumeHoraire,boolean statut,int periode);

	public List<TypeSectorSectorEnterprise> findAllByNomEnterprise(
			String nomEnterprise);

	public List<TypeSectorSectorEnterprise> findAllByNomType(String nomType);

	public List<TypeSectorSectorEnterprise> findAllByNomSector(
			String nomSector);

}
