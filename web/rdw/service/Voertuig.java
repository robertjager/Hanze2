package nl.hanze.web.rdw.service;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "voertuig")
@NamedQueries({
@NamedQuery(name="voertuig.byKenteken",
query="SELECT v FROM Voertuig v WHERE v.kenteken=:kenteken"),
@NamedQuery(name="voertuig.allKentekens",
query="SELECT kenteken FROM Voertuig")
})
public class Voertuig {

	@Id
    @GeneratedValue
    private Long id;
	protected long bsn;
    protected String chassisNummer;
    protected String kenteken;
    protected String kleur;
    @Embedded
    protected Model model;

    public long getBsn() {
        return bsn;
    }

    public void setBsn(long value) {
        this.bsn = value;
    }

    public String getChassisNummer() {
        return chassisNummer;
    }

    public void setChassisNummer(String value) {
        this.chassisNummer = value;
    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String value) {
        this.kenteken = value;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String value) {
        this.kleur = value;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model value) {
        this.model = value;
    }

}
