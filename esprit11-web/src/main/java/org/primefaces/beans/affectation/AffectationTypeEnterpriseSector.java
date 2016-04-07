package org.primefaces.beans.affectation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;






import com.esprit.entity.Enterprise;
import com.esprit.entity.Sector;
import com.esprit.entity.TypeSector;
import com.esprit.entity.TypeSectorSectorEnterprise;
import com.esprit.service.affectationTypeSectorEnterprise.AffectationTypeSectorEnterpriseLocal;
import com.esprit.service.gestionEnterprise.GestionEnterpriseLocal;
import com.esprit.service.gestionSector.GestionSectorLocal;
import com.esprit.service.gestionTypeSector.GestionTypeSectorLocal;

@ManagedBean
@SessionScoped
public class AffectationTypeEnterpriseSector {
	@EJB
	GestionTypeSectorLocal gestionTypeSectorLocal;
	@EJB
	GestionEnterpriseLocal gestionEnterpriseLocal;
	@EJB
	GestionSectorLocal gestionSectorLocal;
	@EJB
	AffectationTypeSectorEnterpriseLocal affectationTypeSectorEnterpriseLocal;
	

	private Integer num;
	private int owner;
	private int reputation;
	private Date dateAffectation;
	private boolean statut;

	private List<SelectItem> itemsEnterprises;
	private String selectedEnterpriseId;

	private List<SelectItem> itemsTypes;
	private int idSelectedType;

	private List<SelectItem> itemsSectors;
	private int selectedSectorId;

	private Enterprise enterprise = new Enterprise();
	private List<Enterprise> enterprises = new ArrayList<Enterprise>();

	private List<TypeSector> typeSectors = new ArrayList<TypeSector>();
	private TypeSector typeSector = new TypeSector();

	private Sector sector = new Sector();
	private List<Sector> sectors = new ArrayList<Sector>();

	private int chargeHoraireParEnterprise;

	// ************************ affichage par enterprise ********************
	private List<TypeSectorSectorEnterprise> listeParEnterprises;
	private String nomEnterpriseSelected;
	private String nameEnterprise;

	// ************************* affichage par promotion *********************
	private List<TypeSectorSectorEnterprise> listeParSectors;
	private int idSector;
	private String labelSectorSelected;

	// ************************ affichage par unite **************************
	private List<TypeSectorSectorEnterprise> listeParTypes;
	private int idType;
	private String nomTypeSelected;
	
	private List<SelectItem> selectItemsSectors;


	public String doAdd() {

		TypeSector typeTMP = gestionTypeSectorLocal.findById(idSelectedType);
		Enterprise enterpriseTMP = gestionEnterpriseLocal.findByMat(selectedEnterpriseId);
		Sector sectorTMP = gestionSectorLocal.findById(selectedSectorId);
		
		affectationTypeSectorEnterpriseLocal.createAffectationETPP(enterpriseTMP, typeTMP, sectorTMP, owner, num, statut,reputation);

		nameEnterprise = enterpriseTMP.getNom();

		return "";
	}

	public String doCalculChargeHoraire() {
		int chargeHoraireParEnterprise = gestionEnterpriseLocal
				.volumeHoraireTotalParEnterprise(nameEnterprise);
		System.out.println(chargeHoraireParEnterprise);
		return "";
	}

	// ************ affichage par Enterprise *************************

	public String updateDataTable() {
		nomEnterpriseSelected = gestionEnterpriseLocal
				.findByMat(nameEnterprise).getNom();
		listeParEnterprises = affectationTypeSectorEnterpriseLocal
				.findAllByNomEnterprise(nomEnterpriseSelected);
		return "";
	}

	// ******************** affichage par Sector ********************
	public String updateDataTableSector() {
		labelSectorSelected = gestionSectorLocal.findById(idSector).getLibelleSector();
		listeParSectors = affectationTypeSectorEnterpriseLocal.findAllByNomSector(labelSectorSelected);
		return "";
	}

	// ********************* affichage par type ***********************
	public String updateDataTableType() {
		
		nomTypeSelected = gestionTypeSectorLocal.findById(idType)
				.getLibelleType();
		
		listeParTypes = affectationTypeSectorEnterpriseLocal
				.findAllByNomType(nomTypeSelected);
		

		return "";
	}

	public GestionEnterpriseLocal getGestionEnterpriseLocal() {
		return gestionEnterpriseLocal;
	}

	public void setGestionEnterpriseLocal(
			GestionEnterpriseLocal gestionEnterpriseLocal) {
		this.gestionEnterpriseLocal = gestionEnterpriseLocal;
	}

	public List<SelectItem> getItemsEnterprises() {
		itemsEnterprises = new ArrayList<SelectItem>();
		enterprises = gestionEnterpriseLocal.findAll();
		itemsEnterprises.add(new SelectItem(-1, "select one..."));
		for (Enterprise s : enterprises)
			itemsEnterprises.add(new SelectItem(s.getMatriculeEnterprise(), s
					.getNom()));
		return itemsEnterprises;
	}

	public void setItemsEnterprises(List<SelectItem> itemsEnterprises) {
		this.itemsEnterprises = itemsEnterprises;
	}

	public List<SelectItem> getItemsTypes() {
		itemsTypes = new ArrayList<SelectItem>();
		typeSectors = gestionTypeSectorLocal.findAll();
		itemsTypes.add(new SelectItem(-1, "select one..."));
		for (TypeSector s : typeSectors)
			itemsTypes.add(new SelectItem(s.getIdType(), s.getLibelleType()));
		return itemsTypes;
	}

	public void setItemsTypes(List<SelectItem> itemsTypes) {
		this.itemsTypes = itemsTypes;
	}

	public List<SelectItem> getItemsSectors() {
		itemsSectors = new ArrayList<SelectItem>();
		sectors = gestionSectorLocal.findAll();
		itemsSectors.add(new SelectItem(-1, "select one..."));
		for (Sector s : sectors)
			itemsSectors.add(new SelectItem(s.getRefSector(), s.getLibelleSector()));
		return itemsSectors;
	}

	public void setItemsSectors(List<SelectItem> itemsSectors) {
		this.itemsSectors = itemsSectors;
	}

	public String getSelectedEnterpriseId() {
		return selectedEnterpriseId;
	}

	public void setSelectedEnterpriseId(String selectedEnterpriseId) {
		this.selectedEnterpriseId = selectedEnterpriseId;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public List<Enterprise> getEnterprises() {
		enterprises = gestionEnterpriseLocal.findAll();
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

	public List<TypeSector> getTypeSectors() {
		typeSectors = gestionTypeSectorLocal.findAll();
		return typeSectors;
	}

	public void setTypeSectors(List<TypeSector> typeSectors) {
		this.typeSectors = typeSectors;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public List<Sector> getSectors() {
		sectors = gestionSectorLocal.findAll();

		return sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	public String getNameEnterprise() {
		return nameEnterprise;
	}

	public void setNameEnterprise(String nameEnterprise) {
		this.nameEnterprise = nameEnterprise;
	}

	// *********** affichage par Enterprise ***********

	public List<TypeSectorSectorEnterprise> getListeParEnterprises() {
		return listeParEnterprises;
	}

	public void setListeParEnterprises(
			List<TypeSectorSectorEnterprise> listeParEnterprises) {
		this.listeParEnterprises = listeParEnterprises;
	}

	public List<TypeSectorSectorEnterprise> getListeParSectors() {
		return listeParSectors;
	}

	public void setListeParSectors(
			List<TypeSectorSectorEnterprise> listeParSectors) {
		this.listeParSectors = listeParSectors;
	}

	public List<TypeSectorSectorEnterprise> getListeParType() {
		return listeParTypes;
	}

	public void setListeParType(List<TypeSectorSectorEnterprise> listeParTypes) {
		this.listeParTypes = listeParTypes;
	}

	public String getNomEnterpriseSelected() {
		return nomEnterpriseSelected;
	}

	public void setNomEnterpriseSelected(String nomEnterpriseSelected) {
		this.nomEnterpriseSelected = nomEnterpriseSelected;
	}

	public GestionTypeSectorLocal getGestionTypeSectorLocal() {
		return gestionTypeSectorLocal;
	}

	public void setGestionTypeSectorLocal(
			GestionTypeSectorLocal gestionTypeSectorLocal) {
		this.gestionTypeSectorLocal = gestionTypeSectorLocal;
	}

	public GestionSectorLocal getGestionSectorLocal() {
		return gestionSectorLocal;
	}

	public void setGestionSectorLocal(GestionSectorLocal gestionSectorLocal) {
		this.gestionSectorLocal = gestionSectorLocal;
	}

	public AffectationTypeSectorEnterpriseLocal getAffectationTypeSectorEnterpriseLocal() {
		return affectationTypeSectorEnterpriseLocal;
	}

	public void setAffectationTypeSectorEnterpriseLocal(
			AffectationTypeSectorEnterpriseLocal affectationTypeSectorEnterpriseLocal) {
		this.affectationTypeSectorEnterpriseLocal = affectationTypeSectorEnterpriseLocal;
	}



	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public int getIdSelectedType() {
		return idSelectedType;
	}

	public void setIdSelectedType(int idSelectedType) {
		this.idSelectedType = idSelectedType;
	}

	public int getSelectedSectorId() {
		return selectedSectorId;
	}

	public void setSelectedSectorId(int selectedSectorId) {
		this.selectedSectorId = selectedSectorId;
	}

	public TypeSector getTypeSector() {
		return typeSector;
	}

	public void setTypeSector(TypeSector typeSector) {
		this.typeSector = typeSector;
	}

	public int getIdSector() {
		return idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getLabelSectorSelected() {
		return labelSectorSelected;
	}

	public void setLabelSectorSelected(String labelSectorSelected) {
		this.labelSectorSelected = labelSectorSelected;
	}

	public List<TypeSectorSectorEnterprise> getListeParTypes() {
		return listeParTypes;
	}

	public void setListeParTypes(List<TypeSectorSectorEnterprise> listeParTypes) {
		this.listeParTypes = listeParTypes;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getNomTypeSelected() {
		return nomTypeSelected;
	}

	public void setNomTypeSelected(String nomTypeSelected) {
		this.nomTypeSelected = nomTypeSelected;
	}

	public int getChargeHoraireParEnterprise() {
		int chargeHoraireParEnterprise = gestionEnterpriseLocal
				.volumeHoraireTotalParEnterprise(nameEnterprise);
		return chargeHoraireParEnterprise;
	}

	public void setChargeHoraireParEnterprise(int chargeHoraireParEnterprise) {
		this.chargeHoraireParEnterprise = chargeHoraireParEnterprise;
	}

	public List<SelectItem> getSelectItemsSectors() {
		return selectItemsSectors;
	}

	public void setSelectItemsSectors(List<SelectItem> selectItemsSectors) {
		this.selectItemsSectors = selectItemsSectors;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
