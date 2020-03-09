package biblio.dao;

import java.time.LocalDate;
import java.time.Month;

import biblio.metier.Exemplaire;

//Cette Classe permet l'accès aux données (dao)
//version "Mock object" : objet bouchon (pour les tests)
public class ExemplaireDao {
	// Tableau qui simule la Base de Données des Utilisateurs
	private Exemplaire exemplaireDB[] = { 
			new Exemplaire(1, "isbn1", LocalDate.of(2017, Month.JANUARY,25)),
			new Exemplaire(2, "isbn2", LocalDate.of(2015, Month.JUNE,16)),
			new Exemplaire(3, "isbn3", LocalDate.of(2013, Month.JULY,01)),
			new Exemplaire(4, "isbn4", LocalDate.of(2011, Month.MAY,12))
			};

	// Méthode qui retourne l'utilisateur dont on fournit l'idUtilisateur
	public Exemplaire findByKey(int id) {
		for (Exemplaire exemplaire : exemplaireDB) {
			if (exemplaire.getIdExemplaire() == id)
				return exemplaire;
		}
		return null;
	}
}
