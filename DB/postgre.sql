DROP DATABASE IF EXISTS Bestellungen;
CREATE DATABASE Bestellungen;


CREATE table Artikel(
	ID		INTEGER		NOT NULL,
	name	VARCHAR(10)	NOT NULL,
	preis 	DOUBLE		NOT NULL,
	PRIMARY KEY (ID)
);

CREATE table Bestellung_Artikel(
	bestellung_ID	INTEGER		NOT NULL,
	artikel_ID		INTEGER		NOT NULL,
	menge		INTEGER		NOT NULL,
	PRIMARY KEY (bestellung_ID),
	PRIMARY KEY (artikel_ID),
	FOREIGN KEY(artikel_ID) references Artikel(ID),
	FOREIGN KEY(bestellung_ID) references Bestellung_v3(ID)
);

CREATE table Bestellung_v3(
	ID		INTEGER		NOT NULL,
	kunde_ID		INTEGER		NOT NULL,
	adresse_rechnung_ID		INTEGER		NOT NULL,
	adresse_liefer_ID		INTEGER		NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY(kunde_ID) references Kunde(ID),
	FOREIGN KEY(adresse_rechnung_ID) references Adresse(ID),
	FOREIGN KEY(adresse_liefer_ID) references Adresse(ID)
);

CREATE table Kunde(
	ID		INTEGER		NOT NULL,
	titelV	VARCHAR(10),
	vorname	VARCHAR(10)	NOT NULL,
	nachname	VARCHAR(10)	NOT NULL,
	titelN	VARCHAR(10),
	PRIMARY KEY (ID)
);

CREATE table Adresse(
	ID		INTEGER		NOT NULL,
	stadt	VARCHAR(10)	NOT NULL,
	strasse	VARCHAR(10)	NOT NULL,
	PLZ	INTEGER,
	Hnr INTEGER;
	PRIMARY KEY (ID)
);



