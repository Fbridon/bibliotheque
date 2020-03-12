package biblio.metiers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import biblio.exception.BiblioException;

public class Adherent extends Utilisateur {
	private String telephone ;
	private static final int nbMaxPrets = 3;
	private static final int dureeMaxPrets = 15;
	
	public Adherent(int idUtilisateur,String pseudonyme,String pwd,String nom,String prenom) {
		// TODO Auto-generated constructor stub
		super(idUtilisateur,pseudonyme,pwd,nom,prenom);
	}
	public Adherent(String nom, String prenom) {
		// TODO Auto-generated constructor stub
		super(nom,prenom);
	}
	public Adherent() {
		super();
	}
	
	public static int getNbmaxPrets() {
		return nbMaxPrets;
	}
	
	public void setTelephone(String tel) {
		this.telephone = tel;
	}
	
	public int getNbRetards() {
		int duree = 0,nbRetards = 0;
		for(EmpruntEnCours ep :this.getEmpruntEnCours()) {
			duree = (int) ChronoUnit.DAYS.between(ep.getDateEmprunt(),LocalDate.now());
			if (duree >= dureeMaxPrets) 
			nbRetards++;
		}
		return nbRetards;
	}
	
	public boolean isConditionsPretsAcceptes() throws BiblioException{
		if(this.getNbRetards() == 0)
			return true;
		else {
			throw new BiblioException("Pret impossible : retard detecté !");
		}
	}
}

