package nl.hanze.zzz.hulp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;


@Entity
@Table(name = "postcode")
@NamedQuery(name="postcodes.all",
query="SELECT p FROM Postcode p")
public class Postcode {
    private static final EntityManagerFactory ENTITY_POSTCODE_FACTORY = Persistence
            .createEntityManagerFactory("postcodes");
    private static ArrayList<Postcode> alleCodes;
    
	@Id
	public int id;
    public String postcode;
	public int minnumber;
	public int maxnumber;
	public String numbertype;
	public String street;
	public String city;

    public static List<Postcode> readAll() {

    List<Postcode> postcodes = null;
    EntityManager manager = ENTITY_POSTCODE_FACTORY.createEntityManager();
    TypedQuery<Postcode> query = manager.createNamedQuery("postcodes.all", Postcode.class);
    postcodes =query.getResultList();
 	manager.close();
 	ENTITY_POSTCODE_FACTORY.close();
    return postcodes;
    }
    
    public static void setUpList(){
    	if (alleCodes==null){
    		alleCodes=(ArrayList<Postcode>)readAll();
    		System.out.println("Ophalen codes");
    	}
		System.out.println(alleCodes.size());
    }
    
    public static Postcode getRandomPostcode(){
    	Random r = new Random();
    	Postcode adres = alleCodes.get(r.nextInt(alleCodes.size()));
    	return adres;
    }
}
