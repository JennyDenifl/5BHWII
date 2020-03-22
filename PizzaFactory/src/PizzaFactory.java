
public class PizzaFactory {

	public static IPizza getPizza(String pizza) {
		if(pizza=="Margherita") {
			return new margherita();
		}
		else if(pizza=="Salami") {
			return new Salami();
		}
		else if(pizza=="Hawaii") {
			return new hawaii();
		}
		return null;
	}
}
