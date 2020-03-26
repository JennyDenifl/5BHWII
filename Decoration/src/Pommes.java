
public class Pommes extends Beilage {

	double preis = 7;
	String name = "Pommes";
	
	@Override
	public double getPreis(){
		return preis;
	}
	
	@Override
	public String name(){
		return name;
	}
}
