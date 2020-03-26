
public class Kartoffelsalat extends Beilage {

	double preis = 5;
	String name = "Kartoffelsalat";
	
	@Override
	public double getPreis(){
		return preis;
	}
	
	@Override
	public String name(){
		return name;
	}
}
