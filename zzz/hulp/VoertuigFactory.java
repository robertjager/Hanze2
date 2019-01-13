package nl.hanze.zzz.hulp;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import nl.hanze.web.rdw.service.Model;
import nl.hanze.web.rdw.service.Voertuig;

public class VoertuigFactory {
	private static String capitals ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String small = "abcdefghijklmnopqrstuvwxyz";
	private static String[] kleuren={"rood","zwart","blauw","wit","zilver","grijs","groen","antraciet",
			"rood metallic","zwart metallic","blauw metallic","grijs metallic","groen metallic"};
	private static String[] merk={"VW","Renault","Citroën","Mercedes","BMW","FIAT","Alfa Romeo","Mazda",
								"Toyota","Chevrolet","Range Rover","Ford","Opel"};
	private static String[] motorType={"B","D","G","H","E"};
	private static String[] type={"Sedan","Station","Cabrio","Sport"};
    private static final EntityManagerFactory ENTITY_RDW_FACTORY = Persistence
            .createEntityManagerFactory("RDW");
	
	public static String karakter(boolean upper){
		Random r = new Random();
		char teken = (upper) ? capitals.charAt(r.nextInt(26)) : small.charAt(r.nextInt(26));
		return Character.toString(teken);
	}
	
	public static Voertuig buildVoertuig(){
		Random r = new Random();
		Voertuig voertuig=new Voertuig();
		Model model=new Model();
		voertuig.setBsn(r.nextInt(900000000)+100000000);
		voertuig.setChassisNummer(karakter(true) + r.nextInt(100000));
		switch (r.nextInt(3)) {
        case 0:  voertuig.setKenteken (r.nextInt(90) + 10 + "-" + 
        		karakter(true) + karakter(true) + "-" + karakter(true) + karakter(true));
                 break;
        case 1:  voertuig.setKenteken ( (r.nextInt(90)+10) + "-" + 
        		karakter(true) + karakter(true) + karakter(true) + "-" + (r.nextInt(10)+1));
                 break;
        case 2:  voertuig.setKenteken( karakter(true) + karakter(true) + "-" + (r.nextInt(900)+100) + "-" + 
        		karakter(true));
                 break;
		}
		voertuig.setKleur(kleuren[r.nextInt(kleuren.length)]);
		model.setMerkNaam(merk[r.nextInt(merk.length)]);
		model.setTypeAanduiding(type[r.nextInt(type.length)]);
		model.setTypeMotor(motorType[r.nextInt(motorType.length)]);
		model.setMotorInhoud((r.nextInt(6000)+1200)/1000.0f);
		voertuig.setModel(model);
		return voertuig;
	}
	
	public static void main(String[] args){
        Postcode.setUpList();
        EntityManager manager = ENTITY_RDW_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
        	for(int i = 0; i<100;i++){
            	Voertuig voertuig = buildVoertuig();
            	BRPPersoon.maakEigenaar(voertuig.getBsn());
                manager.persist(voertuig);
        	}
            transaction.commit();        		
        }
        catch (Exception ex){
        	if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        finally {
        	manager.close();
        	BRPPersoon.closeFactory();
        	ENTITY_RDW_FACTORY.close();
        	
        }
	}
}
