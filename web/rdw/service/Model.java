package nl.hanze.web.rdw.service;

import javax.persistence.Embeddable;

@Embeddable
public class Model {

    protected String merkNaam;
    protected float motorInhoud;
    protected String typeAanduiding;
    protected String typeMotor;

    public String getMerkNaam() {
        return merkNaam;
    }

    public void setMerkNaam(String value) {
        this.merkNaam = value;
    }

    public float getMotorInhoud() {
        return motorInhoud;
    }

    public void setMotorInhoud(float value) {
        this.motorInhoud = value;
    }

    public String getTypeAanduiding() {
        return typeAanduiding;
    }

    public void setTypeAanduiding(String value) {
        this.typeAanduiding = value;
    }

    public String getTypeMotor() {
        return typeMotor;
    }

    public void setTypeMotor(String value) {
        this.typeMotor = value;
    }

}
