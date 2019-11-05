import java.sql.*;
import java.util.Scanner;

public class Postgre {
	
	public static void Create_KU(Connection con, String titelV, String vorname, String nachname, String titelN) {
		try {
			String inserString = "INSERT INTO Kunde (titelV, vorname, nachname, titelN) VALUES (?,?,?,?);";
			PreparedStatement update_U = con.prepareStatement(inserString);
			update_U.setString(1, titelV);
			update_U.setString(2, vorname);
			update_U.setString(3, nachname);
			update_U.setString(4, titelN);
			update_U.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}
	
	public static void Create_Be(Connection con, int kundeid, int addressrech, int addresslief) {
		try {
			String inserString = "INSERT INTO Bestellung_v3 (ID, kunde_ID, adresse_rechnung_ID, adresse_liefer_ID) VALUES (?,?,?);";
			PreparedStatement update_Be = con.prepareStatement(inserString);
			update_Be.setInt(1, kundeid);
			update_Be.setInt(2, addressrech);
			update_Be.setInt(3, addresslief);
			update_Be.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}

	}

	public static void Create_Ar(Connection con, String name, double preis) {
		try {
			String inserString = "INSERT INTO artikel (ID, name, preis) VALUES (?,?);";
			PreparedStatement update_Ar = con.prepareStatement(inserString);
			update_Ar.setString(1, name);
			update_Ar.setDouble(2, preis);
			update_Ar.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}
	
	public static void Create_Ad(Connection con, String stadt, String strasse, int plz, String hnr) {
		try {
			String inserString = "INSERT INTO adresse (ID, Stadt, Strasse, PLZ, Hnr) VALUES (?,?,?,?);";
			PreparedStatement update_Ad = con.prepareStatement(inserString);
			update_Ad.setString(1, stadt);
			update_Ad.setString(2, strasse);
			update_Ad.setInt(3, plz);
			update_Ad.setString(4, hnr);
			update_Ad.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}


	public static void Create_BeAr(Connection con, int bestid, int artid, int menge) {
		try {
			String inserString = "INSERT INTO bestellung_artikel (bestellung_ID, artikel_ID, menge) VALUES (?,?,?);";
			PreparedStatement update_Ar = con.prepareStatement(inserString);
			update_Ar.setInt(1, bestid);
			update_Ar.setInt(2, artid);
			update_Ar.setInt(3, menge);
			update_Ar.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}

	}

	public static void delete_Ku(Connection con, int id) {
		try {
			String deleteString = "DELETE * FROM Kunde WHERE ID=?";
			PreparedStatement del_Ku = con.prepareStatement(deleteString);
			del_Ku.setInt(1, id);
			del_Ku.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}


	public static void delete_Be(Connection con, int id) {
		try {
			String deleteString = "DELETE * FROM Bestellung_v3 WHERE ID=?";
			PreparedStatement del_Be = con.prepareStatement(deleteString);
			del_Be.setInt(1, id);
			del_Be.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}

	public static void delete_Ar(Connection con, int id) {
		try {
			String deleteString = "DELETE * FROM Artikel WHERE ID=?";
			PreparedStatement del_Ar = con.prepareStatement(deleteString);
			del_Ar.setInt(1, id);
			del_Ar.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}

	public static void delete_BeAr(Connection con, int bestid, int artid) {
		try {
			String deleteString = "DELETE * FROM Bestellung_Artikel WHERE Bestell_ID=? AND Artikel_ID=?";
			PreparedStatement del_Ar = con.prepareStatement(deleteString);
			del_Ar.setInt(1, bestid);
			del_Ar.setInt(2, artid);
			del_Ar.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}



	public static void delete_Ad(Connection con, int id) {
		try {
			String deleteString = "DELETE * FROM Adresse WHERE ID=?";
			PreparedStatement del_Ad = con.prepareStatement(deleteString);
			del_Ad.setInt(1, id);
			del_Ad.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}

	public static void update_Ku(Connection con, int id, String titelv, String vorname, String nachname, String titeln) {
		try {
			String updateString = "UPDATE kunde SET Titelv=?, Vorname=?, Nachname=?, Titeln=? WHERE ID=?";
			PreparedStatement update_Ku = con.prepareStatement(updateString);
			update_Ku.setString(1, titelv);
			update_Ku.setString(2, vorname);
			update_Ku.setString(3, nachname);
			update_Ku.setString(4, titeln);
			update_Ku.setInt(5, id);
			update_Ku.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}

	public static void update_Be(Connection con, int id, int kid, int arid, int alid) {
		try {
			String updateString = "UPDATE Bestellung_v3 SET Kunde_ID=?, Adrresse_Rechnung_ID=?, Adresse_Liefer_ID=?, WHERE ID=?";
			PreparedStatement update_Be = con.prepareStatement(updateString);
			update_Be.setInt(1, kid);
			update_Be.setInt(2, arid);
			update_Be.setInt(3, alid);
			update_Be.setInt(4, id);
			update_Be.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}

	public static void update_Ar(Connection con, int id, String name, double preis) {
		try {
			String updateString = "UPDATE Artikel SET Stadt=?, Name=?, WHERE ID=?";
			PreparedStatement update_Ar = con.prepareStatement(updateString);
			update_Ar.setString(1, name);
			update_Ar.setDouble(2, preis);
			update_Ar.setInt(3, id);
			update_Ar.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Etwas stimmt nicht");
		}
	}

	public static void update_Ad(Connection con, int id, String stadt, String strasse, int plz, String hnr) {
		try {
			String updateString = "UPDATE Adresse SET Stadt=?, Strasse=?, PLZ=?, Hnr=?, WHERE ID=?";
			PreparedStatement update_Ad = con.prepareStatement(updateString);
			update_Ad.setString(1, stadt);
			update_Ad.setString(2, strasse);
			update_Ad.setInt(3, plz);
			update_Ad.setString(4, hnr);
			update_Ad.setInt(5, id);
			update_Ad.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}



	public static void update_BeAr(Connection con, int bestid, int artid, int menge) {
		try {
			String updateString = "UPDATE Bestellung_Artikel SET Menge=? WHERE Bestell_ID=? AND Artikel_ID=?";
			PreparedStatement update_BeAr = con.prepareStatement(updateString);
			update_BeAr.setInt(2, bestid);
			update_BeAr.setInt(3, artid);
			update_BeAr.setInt(1, menge);
			update_BeAr.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}

	public static void select_Ku(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM Kunde WHERE id=?";
			PreparedStatement select_Ku = con.prepareStatement(selectString);
			select_Ku.setInt(1, id);
			ResultSet rs = select_Ku.executeQuery();
			rs.next();
			System.out.println("------------------------------");
			System.out.println("TitelV: " + rs.getString("titelv"));
			System.out.println("Vorname: " + rs.getString("vorname"));
			System.out.println("Nachname: " + rs.getString("nachname"));
			System.out.println("TitelN: " + rs.getString("titeln"));
			System.out.println("------------------------------");
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht!");
		}
	}
	
	public static void select_Be(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM Bestellung_v3 WHERE id=?";
			PreparedStatement select_Be = con.prepareStatement(selectString);
			select_Be.setInt(1, id);
			ResultSet rs = select_Be.executeQuery();
			rs.next();
			System.out.println("------------------------------");
			System.out.println("ID Kunde: " + rs.getInt("kunde_ID"));
			System.out.println("ID Adresse-Rechnung: " + rs.getInt("adresse_Rechnung_ID"));
			System.out.println("ID Adresse-Lieferunng: " + rs.getInt("adresse_Liefer_ID"));
			System.out.println("------------------------------");
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}
	
	public static ResultSet select_KuR(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM Kunde WHERE id=?";
			PreparedStatement select_Ku = con.prepareStatement(selectString);
			select_Ku.setInt(1, id);
			ResultSet rs = select_Ku.executeQuery();
			return(rs);
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
		return null;
	}

	public static ResultSet select_BeR(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM Bestellung_v3 WHERE id=?";
			PreparedStatement select_Be = con.prepareStatement(selectString);
			select_Be.setInt(1, id);
			ResultSet rs = select_Be.executeQuery();
			return rs;
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
		return null;
	}

	public static void select_Ad(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM Adresse WHERE id=?";
			PreparedStatement select_Ad = con.prepareStatement(selectString);
			select_Ad.setInt(1, id);
			ResultSet rs = select_Ad.executeQuery();
			rs.next();
			System.out.println("------------------------------");
			System.out.println("Stadt: " + rs.getString("stadt"));
			System.out.println("Straße: " + rs.getString("strasse"));
			System.out.println("PLZ: " + rs.getInt("plz"));
			System.out.println("Hausnummer: " + rs.getString("hnr"));
			System.out.println("------------------------------");
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}
	
	public static void select_Ar(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM Kunde WHERE id=?";
			PreparedStatement select_Ar = con.prepareStatement(selectString);
			select_Ar.setInt(1, id);
			ResultSet rs = select_Ar.executeQuery();
			rs.next();
			System.out.println("------------------------------");
			System.out.println("Name: " + rs.getString("name"));
			System.out.println("Preis: " + rs.getInt("preis"));
			System.out.println("------------------------------");
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}

	public static ResultSet select_AdR(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM Adresse WHERE id=?";
			PreparedStatement select_Ad = con.prepareStatement(selectString);
			select_Ad.setInt(1, id);
			ResultSet rs = select_Ad.executeQuery();
			return(rs);
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
		return null;
	}

	public static ResultSet select_ArR(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM Kunde WHERE id=?";
			PreparedStatement select_Ar = con.prepareStatement(selectString);
			select_Ar.setInt(1, id);
			ResultSet rs = select_Ar.executeQuery();
			return rs;
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht!");
		}
		return null;
	}

	public static void select_BeAr(Connection con, int bestid, int artid) {
		try {
			String selectString = "SELECT * FROM Bestellung_Artikel WHERE Bestell_ID=? AND Artikel_ID=?";
			PreparedStatement select_BeAr = con.prepareStatement(selectString);
			select_BeAr.setInt(1, bestid);
			select_BeAr.setInt(2, artid);
			ResultSet rs = select_BeAr.executeQuery();
			rs.next();
			System.out.println("------------------------------");
			System.out.println("ID Bestellung: " + rs.getInt("bestell_ID"));
			System.out.println("ID Artikel: " + rs.getInt("artikel_ID"));
			System.out.println("Artikelmenge: " + rs.getInt("menge"));
			System.out.println("------------------------------");
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
	}

	public static ResultSet select_BeArR(Connection con, int bestid, int artid) {
		try {
			String selectString = "SELECT * FROM Bestellung_Artikel WHERE Bestell_ID=? AND Artikel_ID=?";
			PreparedStatement select_BeAr = con.prepareStatement(selectString);
			select_BeAr.setInt(1, bestid);
			select_BeAr.setInt(2, artid);
			ResultSet rs = select_BeAr.executeQuery();
			return rs;
		} catch (SQLException ex) {
			System.out.println("Etwas stimmt nicht");
		}
		return null;
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Postgre database = new Postgre();
		boolean finished = false;
		
		Class.forName("com.postgresql.Driver");
		Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bestellungen?user=root&password=Jenny12");
		Scanner s = new Scanner(System.in);
		System.out.println("Table: Kunde, Bestellung, Adresse, BestellungArtikel, Artikel");
		
		while (!finished) {
			System.out.println("R für read, C für create, U für update, D für delete:");
			String input = s.nextLine();
			
			if (input.equals("R")) {
				System.out.println("bitte Table-name und ID (2IDs BeAr)");
				input = s.nextLine();
				String in[] = input.split(" ");
				
				if (in[0].equals("Kunde")) {
					try {
						select_Ku(c, Integer.parseInt((in[1])));
					} catch (Exception ex) {
						System.out.println("Fehler!");
					}
				} else if (in[0].equals("Bestellung")) {
					try {
						select_Be(c, Integer.parseInt((in[1])));
					} catch (Exception ex) {
						System.out.println("Fehler!");
					}
				} else if (in[0].equals("Adresse")) {
					try {
						select_Ad(c, Integer.parseInt((in[1])));
					} catch (Exception ex) {
						System.out.println("Fehler!");
					}
				} else if (in[0].equals("BestellungArtikel")) {
					try {
						select_BeAr(c, Integer.parseInt((in[1])), Integer.parseInt(in[2]));
					} catch (Exception ex) {
						System.out.println("Fehler!");
					}
				} else if (in[0].equals("Artikel")) {
					try {
						select_Ar(c, Integer.parseInt((in[1])));
					} catch (Exception ex) {
						System.out.println("Fehler!");
					}
				} else {
					System.out.println("Fehler!");
				}
				
				
			} else if (input.equals("C")) {
				System.out.println("B for Bestellung, BA for Bestellung_Artikel, K for Kunde, Ad for Adresse, Ar for Artikel");
				String create = s.nextLine();
				
				if(create.equals("B")){
					System.out.print("Kunde_ID:");
					int kunde_id = s.nextInt();
					System.out.print("Rechnung_ID:");
					int rechnung_id = s.nextInt();
					System.out.print("Liefer_ID:");
					int liefer_id = s.nextInt();
					database.Create_Be(c, kunde_id, rechnung_id, liefer_id);
				}
			
				if(create.equals("BA")){
					System.out.print("Bestell_ID:");
					int bestell_id = s.nextInt();
					System.out.print("TArtikel_ID:");
					int artikel_id = s.nextInt();
					System.out.print("Menge:");
					int menge = s.nextInt();
					database.Create_BeAr(c,bestell_id, artikel_id, menge);
				}

				if(create.equals("K")){
					System.out.print("Titel vorgestellt:");
					String titelvor = s.nextLine();
					System.out.print("Vorname:");
					String vorname = s.nextLine();
					System.out.print("Nachname:");
					String nachname = s.nextLine();
					System.out.print("Titel nachgestellt:");
					String titelnach = s.nextLine();
					database.Create_KU(c,titelvor,vorname,nachname,titelnach);
				}
				
				if(create.equals("Ad")){
					System.out.print("Stadt:");
					String stadt = s.nextLine();
					System.out.print(" Strasse:");
					String strasse = s.nextLine();
					System.out.print("PLZ:");
					int plz = s.nextInt();
					System.out.print("Hausnummer:");
					String hnr = s.nextLine();
					database.Create_Ad(c,stadt,strasse,plz,hnr);
				}

				if(create.equals("Ar")){
					System.out.print("Artikelname:");
					String name = s.nextLine();
					System.out.print("Preis:");
					int preis = s.nextInt();
					database.Create_Ar(c,name,preis);
				}
				
			} else if (input.equals("U")) {
				System.out.println("bitte Table-name und attributes:");
				input = s.nextLine();
				String in[] = input.split(" ");
				
				if (in[0].equals("Kunde")) {
					for(int i=2;i<in.length;i++) {
						if(in[i].equals(":")) {
							in[i]=select_KuR(c,Integer.parseInt(in[1])).getString(i-1);
						}
					}
					update_Ku(c,Integer.parseInt(in[1]),in[2],in[3],in[4],in[5]);
				} else if (in[0].equals("Bestellung")) {
					for(int i=2;i<in.length;i++) {
						if(in[i].equals(":")) {
							in[i]=select_BeR(c,Integer.parseInt(in[1])).getString(i-1);
						}
					}
					update_Be(c,Integer.parseInt(in[1]),Integer.parseInt(in[2]),Integer.parseInt(in[3]),Integer.parseInt(in[4]));
				} else if (in[0].equals("Adresse")) {
					for(int i=2;i<in.length;i++) {
						if(in[i].equals(":")) {
							in[i]=select_AdR(c,Integer.parseInt(in[1])).getString(i-1);
						}
					}
					
					update_Ad(c,Integer.parseInt(in[1]),in[2],in[3],Integer.parseInt(in[4]),in[5]);
				} else if (in[0].equals("BestellungArtikel")) {
					for(int i=3;i<in.length;i++) {
						if(in[i].equals(":")) {
							in[i]=select_BeArR(c,Integer.parseInt(in[1]), Integer.parseInt(in[2])).getString(i-1);
						}
					}
					
					update_BeAr(c,Integer.parseInt(in[1]),Integer.parseInt(in[2]),Integer.parseInt(in[3]));
				} else if (in[0].equals("Artikel")) {
					for(int i=2;i<in.length;i++) {
						if(in[i].equals(":")) {
							in[i]=select_ArR(c,Integer.parseInt(in[1])).getString(i-1);
						}
					}
					
					update_Ar(c,Integer.parseInt(in[1]),in[2],Double.parseDouble(in[3]));
				} else {
					System.out.println("Fehler!");
				}
			}
			
			else if (input.equals("D")) {
				System.out.println("bitte Table-name und ID (2IDs BeAr):");
				input = s.nextLine();
				String in[] = input.split(" ");
				
				if (in[0].equals("Kunde")) {
					delete_Ku(c,Integer.parseInt(in[1]));
				} else if (in[0].equals("Bestellung")) {
					delete_Be(c,Integer.parseInt(in[1]));
				} else if (in[0].equals("Adresse")) {
					delete_Ad(c,Integer.parseInt(in[1]));
				} else if (in[0].equals("BestellungArtikel")) {
					delete_BeAr(c,Integer.parseInt(in[1]),Integer.parseInt(in[2]));
				} else if (in[0].equals("Artikel")) {
					delete_Ar(c,Integer.parseInt(in[1]));
				}
			
			} else {
				System.out.println("Fehler!");
			}
		}

		System.out.println("Fertig!");
		s.close();
	}
} 
