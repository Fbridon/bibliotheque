package biblio.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import biblio.metier.EmpruntArchive;

public class Utilisateur extends Personne {
	private int idUtilisateur;
	private String pwd;
	private String pseudonyme;
	private ArrayList<EmpruntEnCours> empruntEnCours = new ArrayList<EmpruntEnCours>(); // static

	// Constructeur
	public Utilisateur(int idUtilisateur, String nom, String prenom, String pseudonyme, String pwd) {
		super(nom, prenom);
		this.idUtilisateur = idUtilisateur;
		this.pseudonyme = pseudonyme;
		this.pwd = pwd;
	}

	public Utilisateur(String nom, String prenom) {
		super(nom, prenom);
	}

	public Utilisateur() {
		super();
	}

	// Accesseur / Getter
	public ArrayList<EmpruntEnCours> getEmpruntEnCours() {
		return this.empruntEnCours;
	}

	public int getNbEmpruntEnCours() {
		return this.empruntEnCours.size();
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	// Mutateur / Setter
//	public void setEmprunt(Livre livre) {
//		this.emprunt = livre;
//	}
//
//	public Livre findLivreByTitre(String Titre) {
//		for (Livre l : empruntEnCours) {
//			if (l.getTitre() == Titre) {
//				return l;
//			}
//		}
//		return null;
//	}

//	public ArrayList<Livre> findAllLivres() {
//		return this.empruntEnCours;
//	}

//	public void clearLivres() {
//		for (Exemplaire excemplaire : empruntEnCours) {
//			excemplaire.setStatus(EnumStatusExemplaire.DISPONIBLE);
//		}
//		this.empruntEnCours.clear();
//	}

//	public boolean containsLivre(Livre livre) {
//		if (livre.getStatus() == EnumStatusLivre.PRETE) {
//			return true;
//		} else {
//			return false;
//		}
//	}

//	public void removeLivre(Livre livre) {
//		livre.setStatus(EnumStatusLivre.DISPONIBLE);
//	}

	public void addEmpruntEnCours(EmpruntEnCours ep) throws BiblioException {
		if (!ep.getExemplaire().isDisponible()) {
			throw new BiblioException("exemplaire indisponible !");
		} else {
			if (this instanceof Adherent && getNbEmpruntEnCours() >= Adherent.getNbMaxPrets()) {
					throw new BiblioException("limite d'emprunt atteint !");
			} else {
				empruntEnCours.add(ep);
//			livre.setDateEmprunt(datesys);
				ep.setEmprunteur(this);
				ep.getExemplaire().setStatus(EnumStatusExemplaire.PRETE);
			}
		}
	}
	public void removeEmpruntEnCours(EmpruntEnCours empruntEnCours) {
		empruntEnCours.getExemplaire().setStatus(EnumStatusExemplaire.DISPONIBLE);
		new EmpruntArchive(empruntEnCours.getDateEmprunt(), LocalDate.now());
		empruntEnCours.getEmprunteur().getEmpruntEnCours().remove(empruntEnCours);
	}

	@Override
	public String toString() {
		if (getNbEmpruntEnCours() == 0) {
			return super.toString();
		} else {
			return super.toString() + "\n emprunt :\n" + empruntEnCours;
		}
	}
}
