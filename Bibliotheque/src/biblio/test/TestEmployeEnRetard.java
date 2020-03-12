package biblio.test;

import biblio.dao.*;
import biblio.exception.*;
import biblio.metiers.*;
import java.time.*;

public class TestEmployeEnRetard {

	public static void main(String[] args) {
	
		System.out.println("1.3");
		ExemplairesDao exemplaireDao = new ExemplairesDao();
		Exemplaire ex1 = exemplaireDao.findByKey(1);
		System.out.println(ex1);
		Exemplaire ex2 = exemplaireDao.findByKey(2);
		System.out.println(ex2);

		UtilisateursDao utilisateurDao = new UtilisateursDao();

		System.out.println("Data Access de l'employe via son KeyId");
		Employe em1 = (Employe) utilisateurDao.findByKey(2);
		System.out.println(em1);
		System.out.println("Création d'un emprunt en retard au 01 fevrier 2020 pour l'employe");
		EmpruntEnCours ep2 = new EmpruntEnCours(em1, ex2, LocalDate.of(2020, Month.FEBRUARY, 01));
		try {
			if (ex2.isDisponible()) {
				em1.addEmpruntEnCours(ep2);
				ex2.setEmpruntEnCours(ep2);
			}
			System.out.println(em1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		
		System.out.println("Création d'un emprunt aujourd'hui pour l'employe");
		EmpruntEnCours ep1 = new EmpruntEnCours(em1, ex1, LocalDate.now());
		try {
			if (ex1.isDisponible()) {
				em1.addEmpruntEnCours(ep1);
				ex1.setEmpruntEnCours(ep1);
			}
			System.out.println(em1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		
	}
}
