package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import tn.esprit.estrading.controller.AuthentificationController;

import com.estrading.entity.Bonds;
import com.estrading.entity.Currencies;
import com.estrading.entity.Shares;
import com.estrading.service.BondsServiceLocal;
import com.estrading.service.CurrencieUseLocal;
import com.estrading.service.CustomerServiceLocal;
import com.estrading.service.ShareUseLocal;

@ViewScoped
@ManagedBean(name="manager")
public class PropertyManager {
	
	@EJB
	BondsServiceLocal Bondsejb;
	@EJB
	ShareUseLocal Shareejb;
	@EJB
	CurrencieUseLocal Currencyejb;

    private List<Bonds>  cacheList ;

    @ManagedProperty(value="#{authenticationController}")
	   private AuthentificationController messageBean;

	   private int message;
	   
	   
	   public int getMessage() {
		      if(messageBean != null){
		         message = messageBean.getMessage();
		      }       
		      return message;
		   }
		   public void setMessageBean(AuthentificationController message) {
		      this.messageBean = message;
		   }

    @PostConstruct
	public void init() {
    	cacheList = Bondsejb.getAll();
	}

    public List<Bonds> getCacheList() {
		return cacheList;
	}
    
    public List<Shares> returnCacheListMyShare()
    {
    	getMessage();
    	List<Shares>  cacheList1 ;
    	cacheList1 = Shareejb.retrieveByP(message);
    	return cacheList1;
    }
    
    public List<Shares> returnCacheListAllShare()
    {
    	
    	List<Shares>  cacheList1 ;
    	cacheList1 = Shareejb.getAll();
    	return cacheList1;
    }
    
    /**
     * pour le pdf et excel
     * @return cacheList1
     */
    
    public List<Currencies> returnCacheListAllCurrencie()
    {
    	
    	List<Currencies>  cacheList1 ;
    	cacheList1 = Currencyejb.getAll();
    	return cacheList1;
    }
    
    public List<Bonds> returnCacheListAllBonds()
    {
    	
    	List<Bonds>  cacheList4 ;
    	cacheList4 = Bondsejb.getAll();
    	return cacheList4;
    }
    
    public List<Bonds> returnCacheListMyBonds()
    {
    	getMessage();
    	List<Bonds>  cacheList4 ;
    	cacheList4 = Bondsejb.retrieveByPG(message);
    	return cacheList4;
    }


	public void setCacheList(List<Bonds> cacheList) {
		this.cacheList = cacheList;
	}

	public void clear() {
        cacheList.clear();
    }

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());

        for (Row row : sheet) {
            for (Cell cell : row) {
                cell.setCellValue(cell.getStringCellValue().toUpperCase());
                cell.setCellStyle(style);
            }
        }
    }

}