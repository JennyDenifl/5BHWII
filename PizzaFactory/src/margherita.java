public class margherita implements IPizza{

	private static String name="Margherita";
	private static String zutaten= "Tomaten, K�se";

	@Override
	public String getName() {
		return name;	
	}

	@Override
	public String teig() {
		return zutaten;
	}

	@Override
	public String toString() {
		return teig();
	}
}
