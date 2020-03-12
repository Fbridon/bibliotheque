package biblio.metiers;

import java.time.LocalDate;
import java.util.ArrayList;

import biblio.exception.BiblioException;

public class Utilisateur extends Personne {
	private int idUtilisateur;
	private String pwd;
	private String pseudonyme;
	private ArrayList<EmpruntEnCours> empruntEnCours = new ArrayList<EmpruntEnCours>();	
	//constructeur 
	public Utilisateur(int idUtilisateur,String pseudonyme,String pwd,String nom,String prenom) {

		super(nom,prenom);
		this.idUtilisateur = idUtilisateur;
		this.pwd = pwd;
		this.pseudonyme = pseudonyme;
	}
	
	public Utilisateur(String nom, String prenom) {
		super(nom,prenom);
	}
	
	public Utilisateur() {
		super();
	}


	//getters
	public  int getIdUtilisateur() {
		return idUtilisateur;
	}
	
	
	public String getPseudonyme() {
		return pseudonyme;
	}
	
	public ArrayList<EmpruntEnCours> getEmpruntEnCours(){
		return empruntEnCours;
	}
	
	public int getNbEmpruntEnCours() {
		return empruntEnCours.size();
	}
	
	public void addEmpruntEnCours(EmpruntEnCours ep) throws BiblioException{
		if(!ep.getExemplaire().isDisponible())
			throw new BiblioException("exemplaire non disponible !");
		else if(this instanceof Adherent && getNbEmpruntEnCours() >= Adherent.getNbmaxPrets())
			throw new BiblioException("capacité d'emprunts maximale atteinte");
		else {
			empruntEnCours.add(ep);
			ep.setEmprunteur(this);
			ep.getExemplaire().setStatus(EnumStatusExemplaire.Prete);
		}
	}
	
	public void rmEmpruntEnCours(EmpruntEnCours empruntEnCours) {
		empruntEnCours.getExemplaire().setStatus(EnumStatusExemplaire.Disponible);
		new EmpruntArchive(empruntEnCours.getDateEmprunt(), LocalDate.now());
		empruntEnCours.getEmprunteur().getEmpruntEnCours().remove(empruntEnCours);
	}
	
	@Override
	public String toString() {
		if(getNbEmpruntEnCours() == 0)
			return super.toString();
		else
			return super.toString() + "\n Empruunts en cours : \n\t " + empruntEnCours; 
	}
}

