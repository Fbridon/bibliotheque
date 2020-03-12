package biblio.test;

import biblio.dao.*;
import biblio.exception.*;
import biblio.metiers.*;
import java.time.*;


public class TestAdherentRetard {
	
		public static void main(String[] args) {
			
			System.out.println("1.2");
			ExemplairesDao exemplaireDao = new ExemplairesDao();
			Exemplaire ex1 = exemplaireDao.findByKey(1);
			System.out.println(ex1);
			Exemplaire ex2 = exemplaireDao.findByKey(2);
			System.out.println(ex2);

			UtilisateursDao utilisateurDao = new UtilisateursDao();

			System.out.println("Demande d'un adhérent par son id aux DAO");
			Adherent ad1 = (Adherent) utilisateurDao.findByKey(1);
			System.out.println(ad1);
			
			System.out.println("Création d'un emprunt en retard au 01 fevrier 2020 pour l'adhérent");
			EmpruntEnCours ep2 = new EmpruntEnCours(ad1, ex2, LocalDate.of(2020, Month.FEBRUARY, 01));
			try {
				System.out.println(ad1.isConditionsPretsAcceptes());
				if (ad1.isConditionsPretsAcceptes() & ex2.isDisponible()) {
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
				if (ad1.isConditionsPretsAcceptes() & ex1.isDisponible()) {
					ad1.addEmpruntEnCours(ep1);
					ex1.setEmpruntEnCours(ep1);
				}
				System.out.println(ad1.getEmpruntEnCours());
			} catch (BiblioException e) {
				e.printStackTrace();
			}
			
		}
	
	
}
