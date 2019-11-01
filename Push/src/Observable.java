import java.util.ArrayList;



public class Observable {

	private int temp;
	ArrayList<Observer> observers = new ArrayList<Observer>();


	public Observable(int temp) {

		this.temp=temp;

	}

	public void setValue(int i) {

		temp=i;

		notifyObserver();

	}

	public void notifyObserver() {

		for(Observer o:observers) {

			if(temp >= o.getInterest()) {
				if(temp <= o.getNotInterest()){
					o.update(temp);
				}

			}

		}

	}

	public void register(Observer person) {

		observers.add(person);

	}

	public void unregister(Observer person) {

		observers.remove(person);

	}

	public static void main(String[] args) {

		Observable o= new Observable(1);

		Person1 a=new Person1();

		o.register(a);

		Person2 b= new Person2();

		o.register(b);
		
		Person3 c= new Person3();

		o.register(c);

		o.setValue(37);


	}



}
