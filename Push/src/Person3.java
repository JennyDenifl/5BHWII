
public class Person3 implements Observer {
	
	public int temp=0;

	public int interest=35;
	
	public int notinterest = 40;

	@Override

	public void update(int i) {

			temp=i;

			System.out.println("Laura: yeah! meine temp:" +i + "°C");

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
