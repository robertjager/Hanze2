package nl.hanze.web.rdw.service;

import java.util.ArrayList;
import java.util.Random;

import javax.persistence.TypedQuery;

public class GetResponses {
    private RDWPersistence RDWP;

    private Info _InfoReturn;
    private String _KentekenReturn = "";

    public Info getInfoReturn(Kenteken kenteken){
		RDWP= new RDWPersistence();
    	_InfoReturn=new Info();
    	try {
       	 	TypedQuery<Voertuig> query = RDWP.manager.createNamedQuery("voertuig.byKenteken", Voertuig.class);
       	 	query.setParameter("kenteken", kenteken.getKenteken());
       	 	_InfoReturn.voertuig = query.getSingleResult();
       	 	_InfoReturn.statusInfoAanvraag = "OK";
    	}
    	catch (Exception e){
    		_InfoReturn.voertuig=new Voertuig();
    		_InfoReturn.voertuig.kenteken=kenteken.getKenteken();
    		_InfoReturn.voertuig.bsn=-1;
    		_InfoReturn.statusInfoAanvraag="NOT FOUND";
    	}
    	finally{
    		RDWP.close();
    	}
    	return _InfoReturn;
    }

    public String getRandomKenteken(){
    	RDWP = new RDWPersistence();
    	Random r = new Random();
    	TypedQuery<String> query = RDWP.manager.createNamedQuery("voertuig.allKentekens", String.class);
    	ArrayList<String> kentekens = (ArrayList<String>) query.getResultList();
    	_KentekenReturn = kentekens.get(r.nextInt(kentekens.size()));
    	RDWP.close();
    	return _KentekenReturn;
    }
}
