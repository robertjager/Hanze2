package nl.hanze.bbs.service;

import com.thoughtworks.xstream.XStream;

public class BBSService {
    private int zwaartepunten;
    private BBSBericht bericht;
    private CJIBPersistence CJIBP;
    
	public void handleMessage(String message){
		CJIBP = new CJIBPersistence();
		bericht = getBericht(message);
		CJIBP.createOrUpdatePersoon(bericht.persoon);
		double boeteBedrag = bepaalBoete();
		if (boeteBedrag>0) {
			CJIBP.createBBSRegistratie(bericht, zwaartepunten, boeteBedrag);			
		}
		CJIBP.close();
	}
	
	public BBSBericht getBericht(String message){
		XStream xstream = new XStream();
		xstream.alias("ns0:BBSBericht", BBSBericht.class);
		xstream.alias("persoon", BBSPersoon.class);
		BBSBericht bericht = (BBSBericht)xstream.fromXML(message);
		return bericht;
	}
		
	public double bepaalBoete(){
		int overtreding = bericht.snelheid-bericht.maximumSnelheid;
		int totaalZwaartepunten=bepaalZwaartepunten(overtreding);
		return (totaalZwaartepunten>0) ? bepaalBoeteBedrag(totaalZwaartepunten, overtreding): 0.0;
	}
	
	public int bepaalZwaartepunten(int overtreding){
		zwaartepunten = 1+(overtreding/10);
   	 	return (zwaartepunten<6) ? (zwaartepunten+CJIBP.getZwaartepunten(bericht.persoon.bsn)) : 0;
  	}
	
	public double bepaalBoeteBedrag(int totaalZwaartepunten, int overtreding){
		int basisBedrag = CJIBP.getBasisBoeteBedrag(overtreding);
		double factor = (bericht.maximumSnelheid<=50) ? 2.0 : 1.0;
		factor += (totaalZwaartepunten>5) ? 0.5*(totaalZwaartepunten-5) : 0.0;
		return basisBedrag*factor;
	}	
}
