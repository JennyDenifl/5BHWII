
public class SchweineSchnitzel extends Gericht {

	static int preis = 5;
	String name = "Schweine Schnitzel";
	
	@Override
	public double getPreis(){
		return preis;
	}
	
	@Override
	public String name(){
		return name;
		
	}

}
