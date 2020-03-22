public class CLient {
	public static void main(String[] args) {
	      Light light = new Light();

	      LightOn lighton = new LightOn(light);
	      LightOff lightaus = new LightOff(light);

	      Invoker in = new Invoker();
	      //Licht an
	      in.Licht(lighton);
	      //Licht aus
	      in.Licht(lightaus);

	      in.Lichtpos();
	   }

}
