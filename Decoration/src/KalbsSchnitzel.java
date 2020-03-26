
public class KalbsSchnitzel extends Gericht {

	int preis = 7;
	String name = "Kalbs Schnitzel";
	
	@Override
	public double getPreis(){
		return preis;
	}
	
	@Override
	public String name(){
		return name;
	}
}
