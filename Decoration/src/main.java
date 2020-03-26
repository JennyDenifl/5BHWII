
public class main {


	public static void main(String[] args) {
		SchweineSchnitzel s=new SchweineSchnitzel();
		KalbsSchnitzel ks = new KalbsSchnitzel();
		Pommes b=new Pommes();
		Kartoffelsalat ka = new Kartoffelsalat();
		Mayo m = new Mayo();
		Ketchup k = new Ketchup();
		
		System.out.println("Gericht mit Beilage + Sauce");
		Gericht gericht1=new BeilagenSaucenDec(ks, ka , k);
		System.out.println( "Ihr Gericht: " +gericht1.name());
		System.out.println("Ihre Kosten: " + gericht1.getPreis() + "€");
		
		System.out.println("Gericht mit Beilage + Sauce");
		Gericht gericht2=new BeilagenSaucenDec(s, b, m);
		System.out.println( "Ihr Gericht: " +gericht2.name());
		System.out.println("Ihre Kosten: " + gericht2.getPreis() + "€");
		
		System.out.println("Gericht mit Beilage");
		Gericht gericht3=new BeilagenDec(ks, ka);
		System.out.println( "Ihr Gericht: " +gericht3.name());
		System.out.println("Ihre Kosten: " + gericht3.getPreis() + "€");
		
		System.out.println("nur Gericht");
		Gericht gericht4= new GerichtDec(ks) {};
		System.out.println( "Ihr Gericht: " +gericht4.name());
		System.out.println("Ihre Kosten: " + gericht4.getPreis() + "€");
	}

}
