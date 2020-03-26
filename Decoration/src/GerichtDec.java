public abstract class GerichtDec extends Gericht{

	Gericht gericht;

	public GerichtDec(Gericht gericht) {
		this.gericht=gericht;
	}
	
	@Override
	public double getPreis() {
		return gericht.getPreis();
	}

	@Override
	public String name() {
		return gericht.name();

	}
}