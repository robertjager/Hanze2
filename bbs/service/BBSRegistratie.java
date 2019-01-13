package nl.hanze.bbs.service;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "bbsregistratie")
@NamedQuery(name="BBSRegistratie.zwaartepunten",
query="SELECT SUM(b.zwaartepunten) FROM BBSRegistratie b WHERE b.bsn=:bsnnummer and b.datum>:datum")
public class BBSRegistratie {

	@Id
    @GeneratedValue
    private Long id;
    protected long bsn;
    protected String kenteken;
    protected int snelheid;
    protected int maximumSnelheid;
    protected int zwaartepunten;
    protected double boeteBedrag;
    protected String kenmerk;
    protected String status;
    @Column
    @Type(type="date")
    protected Date datum;
    
    public BBSRegistratie(BBSBericht bericht, int zwaartepunten, double boeteBedrag){
    	this.bsn=bericht.persoon.bsn;
    	this.kenteken=bericht.kenteken;
    	this.snelheid=bericht.snelheid;
    	this.maximumSnelheid=bericht.maximumSnelheid;
    	this.zwaartepunten=zwaartepunten;
    	this.boeteBedrag=boeteBedrag;
    	this.kenmerk=bericht.kenmerk;
    	this.status="O";
		Calendar cal = Calendar.getInstance();
		this.datum = cal.getTime();
    }

    public long getBsn() {
        return bsn;
    }

    public void setBsn(long value) {
        this.bsn = value;
    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String value) {
        this.kenteken = value;
    }

    public int getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(int value) {
        this.snelheid = value;
    }

    public int getMaximumSnelheid() {
        return maximumSnelheid;
    }

    public void setMaximumSnelheid(int value) {
        this.maximumSnelheid = value;
    }

    public int getZwaartepunten() {
        return zwaartepunten;
    }

    public void setZwaartepunten(int value) {
        this.zwaartepunten = value;
    }

    public Double getBoeteBedrag() {
        return boeteBedrag;
    }

    public void setBoeteBedrag(Double value) {
        this.boeteBedrag = value;
    }
    
    public String getKenmerk() {
        return kenmerk;
    }

    public void setKenmerk(String value) {
        this.kenmerk = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date value) {
        this.datum = value;
    }

}
