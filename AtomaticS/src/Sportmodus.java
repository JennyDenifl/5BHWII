
public class Sportmodus implements IState{

	
	public Sportmodus() {
	}

	int mins=500;
	int maxs=2000;

	@Override
	public void goNext(Context c) {
			if(mins>c.getSpeed()) {
				c.setState(new Standartmodus());
			}
			if(maxs<c.getSpeed()) {
			}
	}

	@Override
	public void printMsg() {
		System.out.println("Sportmodus");
	}

}
