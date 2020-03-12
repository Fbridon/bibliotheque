package biblio.test;

import java.time.*;
import biblio.dao.*;
import biblio.exception.*;
import biblio.metiers.*;

public class TestRetours {
		
		public static void main(String[] args) {
			
			System.out.println("1.6");
			ExemplairesDao exemplaireDao = new ExemplairesDao();
			Exemplaire ex1 = exemplaireDao.findByKey(1);
			System.out.println(ex1);
			Exemplaire ex2 = exemplaireDao.findByKey(2);
			System.out.println(ex2);

			UtilisateursDao utilisateurDao = new UtilisateursDao();

			System.out.println("Data Acces adherent via son KeyId");
			Adherent ad1 = (Adherent) utilisateurDao.findByKey(1);
			System.out.println(ad1);

			System.out.println("Création de 2 emprunts pour l'adhérent");
			EmpruntEnCours ep1 = new EmpruntEnCours(ad1, ex1, LocalDate.now());
			try {
				if (ad1.isConditionsPretsAcceptes() & ex1.isDisponible()) {
					ad1.addEmpruntEnCours(ep1);
					ex1.setEmpruntEnCours(ep1);
				}
			} catch (BiblioException e) {
				e.printStackTrace();
			}
			EmpruntEnCours ep2 = new EmpruntEnCours(ad1, ex2, LocalDate.now());
			try {
				if (ad1.isConditionsPretsAcceptes() & ex2.isDisponible()) {
					ad1.addEmpruntEnCours(ep2);
					ex2.setEmpruntEnCours(ep2);
				}
			} catch (BiblioException e) {
				e.printStackTrace();
			}
			System.out.println("Nombre emprunt de l'adhérent : " + ad1.getNbEmpruntEnCours());
			System.out.println(ex1.getStatus());
			System.out.println(ex2.getStatus());
			
			ad1.rmEmpruntEnCours(ep2);
			System.out.println("Nombre emprunt de l'adhérent : " + ad1.getNbEmpruntEnCours());
			System.out.println("emprunt de l'adhérent");
			
			System.out.println(ep2);
		}
}
