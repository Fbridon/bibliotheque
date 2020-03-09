package biblio.metier;


import java.time.LocalDate;

public class Exemplaire{
	// Variables
	private int idExemplaire;
	private String isbn;
	private LocalDate dateAchat;
	private EnumStatusExemplaire status = EnumStatusExemplaire.DISPONIBLE;
	private EmpruntEnCours empruntEnCours = null;
	
	// Constructeur
	public Exemplaire(int idExemplaire, String isbn, LocalDate dateAchat) {
		this.idExemplaire = idExemplaire;
		this.isbn = isbn;
		this.dateAchat = dateAchat;
	}

	public Exemplaire() {
	}

	// Accesseur / Getter
	public LocalDate getDateAchat() {
		return dateAchat;
	}
	
	public int getIdExemplaire() {
		return idExemplaire;
	}
	public String getIsbn() {
		return isbn;
	}
	
	public EnumStatusExemplaire getStatus() {
		return status;
	}


	// Mutateur / Setter
	public void setStatus(EnumStatusExemplaire status) {
		this.status = status;
	}
	
	public void setEmpruntEnCours(EmpruntEnCours empruntEnCours) {
		this.empruntEnCours = empruntEnCours;
		setStatus(EnumStatusExemplaire.PRETE);
	}
	////////

	@Override
	public String toString() {
		return "\nL'exemplaire " + idExemplaire + " acheté le "+getDateAchat()+" avec n° isbn : "+ getIsbn()+" est : \n" + getStatus() + "\n ";
	}

	public boolean isDisponible() {
		if (status == EnumStatusExemplaire.DISPONIBLE)
			return true;
		else
			return false;
	}

//	public void afficheToi() {
////		System.out.print(this.toString());
//		System.out.print(this);
//	}
}
