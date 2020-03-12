package biblio.dao;


import biblio.metiers.*;

//Cette Classe permet l'acc�s aux donn�es (dao)
//version "Mock object" : objet bouchon (pour les tests)

public class UtilisateursDao {
	// Tableau qui simule la Base de Donn�es des Utilisateurs
	private Utilisateur utilisateurDB[] = { 
			new Adherent(1, "frankbri", "pwdprivate", "Bridon", "Francois"),
			new Employe(2, "bibliothecaire1", "pwdprivate", "Holluige", "Anthony") 
			};

	// M�thode qui retourne l'utilisateur quand l'id est fourni
	public Utilisateur findByKey(int id) {
		for (Utilisateur utilisateur : utilisateurDB) {
			if (utilisateur.getIdUtilisateur() == id)
				return utilisateur;
		}
		return null;
	}
}
