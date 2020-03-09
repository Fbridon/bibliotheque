package biblio.metier;

import java.time.LocalDate;

public class EmpruntEnCours {
	private Utilisateur emprunteur;
	private Exemplaire exemplaire;
	private LocalDate dateEmprunt;
	
	// Constructeur
	public EmpruntEnCours(Utilisateur ut, Exemplaire exemp, LocalDate dateEmprunt) {
		setEmprunteur(ut);
		setExemplaire(exemp);
		setDateEmprunt(dateEmprunt);
//		exemp.setEmpruntEnCours(this);
	}

	// Accesseur / Getter
	public Utilisateur getEmprunteur() {
		return emprunteur;
	}
	
	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}

	// Mutateur / Setter
	public void setExemplaire(Exemplaire ex) {
		this.exemplaire = ex;
	}

	public void setEmprunteur(Utilisateur u) {
		this.emprunteur = u;
	}
	
	public void setDateEmprunt(LocalDate d) {
		this.dateEmprunt = d;
	}

	@Override
	public String toString() {
		return "EmpruntEnCours [exemplaire=" + exemplaire + "]";
	}

	
}
