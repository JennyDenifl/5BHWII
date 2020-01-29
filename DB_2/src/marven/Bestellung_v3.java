package marven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bestellung_v3 {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private Kunden kunde;
	private Adresse addressrech;
	private Adresse addresslief;
	public Bestellung_v3() {}

	public Bestellung_v3(Kunden kunde, Adresse addressrech, Adresse addresslief) {

		super();
		this.kunde=kunde;
		this.addressrech = addressrech;
		this.addresslief = addresslief;
	}

	public String getString(int i) {
		if(i==0) {return "Bestellung";}
		if(i==1) {return ""+id;}
		if(i==2) {return ""+kunde.getId();}
		if(i==3) {return ""+addressrech.getId();}
		if(i==4) {return ""+addresslief.getId();}
		else return null;
	}

	@Override
	public String toString() {
		return "Bestellung [id=" + id + ", kunde=" + kunde + ", addressrech=" + addressrech + ", addresslief=" + addresslief + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Kunden getKunde() {
		return kunde;
	}

	public void setKunde(Kunden kunde) {
		this.kunde = kunde;
	}

	public Adresse getAddressrech() {
		return addressrech;
	}

	public void setAddressrech(Adresse addressrech) {
		this.addressrech = addressrech;
	}

	public Adresse getAddresslief() {
		return addresslief;
	}

	public void setAddresslief(Adresse addresslief) {
		this.addresslief = addresslief;
	}

}