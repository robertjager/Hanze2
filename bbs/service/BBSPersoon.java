package nl.hanze.bbs.service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bbspersoon")
public class BBSPersoon {

    @Id
	protected long bsn;
    protected String geslacht;
    protected String initialen;
    protected String achternaam;
    protected String straatnaam;
    protected int straatnummer;
    protected String plaatsnaam;
    protected String postcode;
    protected String ibannummer;
  
    public long getBsn() {
        return bsn;
    }

    public void setBsn(long value) {
        this.bsn = value;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String value) {
        this.geslacht = value;
    }

    public String getInitialen() {
        return initialen;
    }

    public void setInitialen(String value) {
        this.initialen = value;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String value) {
        this.achternaam = value;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String value) {
        this.straatnaam = value;
    }

    public int getStraatnummer() {
        return straatnummer;
    }

    public void setStraatnummer(int value) {
        this.straatnummer = value;
    }

    public String getPlaatsnaam() {
        return plaatsnaam;
    }

    public void setPlaatsnaam(String value) {
        this.plaatsnaam = value;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String value) {
        this.postcode = value;
    }

    public String getIbannummer() {
        return ibannummer;
    }

    public void setIbannummer(String value) {
        this.ibannummer = value;
    }

}
