package biblio.metiers;


import java.time.LocalDate;

public class Personne {
	private String nom;
	private String prenom;
	private LocalDate dateDeNaissance;
	private String sexe;
	
	//constructeur avec parametres
	public Personne(String nom,String prenom) {
		setNom(nom);
		setPrenom(prenom);
	}

	//constructeur a vide
	public Personne() {

		setNom("");
		setPrenom("");
	}
	
	//getters
	public String getNom(){
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
	
	//setters
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;	
	}
	
	public void  setSexe(String sexe) {
		this.sexe= sexe;
	}
	
	//redefinition de toString pour afficher directement avec sysout
	@Override
	public String toString() {
		return "\nUtlisateur :"+"\n\t nom :"+nom+"\n\t prenom: "+prenom+"\n\t date de naissance: "+dateDeNaissance +"\n\t sexe:"+sexe; 
	}
	//public static void main(String[]  args) {
		//Personne personne = new Personne("jack","bob",LocalDate.parse("1980-05-08"),"Homme");
		//System.out.println(personne);
	//}
}
