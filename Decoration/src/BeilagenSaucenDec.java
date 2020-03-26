
public class BeilagenSaucenDec extends BeilagenDec {

	Saucen saucen;

	public BeilagenSaucenDec(Gericht gericht, Beilage beilage, Saucen saucen) {
		super(gericht, beilage);
		this.saucen =saucen;
	}

	

	@Override
	public double getPreis() {
		return super.gericht.getPreis()+ beilage.getPreis() + saucen.getPreis();
	}

	@Override
	public String name() {
		return super.gericht.name()+", "+beilage.name() + ", "+saucen.name();
	}

}
