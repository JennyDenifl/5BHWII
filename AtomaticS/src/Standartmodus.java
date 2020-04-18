
public class Standartmodus implements IState {

	public Standartmodus() {
	}

	int mins = 0;
	int maxs = 500;

	@Override
	public void goNext(Context c) {
			if (mins>c.getSpeed()){
			}
			if (maxs<c.getSpeed()){
				c.setState(new Sportmodus());
			}
	}

	@Override
	public void printMsg() {
		System.out.println("Standardmodus");

	}

}
