package marven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kunden {
	@Id

	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String titelv;
	private String vorn;
	private String nachn;
	private String titeln;

	public Kunden() {}

	public Kunden(String titelv, String vorn, String nachn, String titeln) {
		super();
		this.titelv = titelv;
		this.vorn = vorn;
		this.nachn = nachn;
		this.titeln = titeln;
	}

	@Override

	public String toString() {

		return "Person [id=" + id + ", TitelV=" + titelv + ", Firstname=" + vorn + ", Lastname=" + nachn +", TitelN= "+titeln+ "]";

	}

	public String getString(int i) {
		if(i==0){
			return "Kunde";
		}
		if(i==1){
			return ""+id;
		}
		if(i==2){
			return titelv;
		}
		if(i==3){
			return vorn;
		}
		if(i==4){
			return nachn;
		}
		if(i==5){
			return titeln;
		}
		else return null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitelv() {
		return titelv;
	}

	public void setTitelv(String titelv) {
		this.titelv = titelv;
	}

	public String getVorname() {
		return vorn;
	}

	public void setVorname(String vorname) {
		this.vorn = vorname;
	}

	public String getNachname() {
		return nachn;
	}

	public void setNachname(String nachname) { 
		this.nachn = nachname;
	}

	public String getTiteln() {
		return titeln;
	}

	public void setTiteln(String titeln) {
		this.titeln = titeln;
	}

}