package nl.hanze.zzz.hulp;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name = "brppersoon")
public class BRPPersoon {
    private static final EntityManagerFactory ENTITY_BRP_FACTORY = Persistence
            .createEntityManagerFactory("BRP");

	@Id
	@GeneratedValue
	public int id;
	public long bsnNummer;
	public String geslacht;
	public String initialen;
	public String achternaam;
	public String straatnaam;
	public int nummer;
	public String postcode;
	public String woonplaats;
	public String ibannummer;
	private static String capitals ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String small = "abcdefghijklmnopqrstuvwxyz";
	private static String[] lastNames={"Jansen","Bakker","de Vries","de Boer","van Dijk","Mulder","Smith","Lasoeur",
			"Blom","Gerritsen"," de Lange","Spits"};
	private static String[] banken={"INGB","RABO","TRIO","ABNN","SNSN"};


	public static String karakter(boolean upper){
		Random r = new Random();
		char teken = (upper) ? capitals.charAt(r.nextInt(26)) : small.charAt(r.nextInt(26));
		return Character.toString(teken);
	}

	public static void closeFactory(){
		ENTITY_BRP_FACTORY.close();
	}
	
	public static void maakEigenaar(Long bsnNummer){
		EntityManager manager = ENTITY_BRP_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Random r = new Random();
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            BRPPersoon bp = new BRPPersoon();
            bp.bsnNummer=bsnNummer;
            bp.geslacht = (r.nextInt(2)==0) ? "M" : "V";
            bp.initialen="";
            for(int i=0;i<r.nextInt(4)+1;i++){
            	bp.initialen+=karakter(true);
            }
            bp.achternaam=lastNames[r.nextInt(lastNames.length)];
            bp.ibannummer="NL"+(r.nextInt(90)+10)+banken[r.nextInt(banken.length)]+(r.nextInt(900000000)+100000000);
            Postcode adres = Postcode.getRandomPostcode();
            int factor=2;
            if (adres.numbertype.equals("mixed")) {
            	factor=1;
            }
            int range=((adres.maxnumber-adres.minnumber)>0) ? (adres.maxnumber-adres.minnumber) : factor;
            bp.nummer = adres.minnumber + factor * r.nextInt(range/factor);
            bp.postcode = adres.postcode;
            bp.straatnaam = adres.street;
            bp.woonplaats = adres.city;
            manager.persist(bp);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
	}
}