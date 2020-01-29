package marven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DB {

	public static void addKunde(EntityManager manager, String titelv, String vorname, String nachname, String titeln) {

		Kunden k=new Kunden(titelv, vorname,nachname, titeln);
		manager.getTransaction().begin();
		manager.persist(k);
		manager.getTransaction().commit();

	}

	public static void addAdresse(EntityManager manager, String stadt, String strasse, int plz, String hnr) {

		Adresse a= new Adresse(stadt, strasse, plz, hnr);
		manager.getTransaction().begin();
		manager.persist(a);
		manager.getTransaction().commit();
	}
	
	public static void addBestellung(EntityManager manager, int kundeid, int addressrech, int addresslief) {

		Bestellung_v3 b= new Bestellung_v3(manager.find(Kunden.class, (long)kundeid), manager.find(Adresse.class,(long)addressrech), manager.find(Adresse.class, (long)addresslief));
		manager.getTransaction().begin();
		manager.persist(b);
		manager.getTransaction().commit();
	}

	public static void addArtikel(EntityManager manager, String name, double preis) {

		Artikel a= new Artikel(name,preis);
		manager.getTransaction().begin();
		manager.persist(a);
		manager.getTransaction().commit();
	}

	public static void addBestArt(EntityManager manager, int bestid, int artid, int menge) {

		Bestellung_Artikel ba=new Bestellung_Artikel(manager.find(Bestellung_v3.class, (long)bestid),manager.find(Artikel.class,(long)artid), menge);
		manager.getTransaction().begin();
		manager.persist(ba);
		manager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static void deleteKunde(EntityManager manager, int id) {

		Query query = manager.createNativeQuery("Select * FROM Bestellung;",Bestellung_v3.class);
		List<Bestellung_v3> result=query.getResultList();
		for(Bestellung_v3 b : result) {
			if(b.getKunde().getId()==(long)id) {
				query = manager.createNativeQuery("Select * FROM Bestellung_Artikel;",Bestellung_Artikel.class);
				List<Bestellung_Artikel> resultba=query.getResultList();
				for(Bestellung_Artikel ba : resultba) {
					if(ba.getBestellung().getId()==b.getId()) {
						manager.getTransaction().begin();
						manager.remove(ba);
						manager.getTransaction().commit();
					}
				}

				manager.getTransaction().begin();
				manager.remove(b);
				manager.getTransaction().commit();
			}
		}

		Kunden k=manager.find(Kunden.class, (long)id);
		manager.getTransaction().begin();
		manager.remove(k);
		manager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static void deleteAdresse(EntityManager manager, int id) {

		Query query = manager.createNativeQuery("Select * FROM Bestellung;",Bestellung_v3.class);
		List<Bestellung_v3> result=query.getResultList();
		for(Bestellung_v3 b : result) {
			if(b.getAddresslief().getId()==(long)id || b.getAddressrech().getId()==(long)id) {
				query = manager.createNativeQuery("Select * FROM Bestellung_Artikel;",Bestellung_Artikel.class);
				List<Bestellung_Artikel> resultba=query.getResultList();
				for(Bestellung_Artikel ba : resultba) {
					if(ba.getBestellung().getId()==b.getId()) {
						manager.getTransaction().begin();
						manager.remove(ba);
						manager.getTransaction().commit();
					}
				}

				manager.getTransaction().begin();
				manager.remove(b);
				manager.getTransaction().commit();
			}
		}

		Adresse a=manager.find(Adresse.class, (long)id);
		manager.getTransaction().begin();
		manager.remove(a);
		manager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static void deleteBestellung(EntityManager manager, int id) {

		Query query = manager.createNativeQuery("Select * FROM Bestellung_Artikel;",Bestellung_Artikel.class);
		List<Bestellung_Artikel> result=query.getResultList();
		for(Bestellung_Artikel ba : result) {
			if(ba.getBestellung().getId()==(long)id) {
				manager.getTransaction().begin();
				manager.remove(ba);
				manager.getTransaction().commit();
			}
		}

		Bestellung_v3 b=manager.find(Bestellung_v3.class, (long)id);
		manager.getTransaction().begin();
		manager.remove(b);
		manager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static void deleteArtikel(EntityManager manager, int id) {

		Query query = manager.createNativeQuery("Select * FROM Bestellung_Artikel;",Bestellung_Artikel.class);
		List<Bestellung_Artikel> result=query.getResultList();
		for(Bestellung_Artikel ba : result) {
			if(ba.getArtikel().getId()==(long)id) {
				manager.getTransaction().begin();
				manager.remove(ba);
				manager.getTransaction().commit();
			}
		}

		Artikel a=manager.find(Artikel.class, (long)id);
		manager.getTransaction().begin();
		manager.remove(a);
		manager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static void deleteBestArt(EntityManager manager, int bestid, int artid) {

		Query query = manager.createNativeQuery("Select * FROM Bestellung_Artikel;",Bestellung_Artikel.class);
		List<Bestellung_Artikel> result=query.getResultList();
		for(Bestellung_Artikel ba : result) {
			if(ba.getBestellung().getId()==(long)bestid && ba.getArtikel().getId()==(long)artid) {
				manager.getTransaction().begin();
				manager.remove(ba);
				manager.getTransaction().commit();
			}
		}
	}

	public static void selectKunde(EntityManager manager, int id) {

		Kunden k=manager.find(Kunden.class, (long)id);
		System.out.println(k.toString());
	}

	public static void selectAdresse(EntityManager manager, int id) {

		Adresse a=manager.find(Adresse.class, (long)id);
		System.out.println(a.toString());
	}

	public static void selectBestellung(EntityManager manager, int id) {

		Bestellung_v3 b=manager.find(Bestellung_v3.class, (long)id);
		System.out.println(b.toString());

	}

	public static void selectArtikel(EntityManager manager, int id) {

		Artikel a=manager.find(Artikel.class, (long)id);
		System.out.println(a.toString());

	}

	public static void selectBestArt(EntityManager manager, int bestid, int artid) {

		Query query = manager.createNativeQuery("Select * FROM Bestellung_Artikel;",Bestellung_Artikel.class);
		@SuppressWarnings("unchecked")
		List<Bestellung_Artikel> result=query.getResultList();
		for(Bestellung_Artikel ba : result) {
			if(ba.getBestellung().getId()==(long)bestid && ba.getArtikel().getId()==(long)artid) {
				System.out.println(ba.toString());
			}
		}
	}

	public static Kunden selectKundeK(EntityManager manager, int id) {
		return manager.find(Kunden.class, (long)id);
	}

	public static void updateKunde(EntityManager manager, int id, String titelv, String vorname, String nachname, String titeln) {

		Kunden k=manager.find(Kunden.class, (long)id);
		manager.getTransaction().begin();
		k.setTitelv(titelv);
		k.setVorname(vorname);
		k.setNachname(nachname);
		k.setTiteln(titeln);
		manager.getTransaction().commit();
	}

	public static Bestellung_v3 selectBestellungB(EntityManager manager, int id) {
		return manager.find(Bestellung_v3.class, (long)id);
	}

	public static void updateBestellung(EntityManager manager,int id, int kid, int arid, int alid) {

		Bestellung_v3 b=manager.find(Bestellung_v3.class, (long)id);
		manager.getTransaction().begin();
		b.setKunde(manager.find(Kunden.class, (long)kid));
		b.setAddressrech(manager.find(Adresse.class, (long)arid));
		b.setAddresslief(manager.find(Adresse.class, (long)alid));

	}

	public static Adresse selectAdresseA(EntityManager manager, int id) {
		return manager.find(Adresse.class, (long)id);
	}

	public static void updateAdresse(EntityManager manager, int id, String stadt, String strasse, int plz, String hnr) {

		Adresse a=manager.find(Adresse.class, (long)id);
		manager.getTransaction().begin();
		a.setStadt(stadt);
		a.setStrasse(strasse);
		a.setPlz(plz);
		a.setHnr(hnr);
		manager.getTransaction().commit();
	}

	public static Bestellung_Artikel selectBestArtBA(EntityManager manager, int bestid, int artid) {

		Query query = manager.createNativeQuery("Select * FROM Bestellung_Artikel;",Bestellung_Artikel.class);
		@SuppressWarnings("unchecked")
		List<Bestellung_Artikel> result=query.getResultList();
		for(Bestellung_Artikel ba : result) {
			if(ba.getBestellung().getId()==(long)bestid && ba.getArtikel().getId()==(long)artid) {
				return ba;
			}
		}
		return null;
	}

	public static void updateBestArt(EntityManager manager, int bestid, int artid, int menge) {

		Bestellung_Artikel ba=selectBestArtBA(manager,bestid,artid);
		manager.getTransaction().begin();
		ba.setMenge(menge);
		manager.getTransaction().commit();
	}

	public static Artikel selectArtikelA(EntityManager manager, int id) {
		return manager.find(Artikel.class, (long)id);
	}

	public static void updateArtikel(EntityManager manager,  int id, String name, double preis) {

		Artikel a=manager.find(Artikel.class, (long)id);
		manager.getTransaction().begin();
		a.setName(name);
		a.setPreis(preis);
		manager.getTransaction().commit();
	}

    public static void main( String[] args ){
    	 EntityManagerFactory f=Persistence.createEntityManagerFactory("MyUnit");
         EntityManager manager=f.createEntityManager();
         
         System.out.println("*");
         System.out.println("*");

         Scanner s = new Scanner(System.in);
 		System.out.println("Einfügen K für Kunde, B für Bestellung, Ad für Adresse, BA für BestellungArtikel, Ar für Artikel");
 		
 		boolean fi = false;

 		while (!fi) {
 			System.out.println(" R für Read, C für Create, U für Update oder D für Delete:");
 			String inp = s.nextLine();

 			if (inp.equals("C")) {
 				System.out.println("Table_name (K, B, Ad, BA, Ar) und mit Leerzeichen getrennte Attribute:");
 				inp = s.nextLine();
 				String in[] = inp.split(" ");

 				if (in[0].equals("K")) {

 					addKunde(manager,in[1],in[2],in[3],in[4]);

 				} else if (in[0].equals("B")) {

 					addBestellung(manager,Integer.parseInt(in[1]),Integer.parseInt(in[2]),Integer.parseInt(in[3]));

 				} else if (in[0].equals("Ad")) {

 					addAdresse(manager,in[1],in[2],Integer.parseInt(in[3]),in[4]);

 				} else if (in[0].equals("BA")) {

 					addBestArt(manager,Integer.parseInt(in[1]),Integer.parseInt(in[2]),Integer.parseInt(in[3]));

 				} else if (in[0].equals("Ar")) {
 					
 					addArtikel(manager,in[1], Double.parseDouble(in[2]));
 				} else {
 					System.out.println("Etwas ist schiefgelaufen");

 				}
 			} else if (inp.equals("R")) {

 				System.out.println("Table_name (K, B, Ad, BA, Ar) und ID bitte (2 IDs bei Bestellung_Artikel):");
 				inp = s.nextLine();
 				String in[] = inp.split(" ");

 				if (in[0].equals("K")) {

 					try {
 						selectKunde(manager, Integer.parseInt((in[1])));
 					} catch (Exception e) {
 						System.out.println("Etwas stimmt nicht");
 					}

 				} else if (in[0].equals("B")) {

 					try {
 						selectBestellung(manager, Integer.parseInt((in[1])));
 					} catch (Exception e) {
 						System.out.println("Etwas stimmt nicht");
 					}

 				} else if (in[0].equals("Ad")) {

 					try {
 						selectAdresse(manager, Integer.parseInt((in[1])));
 					} catch (Exception e) {
 						System.out.println("Etwas stimmt nicht");
 					}

 				} else if (in[0].equals("BA")) {

 					try {
 						selectBestArt(manager, Integer.parseInt((in[1])), Integer.parseInt(in[2]));
 					} catch (Exception e) {

 						System.out.println("Etwas stimmt nicht!");

 						e.printStackTrace();

 					}

 				} else if (in[0].equals("Ar")) {

 					try {
 						selectArtikel(manager, Integer.parseInt((in[1])));
 					} catch (Exception e) {
 						System.out.println("Etwas stimmt nicht");
 					}
 				} else {
 					
 					System.out.println("Etwas ist schief gelaufen!");

 				}


 			} else if (inp.equals("U")) {

 				System.out.println("Table_name (K, B, Ad, BA, Ar) und mit Leerzeichen getrennte Attribute:");
 				System.out.println("Sloo etwas nicht verändert werden bitte das eingeben':'");
 				inp = s.nextLine();
 				String in[] = inp.split(" ");

 				if (in[0].equals("K")) {
 					for(int i=2;i<in.length;i++) {
 						if(in[i].equals(":")) {
 							Kunden k=selectKundeK(manager,Integer.parseInt(in[1]));
 							in[i]=k.getString(i);
 						}
 					}
 					updateKunde(manager,Integer.parseInt(in[1]),in[2],in[3],in[4],in[5]);

 				} else if (in[0].equals("B")) {
 					for(int i=2;i<in.length;i++) {
 						if(in[i].equals(":")) {
 							Bestellung_v3 b=selectBestellungB(manager,Integer.parseInt(in[1]));
 							in[i]=b.getString(i);
 						}
 					}
 					updateBestellung(manager,Integer.parseInt(in[1]),Integer.parseInt(in[2]),Integer.parseInt(in[3]),Integer.parseInt(in[4]));

 				} else if (in[0].equals("Ad")) {
 					for(int i=2;i<in.length;i++) {
 						if(in[i].equals(":")) {
 							Adresse a=selectAdresseA(manager,Integer.parseInt(in[1]));
 							in[i]=a.getString(i);
 						}
 					}

 					updateAdresse(manager,Integer.parseInt(in[1]),in[2],in[3],Integer.parseInt(in[4]),in[5]);

 				} else if (in[0].equals("BA")) {

 					for(int i=3;i<in.length;i++) {
 						if(in[i].equals(":")) {
 							Bestellung_Artikel bar=selectBestArtBA(manager,Integer.parseInt(in[1]), Integer.parseInt(in[2]));
 							in[i]=bar.getString(i);
 						}
 					}

 					updateBestArt(manager,Integer.parseInt(in[1]),Integer.parseInt(in[2]),Integer.parseInt(in[3]));

 				} else if (in[0].equals("Ar")) {

 					for(int i=2;i<in.length;i++) {
 						if(in[i].equals(":")) {
 							Artikel ar=selectArtikelA(manager,Integer.parseInt(in[1]));
 							in[i]=ar.getString(i);
 						}
 					}
 					updateArtikel(manager,Integer.parseInt(in[1]),in[2],Double.parseDouble(in[3]));

 				} else {

 					System.out.println("Etwas ist schief gelaufen!");
 				}

 			}
 			
 			else if (inp.equals("D")) {

 				System.out.println("Table_name (K, B, Ad, BA, Ar) und ID bitte (2 IDs bei Bestellung_Artikel):");
 				inp = s.nextLine();
 				String in[] = inp.split(" ");
 				if (in[0].equals("K")) {

 					deleteKunde(manager,Integer.parseInt(in[1]));

 				} else if (in[0].equals("B")) {

 					deleteBestellung(manager,Integer.parseInt(in[1]));

 				} else if (in[0].equals("Ad")) {

 					deleteAdresse(manager,Integer.parseInt(in[1]));

 				} else if (in[0].equals("BA")) {

 					deleteBestArt(manager,Integer.parseInt(in[1]),Integer.parseInt(in[2]));

 				} else if (in[0].equals("Ar")) {
 					
 					deleteArtikel(manager,Integer.parseInt(in[1]));
 					
 				} else {
 					System.out.println("Etwas ist schief gelaufen!");
 				}
 			} 

 			System.out.println("Fertig? ja/na:");
 			inp = s.nextLine();

 			if (inp.equals("ja")) {
 				fi = true;
 			}
 		}
 		
 		s.close();
 	}
}