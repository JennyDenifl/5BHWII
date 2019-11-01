
public class Person1 implements Observer {
	public int temp=0;

	public int interest=25;
	public int notinterest = 30;

	@Override

	public void update(int i) {

		temp=i;

		System.out.println("Carina: juhu! meine temp:" +i + "°C");

	}

	@Override
	public int getInterest() {

		return interest;
	}
	
	@Override
	public int getNotInterest() {

		return notinterest;
	}
	
	
}
