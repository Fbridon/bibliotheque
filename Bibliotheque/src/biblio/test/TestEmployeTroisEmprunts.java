package biblio.test;

import biblio.dao.*;
import biblio.exception.*;
import biblio.metiers.*;
import java.time.*;

public class TestEmployeTroisEmprunts {
	
	public static void main(String[] args) {
		
		System.out.println("1.5");
		ExemplairesDao exemplaireDao = new ExemplairesDao();
		Exemplaire ex1 = exemplaireDao.findByKey(1);
		System.out.println(ex1);
		Exemplaire ex2 = exemplaireDao.findByKey(2);
		System.out.println(ex2);
		Exemplaire ex3 = exemplaireDao.findByKey(3);
		System.out.println(ex3);
		Exemplaire ex4 = exemplaireDao.findByKey(4);
		System.out.println(ex4);
		System.out.println("----------");
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		
		System.out.println("Data Access de l'employe via son KeyId");
		Employe em1 = (Employe) utilisateurDao.findByKey(2);
		System.out.println(em1);
		
		System.out.println("\nCréation de trois emprunts récent pour employe\n");
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
		
		EmpruntEnCours ep2 = new EmpruntEnCours(em1, ex2, LocalDate.now());
		try {
			if (ex2.isDisponible()) {
				em1.addEmpruntEnCours(ep2);
				ex2.setEmpruntEnCours(ep2);
			}
			System.out.println(em1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		EmpruntEnCours ep3 = new EmpruntEnCours(em1, ex3, LocalDate.now());
		try {
			if (ex3.isDisponible()) {
				em1.addEmpruntEnCours(ep3);
				ex2.setEmpruntEnCours(ep3);
			}
			System.out.println(em1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		System.out.println("\n Création d'un quatrième emprunt");
		EmpruntEnCours ep4 = new EmpruntEnCours(em1, ex4, LocalDate.now());
		try {
			if (ex4.isDisponible()) {
				em1.addEmpruntEnCours(ep4);
				ex4.setEmpruntEnCours(ep4);
			}
			System.out.println(em1.getEmpruntEnCours());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		
	}
}
