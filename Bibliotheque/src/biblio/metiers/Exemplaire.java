package biblio.metiers;

import java.time.LocalDate;

public class Exemplaire {
	//variables
	 private int idExemplaire;
	 private LocalDate dateAchat;
	 private String isbn;
	 private EnumStatusExemplaire status = EnumStatusExemplaire.Disponible;
	 private EmpruntEnCours empruntEnCours = null;
	 
	 //constructeurs
	 //constructeur avec parametres
	 public Exemplaire(int idExemplaire,String isbn,LocalDate dateAchat) {

		 this.idExemplaire = idExemplaire;
		 this.isbn = isbn;
		 this.dateAchat = dateAchat;
	}
	 //constructeur a vide
	 public Exemplaire() {

	}
	
	 //getters
	 public int getIdExemplaire() {
		 return idExemplaire;
	 }
	 
	 public String getIsbn() {
		 return isbn;
	 }
	 
	 public LocalDate getDateAchat() {
		 return dateAchat;
	 }
	 
	 public EnumStatusExemplaire getStatus() {
		 return status;
	 }
	 
	 //setters 
	 public void setIdExemplaire(int idExemplaire) {
		 this.idExemplaire = idExemplaire;
	 }
	 
	 public void setIsbn(String isbn) {
		 this.isbn = isbn;
	 }
	 
	 public void getDateAchat(LocalDate dateAchat) {
		 this.dateAchat = dateAchat;
	 }
	 
	 public void setStatus(EnumStatusExemplaire status) {
		 this.status = status;
	 }
	 
	 public void setEmpruntEnCours(EmpruntEnCours emprunEnCours) {
		 this.empruntEnCours = emprunEnCours;
		 setStatus(EnumStatusExemplaire.Prete);
	 }
	 
	 public boolean isDisponible() {
		 if(status == EnumStatusExemplaire.Disponible)
			 return true;
		 else
			 return false;
	 }
	 
	 @Override
	 public String toString() {
		 return "\n\t l'exemplaire concerné :"+getIdExemplaire()+"\n\t acheté le " + getDateAchat()+"\n\t du numéro ISBN :" + getIsbn() +"\n\t est actuellement : " + getStatus();
	 }
	 
}
