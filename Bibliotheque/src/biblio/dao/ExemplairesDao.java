package biblio.dao;

import java.time.*;


import biblio.metiers.*;

//Cette Classe permet l'accès aux données (dao)
//version "Mock object" : objet bouchon (pour les tests)

public class ExemplairesDao {
		// Tableau qui simule la Base de Données des Utilisateurs
	private Exemplaire exemplaireDB[] = { 
	new Exemplaire(1, "ISBN1000", LocalDate.of(2017, Month.JANUARY,25)),
	new Exemplaire(2, "ISBN1001", LocalDate.of(2018, Month.JUNE,2)),
	new Exemplaire(3, "ISBN1002", LocalDate.of(1986, Month.JULY,21)),
	new Exemplaire(4, "ISBN1003", LocalDate.of(2008, Month.MAY,15))
	};
	
	// Méthode qui retourne l'exemplaire quand son id est fourni
	public Exemplaire findByKey(int id) {
		for (Exemplaire exemplaire : exemplaireDB) {
			if (exemplaire.getIdExemplaire() == id)
				return exemplaire;
		}
		return null;
	}

}
