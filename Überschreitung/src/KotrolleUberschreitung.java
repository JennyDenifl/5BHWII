
public class KotrolleUberschreitung implements Observer{
	private int uberd;

	public KotrolleUberschreitung(int d) {
		uberd=d;
	}

	@Override
	public void update(int d) {
		if(d>=uberd) {
			System.out.println("Soundalarm: an");
			System.out.println("Display: rot");
		}
	}
}
