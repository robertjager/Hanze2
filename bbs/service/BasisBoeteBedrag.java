package nl.hanze.bbs.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "basisboetebedrag")
@NamedQuery(name="BasisBoeteBedrag.findBoete",
query="SELECT b FROM BasisBoeteBedrag b WHERE b.snelheidVanaf<=:snelheid AND b.snelheidTot>=:snelheid")
public class BasisBoeteBedrag {
	
	@Id
    @GeneratedValue
    private Long id;
	@Column(name="snelheidVanaf")
	protected int snelheidVanaf;
	@Column(name="snelheidTot")
	protected int snelheidTot;
	@Column(name="boeteBedrag")
	protected int boeteBedrag;
	
	public BasisBoeteBedrag() {}
	
    public BasisBoeteBedrag(int vanaf, int tot, int bedrag){
    	this.snelheidVanaf=vanaf;
    	this.snelheidTot=tot;
    	this.boeteBedrag=bedrag;
    }
    
    public int getSnelheidVanaf(){
    	return this.snelheidVanaf;
    }
    
    public void setSnelheidVanaf(int snelheid){
    	this.snelheidVanaf=snelheid;
    }
    
    public int getSnelheidTot(){
    	return this.snelheidTot;
    }
    
    public void setSnelheidTot(int snelheid){
    	this.snelheidTot=snelheid;
    }

    public int getBoeteBedrag(){
    	return this.boeteBedrag;
    }
    
    public void setBoeteBedrag(int bedrag){
    	this.boeteBedrag=bedrag;
    }

}
