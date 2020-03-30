import java.util.ArrayList;

public class Drehzahl implements Obervable {
	int d;
	private ArrayList<Observer> ob=new ArrayList<Observer>();
	
	@Override
	public void add(Observer o) {
		ob.add(o);
	}
	@Override
	public void remove(Observer o) {
		ob.remove(o);
	}
	@Override
	public void notifyO() {
		for(Observer o : ob) {
			o.update(d);
		}
	}
	
	public void drehzahl() {
		d+=100;
		System.out.println(d);
		this.notifyO();
	}


	public static void main(String[] args) {
		Drehzahl d= new Drehzahl();
		d.add(new KotrolleUberschreitung(800));
		for(int i=0;i<10;i++) {
			d.drehzahl();
		}
	}
}

