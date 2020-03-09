package biblio.test;

import java.time.LocalDate;
import java.time.Month;

import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;
import biblio.metier.Adherent;
import biblio.metier.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Exemplaire;


public class TestAdherentEnRetard {

	public static void main(String[] args) {

		System.out.println("1.2");
		ExemplaireDao exemplaireDao = new ExemplaireDao();
		Exemplaire ex1 = exemplaireDao.findByKey(1);
		System.out.println(ex1);
		Exemplaire ex2 = exemplaireDao.findByKey(2);
		System.out.println(ex2);

		UtilisateurDao utilisateurDao = new UtilisateurDao();

		System.out.println("Demande d'un adhérent par son id aux DAO");
		Adherent ad1 = (Adherent) utilisateurDao.findByKey(1);
		System.out.println("ad1 = " + ad1);
//		System.out.println("a1 = instanceof Adherent ? " + (UtilisateurDao.findByKey(1) instanceof Adherent));
		
		System.out.println("Création d'un emprunt en retard au 01 jan 2020 pour l'adhérent");
		EmpruntEnCours ep2 = new EmpruntEnCours(ad1, ex2, LocalDate.of(2020, Month.JANUARY, 01));
		try {
			System.out.println(ad1.isConditionsPretAcceptees());
			if (ad1.isConditionsPretAcceptees() & ex2.isDisponible()) {
				ad1.addEmpruntEnCours(ep2);
				ex2.setEmpruntEnCours(ep2);
			}
			System.out.println(ad1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		
		System.out.println("Création d'un emprunt aujourd'hui pour l'adhérent");
		EmpruntEnCours ep1 = new EmpruntEnCours(ad1, ex1, LocalDate.now());
		try {
			if (ad1.isConditionsPretAcceptees() & ex1.isDisponible()) {
				ad1.addEmpruntEnCours(ep1);
				ex1.setEmpruntEnCours(ep1);
			}
			System.out.println(ad1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		System.out.println("----------");
		
	}
}
