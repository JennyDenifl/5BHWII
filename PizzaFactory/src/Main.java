import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		System.out.println("Es gibt Margherita, Salami oder Hawaii");
		Scanner s = new Scanner(System.in);
		
		System.out.println("Was möchten Sie:");
		String in = s.nextLine();
		
		if(in.equals("Margherita")){
			System.out.println(PizzaFactory.getPizza("Margherita"));
		}
		else if(in.equals("Salami")){
			System.out.println(PizzaFactory.getPizza("Salami"));
		}
		else if(in.equals("Hawaii")){
			System.out.println(PizzaFactory.getPizza("Hawaii"));
		}
		else{
			System.out.println("Sie haben etwas falsch gemacht!");
		}
	}
}
