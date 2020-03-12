package biblio.metiers;

import java.time.LocalDate;

public class EmpruntEnCours {
	//variables
	private Utilisateur emprunteur;
	private Exemplaire exemplaire;
	private LocalDate dateEmprunt;
	
	//constructeur
	public EmpruntEnCours(Utilisateur ut,Exemplaire exemp,LocalDate dateEmprunt) {
		// TODO Auto-generated constructor stub
		setEmprunteur(ut);
		setExemplaire(exemp);
		setDateEmprunt(dateEmprunt);
	}
	
	//setters
	public void setEmprunteur(Utilisateur u) {
		this.emprunteur = u;
	}
	
	public void setExemplaire(Exemplaire ex) {
		this.exemplaire = ex;
	}
	public void setDateEmprunt(LocalDate d) {
		this.dateEmprunt = d;
	}
	
	//getters
	public Utilisateur getEmprunteur() {
		return emprunteur;
	}
	
	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	
	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}
	
	@Override
	public String toString() {
		return "Emprunt concerné :" + exemplaire ;
	}
}
