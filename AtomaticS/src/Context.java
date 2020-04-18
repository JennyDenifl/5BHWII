import java.util.Scanner;

public class Context {
	int speed;
	IState state;
	
	public Context(int speed, IState state) {
		this.speed=speed;
		this.state=state;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public IState getState() {
		return state;
	}

	public void setState(IState state) {
		this.state = state;
	}

	public static void main(String[] args) {
		Context c = new Context(0,new Standartmodus());
		Scanner s= new Scanner(System.in);
		System.out.println("Ende mit'ende', sonst einfach Zahl eingeben");
		while(true) {
			String next=s.next();
			if(next.equals("ende")) {
				break;
			}
			try {
				c.speed=Integer.parseInt(next);
			}
			catch(Exception e) {
				System.out.println("Ende");
			}
			c.getState().goNext(c);
			c.getState().printMsg();
		}
		System.out.println("Ende");
		s.close();
	}
}