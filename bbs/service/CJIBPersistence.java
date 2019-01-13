package nl.hanze.bbs.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CJIBPersistence {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("CJIB");
    private EntityManager manager;
    private EntityTransaction transaction;
    
    public CJIBPersistence() {
    	this.manager = ENTITY_MANAGER_FACTORY.createEntityManager();
    	this.transaction = manager.getTransaction();
    	this.transaction.begin();
    }
    
    public void close(){
		transaction.commit();
        manager.close();
    }
    
    public int getBasisBoeteBedrag(int snelheid){
  	 	TypedQuery<BasisBoeteBedrag> query = manager.createNamedQuery("BasisBoeteBedrag.findBoete", 
   	 			                                                       BasisBoeteBedrag.class);
   	 	query.setParameter("snelheid", snelheid);
   	 	BasisBoeteBedrag result = query.getSingleResult();
   	 	return result.getBoeteBedrag();
    }
    
	public int getZwaartepunten(Long bsn){
			Query query = manager.createQuery("SELECT SUM(b.zwaartepunten) FROM BBSRegistratie b WHERE b.bsn=:bsnnummer and b.datum>:datum", Long.class);
			query.setParameter("bsnnummer", bsn);
			query.setParameter("datum", getDateMinusOneYear());
	   	 	Number result = (Number)query.getSingleResult();
	   	 	int zwaartepunten = (result!=null) ? result.intValue() : 0;
	   	 	return zwaartepunten;
	}

    public void basisBoeteBedragFactory() {
    	ArrayList<BasisBoeteBedrag> bbbs = new ArrayList<BasisBoeteBedrag>();
    	bbbs.add(new BasisBoeteBedrag(0,4,25));
    	bbbs.add(new BasisBoeteBedrag(5,9,50));
    	bbbs.add(new BasisBoeteBedrag(10,14,75));
    	bbbs.add(new BasisBoeteBedrag(15,19,100));
    	bbbs.add(new BasisBoeteBedrag(20,29,150));
    	bbbs.add(new BasisBoeteBedrag(30,39,250));
    	bbbs.add(new BasisBoeteBedrag(40,49,400));
        for(BasisBoeteBedrag bbb: bbbs) {
            manager.persist(bbb);  
        }
        manager.close();
    }    
    
	public void createOrUpdatePersoon(BBSPersoon persoon){
        if (manager.find(BBSPersoon.class, persoon.bsn)==null) {
        	manager.persist(persoon);
        }
        else {
        	BBSPersoon persoon2=manager.find(BBSPersoon.class, persoon.bsn);
        	persoon2.achternaam=persoon.achternaam;
        	persoon2.geslacht=persoon.geslacht;
        	persoon2.ibannummer=persoon.ibannummer;
        	persoon2.initialen=persoon.initialen;
        	persoon2.plaatsnaam=persoon.plaatsnaam;
        	persoon2.postcode=persoon.postcode;
        	persoon2.straatnaam=persoon.straatnaam;
        	persoon2.straatnummer=persoon.straatnummer;
        	manager.persist(persoon2);
        }	
	}
	
	public void createBBSRegistratie(BBSBericht bericht, int zwaartepunten, double boeteBedrag){
		BBSRegistratie bbsRegistratie = new BBSRegistratie(bericht, zwaartepunten, boeteBedrag);
		manager.persist(bbsRegistratie);
	}

	public Date getDateMinusOneYear(){
		Calendar cal = Calendar.getInstance();
		Date lastYear = cal.getTime();
		cal.add(Calendar.YEAR, -1); 
		lastYear = cal.getTime();
		return lastYear;
	}

}
