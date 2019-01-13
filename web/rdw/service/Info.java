package nl.hanze.web.rdw.service;

public class Info {

    protected String statusInfoAanvraag;
    protected Voertuig voertuig;

    public String getStatusInfoAanvraag() {
        return statusInfoAanvraag;
    }

    public void setStatusInfoAanvraag(String value) {
        this.statusInfoAanvraag = value;
    }

    public Voertuig getVoertuig() {
        return voertuig;
    }
    public void setVoertuig(Voertuig value) {
        this.voertuig = value;
    }

}
