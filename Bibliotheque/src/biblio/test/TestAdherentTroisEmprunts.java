package biblio.test;

import java.time.LocalDate;

import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;
import biblio.metier.Adherent;
import biblio.metier.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Exemplaire;

public class TestAdherentTroisEmprunts {

	public static void main(String[] args) {

		System.out.println("1.4");
		ExemplaireDao exemplaireDao = new ExemplaireDao();
		Exemplaire ex1 = exemplaireDao.findByKey(1);
		System.out.println(ex1);
		Exemplaire ex2 = exemplaireDao.findByKey(2);
		System.out.println(ex2);
		Exemplaire ex3 = exemplaireDao.findByKey(3);
		System.out.println(ex3);
		Exemplaire ex4 = exemplaireDao.findByKey(4);
		System.out.println(ex4);
		System.out.println("----------");
		UtilisateurDao utilisateurDao = new UtilisateurDao();

		System.out.println("Demande d'un adhérent par son id aux DAO");
		Adherent ad1 = (Adherent) utilisateurDao.findByKey(1);
		System.out.println("ad1 = " + ad1);
//		System.out.println("a1 = instanceof Adherent ? " + (UtilisateurDao.findByKey(1) instanceof Adherent));
		System.out.println("----------");
		System.out.println("Création de trois emprunts récent pour l'adhérent\n");
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
		
		EmpruntEnCours ep2 = new EmpruntEnCours(ad1, ex2, LocalDate.now());
		try {
			if (ad1.isConditionsPretAcceptees() & ex2.isDisponible()) {
				ad1.addEmpruntEnCours(ep2);
				ex2.setEmpruntEnCours(ep2);
			}
			System.out.println(ad1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		EmpruntEnCours ep3 = new EmpruntEnCours(ad1, ex3, LocalDate.now());
		try {
			if (ad1.isConditionsPretAcceptees() & ex3.isDisponible()) {
				ad1.addEmpruntEnCours(ep3);
				ex2.setEmpruntEnCours(ep3);
			}
			System.out.println(ad1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		System.out.println("\ncréation d'un quatrième emprunt");
		EmpruntEnCours ep4 = new EmpruntEnCours(ad1, ex4, LocalDate.now());
		try {
			if (ad1.isConditionsPretAcceptees() & ex4.isDisponible()) {
				ad1.addEmpruntEnCours(ep4);
				ex4.setEmpruntEnCours(ep4);
			}
			System.out.println(ad1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		System.out.println("----------");
		
	}
}
