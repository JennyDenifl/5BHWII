public class Salami implements IPizza {
	
		private static String name="Salami";
		private static String zutaten= "Tomaten, K�se, Salami";

		@Override
		public String getName() {
			return name;	
		}

		@Override
		public String teig() {
			return zutaten;
		}

		@Override
		public String toString() {
			return teig();
		}

}
