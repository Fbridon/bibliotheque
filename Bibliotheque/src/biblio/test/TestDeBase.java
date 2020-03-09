package biblio.test;

import java.time.LocalDate;

import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;
import biblio.metier.Adherent;
import biblio.metier.BiblioException;
import biblio.metier.Employe;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Exemplaire;

public class TestDeBase {

	public static void main(String[] args) {

		System.out.println("1.1.1");
		System.out.println("Demande de deux exemplaires par leur id aux DAO");
		ExemplaireDao exemplaireDao = new ExemplaireDao();
//		Exemplaire e1 = exemplaireDao.findByKey(1);
//		System.out.println(e1);
		Exemplaire ex1 = exemplaireDao.findByKey(1);
		System.out.println(ex1);
		Exemplaire ex2 = exemplaireDao.findByKey(2);
		System.out.println(ex2);

		System.out.println("1.1.2 ");
		UtilisateurDao utilisateurDao = new UtilisateurDao();

		System.out.println("Demande d'un adhérent par son id aux DAO");
		Adherent ad1 = (Adherent) utilisateurDao.findByKey(1);
		System.out.println("ad1 = " + ad1);
//		System.out.println("a1 = instanceof Adherent ? " + (UtilisateurDao.findByKey(1) instanceof Adherent));

		System.out.println("1.1.3 ");
		System.out.println("Demande d'un employe par son id aux DAO");
		Employe em2 = (Employe) utilisateurDao.findByKey(2);
		System.out.println("em2 = " + em2);

		System.out.println("1.1.4 ");
		System.out.println("Création d'un emprunt en cours pour un adhérent");
		EmpruntEnCours ep1 = new EmpruntEnCours(ad1, ex1, LocalDate.now());
		try {
			ad1.addEmpruntEnCours(ep1);
			ex1.setEmpruntEnCours(ep1);
			System.out.println(ad1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}

		System.out.println("\n1.1.5 ");
		System.out.println("Création d'un emprunt en cours pour un employé");
		EmpruntEnCours ep2 = new EmpruntEnCours(em2, ex2, LocalDate.now());
		try {
			em2.addEmpruntEnCours(ep2);
			ex2.setEmpruntEnCours(ep2);
			System.out.println(em2.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
	}
}
