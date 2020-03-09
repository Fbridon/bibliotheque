package biblio.metier;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Adherent extends Utilisateur {

	private String telephone;
	private static final int nbMaxPrets = 3;
	public static final int dureeMaxPret = 15;

	// Constructeur
	
	public Adherent(int idUtilisateur, String nom, String prenom, String pseudonyme, String pwd) {
		super(idUtilisateur, nom, prenom,pseudonyme,pwd);
	}
	
	public Adherent(String nom, String prenom) {
		super(nom, prenom);
	}

	public Adherent() {
		super();
	}

	// Accesseur / Getter
//	public Livre getEmprunt() {
//		return emprunt;
//	}
	public static int getNbMaxPrets() {
		return nbMaxPrets;
	}

	// Mutateur / Setter
	public void setTelephone(String tel) {
		this.telephone = tel;
	}

//	public void setEmprunt(Livre livre) {
//		this.emprunt = livre;
//	}
	public int getNbRetards() {
		int duree = 0, nbRetards = 0;
		for (EmpruntEnCours ep : this.getEmpruntEnCours()) {
			duree = (int) ChronoUnit.DAYS.between(ep.getDateEmprunt(), LocalDate.now());
			if (duree > 15) {
				nbRetards++;
			}
		}
		return nbRetards;
	}

	public boolean isConditionsPretAcceptees() throws BiblioException {
//		if (this.getNbRetards() == 0 && this.getNbEmpruntEnCours() < 3) {
		if (this.getNbRetards() == 0) {
			return true;
		} else {
			throw new BiblioException("Pret non accordé !");
//			return false;
		}
	}

//	public static boolean isPretEnRetard(Date dateEmpruntEffective, Date maintenant, int dureeMaxPret) {
//		Calendar calDateMin = Calendar.getInstance();
//		calDateMin.setTime(maintenant);
//		calDateMin.add(Calendar.DATE, -dureeMaxPret);
//
//		Calendar calDateEmprunt = Calendar.getInstance();
//		calDateEmprunt.setTime(dateEmpruntEffective);
//
//		return calDateEmprunt.before(calDateMin);
//	}

	@Override
	public String toString() {
		return super.toString() + "\n" ;
	}
}
