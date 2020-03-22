public class hawaii implements IPizza{

		private static String name= "Hawaii";
		private static String zutaten= "Tomaten, Käse, Ananas, Schinken ";

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
