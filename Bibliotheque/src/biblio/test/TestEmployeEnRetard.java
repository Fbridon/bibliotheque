package biblio.test;

import java.time.LocalDate;
import java.time.Month;

import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;
import biblio.metier.BiblioException;
import biblio.metier.Employe;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Exemplaire;

public class TestEmployeEnRetard {

	public static void main(String[] args) {

		System.out.println("1.3");
		ExemplaireDao exemplaireDao = new ExemplaireDao();
		Exemplaire ex1 = exemplaireDao.findByKey(1);
		System.out.println(ex1);
		Exemplaire ex2 = exemplaireDao.findByKey(2);
		System.out.println(ex2);

		UtilisateurDao utilisateurDao = new UtilisateurDao();

		System.out.println("Demande d'un employe par son id aux DAO");
		Employe em1 = (Employe) utilisateurDao.findByKey(2);
		System.out.println("ad1 = " + em1);
//		System.out.println("a1 = instanceof Adherent ? " + (UtilisateurDao.findByKey(1) instanceof Adherent));
		
		System.out.println("Création d'un emprunt en retard au 01 jan 2020 pour l'employe");
		EmpruntEnCours ep2 = new EmpruntEnCours(em1, ex2, LocalDate.of(2020, Month.JANUARY, 01));
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
		System.out.println("----------");
		
	}
}
