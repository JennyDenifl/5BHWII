public class BeilagenDec extends GerichtDec{

	Beilage beilage;

	public BeilagenDec(Gericht gericht, Beilage beilage) {
		super(gericht);
		this.beilage=beilage;
	}

	@Override
	public double getPreis() {
		return super.gericht.getPreis()+beilage.getPreis();
	}

	@Override
	public String name() {
		return super.gericht.name()+", "+beilage.name();
	}

}