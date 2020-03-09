package biblio.metier;

import java.time.LocalDate;

public class Personne {
	private String nom, prenom,sexe;
	private LocalDate dateDeNaissance;
	// Constructeur
	public Personne(String nom, String prenom) {
		setNom(nom);
		setPrenom(prenom);
	}
	public Personne() {
		setNom("");
		setPrenom("");
	}

	// Accesseur / Getter
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	public String getSexe() {
		return sexe;
	}

	// Mutateur / Setter
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "\nJe me nomme " + nom + " " + prenom + " !";
	}
}
