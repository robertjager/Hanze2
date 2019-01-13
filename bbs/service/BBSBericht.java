package nl.hanze.bbs.service;

public class BBSBericht {

    protected String kenteken;
    protected int snelheid;
    protected int maximumSnelheid;
    protected String kenmerk;
    protected BBSPersoon persoon;

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

    public String getKenmerk() {
        return kenmerk;
    }

    public void setKenmerk(String value) {
        this.kenmerk = value;
    }

    public BBSPersoon getPersoon() {
        return persoon;
    }

    public void setPersoon(BBSPersoon value) {
        this.persoon = value;
    }

}
