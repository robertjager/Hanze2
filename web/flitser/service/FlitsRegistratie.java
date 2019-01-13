package nl.hanze.web.flitser.service;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

@Entity
@Table(name = "flitsregistratie")
public class FlitsRegistratie {
	@Id
    @GeneratedValue
    private Long id;
	private int snelheid;
	private int maxtoegestaan;
	private String kenteken;
	private String kenmerk;
	private String status;
	
	public FlitsRegistratie(){
		this.status="O";		
	}
	
	public FlitsRegistratie(int snelheid, int maxtoegestaan, String kenteken, String kenmerk){
		this.snelheid=snelheid;
		this.maxtoegestaan=maxtoegestaan;
		this.kenteken=kenteken;
		this.kenmerk=kenmerk;
		this.status="O";
	}
	
	public int getSnelheid() {
		return snelheid;
	}
	public void setSnelheid(int snelheid) {
		this.snelheid = snelheid;
	}
	public int getMaxtoegestaan() {
		return maxtoegestaan;
	}
	public void setMaxtoegestaan(int maxtoegestaan) {
		this.maxtoegestaan = maxtoegestaan;
	}
	public String getKenteken() {
		return kenteken;
	}
	public void setKenteken(String kenteken) {
		this.kenteken = kenteken;
	}
	public String getKenmerk() {
		return kenmerk;
	}
	public void setKenmerk(String kenmerk) {
		this.kenmerk = kenmerk;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void randomFlitser(){
    	int[] maximumSnelheden = {30, 50, 70, 80, 90, 120, 130};
    	Random r = new Random();
    	maxtoegestaan=maximumSnelheden[r.nextInt(maximumSnelheden.length)];
    	snelheid = (r.nextInt(100)<90) ? (r.nextInt(50)) : 50 + r.nextInt(100);
    	snelheid+=maxtoegestaan;
    	kenteken = getKenteken();
    	kenmerk = "00"+r.nextInt(100);
    	kenmerk = "Flitser" + kenmerk.substring(kenmerk.length()-3,3);
	}
}
