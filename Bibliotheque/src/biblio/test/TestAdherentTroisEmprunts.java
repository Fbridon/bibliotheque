package biblio.test;

import biblio.dao.*;
import biblio.exception.*;
import biblio.metiers.*;
import java.time.LocalDate;

public class TestAdherentTroisEmprunts {
	
	public static void main(String[] args) {
		System.out.println("\n-------------------------------------------------------------------------");
		System.out.println("\n  1.4 test realisation de plus de trois exemplaires par un adherent");
		System.out.println("----------------------------------------------------------------------------");
		
		ExemplairesDao exemplaireDao = new ExemplairesDao();
		Exemplaire ex1 = exemplaireDao.findByKey(1);
		System.out.println(ex1);
		Exemplaire ex2 = exemplaireDao.findByKey(2);
		System.out.println(ex2);
		Exemplaire ex3 = exemplaireDao.findByKey(3);
		System.out.println(ex3);
		Exemplaire ex4 = exemplaireDao.findByKey(4);
		System.out.println(ex4);
		
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		System.out.println("\n\nData Access d'un Adherent via son ID");
		Adherent ad1 = (Adherent) utilisateurDao.findByKey(1);
		System.out.println(ad1);
		System.out.println("Création de trois emprunts récent pour l'adhérent\n");
		EmpruntEnCours ep1 = new EmpruntEnCours(ad1, ex1, LocalDate.now());
		try {
			if (ad1.isConditionsPretsAcceptes() & ex1.isDisponible()) {
				ad1.addEmpruntEnCours(ep1);
				ex1.setEmpruntEnCours(ep1);
			}
			System.out.println(ad1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		
		EmpruntEnCours ep2 = new EmpruntEnCours(ad1, ex2, LocalDate.now());
		try {
			if (ad1.isConditionsPretsAcceptes() & ex2.isDisponible()) {
				ad1.addEmpruntEnCours(ep2);
				ex2.setEmpruntEnCours(ep2);
			}
			System.out.println(ad1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		EmpruntEnCours ep3 = new EmpruntEnCours(ad1, ex3, LocalDate.now());
		try {
			if (ad1.isConditionsPretsAcceptes() & ex3.isDisponible()) {
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
			if (ad1.isConditionsPretsAcceptes() & ex4.isDisponible()) {
				ad1.addEmpruntEnCours(ep4);
				ex4.setEmpruntEnCours(ep4);
			}
			System.out.println(ad1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		
		
	}

}
