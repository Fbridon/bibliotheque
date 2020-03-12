package biblio.test;

import biblio.exception.*;
import java.time.LocalDate;
import biblio.dao.*;
import biblio.metiers.*;

public class TestAffichageResults {
		public static void main(String[] args) {
			System.out.println("----------------------------------------------");
			System.out.println("\ncas nominal utilisateur adherent ");
			System.out.println("----------------------------------------------");
			System.out.println("\n----------------------------------------------");
			System.out.println("\n  1.1.1 ");
			System.out.println("----------------------------------------------");
			ExemplairesDao exemplairesDao = new ExemplairesDao();
			Exemplaire ex1 = exemplairesDao.findByKey(1);
			System.out.println(ex1);
			Exemplaire ex2 = exemplairesDao.findByKey(2);
			System.out.println(ex2);
			
			System.out.println("\n----------------------------------------------");
			System.out.println("\n  1.1.2 Acces aux Datas d'un Adherent Par sa KeyID");
			System.out.println("----------------------------------------------");
			
			UtilisateursDao utilisateursDao = new UtilisateursDao();
			
			Adherent ad1 = (Adherent) utilisateursDao.findByKey(1);
			System.out.println(ad1);
			
			System.out.println("\n----------------------------------------------");
			System.out.println("\n  1.1.3 acces aux datas de l'employe par sa KeyId");
			System.out.println("----------------------------------------------");
			Employe em2 = (Employe) utilisateursDao.findByKey(2);
			System.out.println(em2);
			
			System.out.println("\n----------------------------------------------");
			System.out.println("\n  1.1.4 test emprunt realisé par un adhérent normal");
			System.out.println("----------------------------------------------");
			
			EmpruntEnCours ep1 = new EmpruntEnCours(ad1, ex1, LocalDate.now());
			try {
				ad1.addEmpruntEnCours(ep1);
				ex1.setEmpruntEnCours(ep1);
				System.out.println(ad1.getEmpruntEnCours());
			} catch (BiblioException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("\n----------------------------------------------");
			System.out.println("\n  1.1.5 test emprunt realisé par un employé");
			System.out.println("----------------------------------------------");
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
