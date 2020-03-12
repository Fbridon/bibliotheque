package biblio.metiers;

import java.time.LocalDate;

public class EmpruntArchive {
	//variables
	private LocalDate dateEmprunt;
	private LocalDate dateRestitutionEff;
	
	//constructeur
	public EmpruntArchive(LocalDate dateEmprunt,LocalDate dateRestitutionEff) {
		// TODO Auto-generated constructor stub
		this.dateEmprunt = dateEmprunt;
		this.dateRestitutionEff = dateRestitutionEff;
	}
	
	//setters
	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	
	public void setDateRestitutionEff(LocalDate dateRestitutionEff) {
		this.dateRestitutionEff= dateRestitutionEff;
	}
	
	
	//getters
	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}
	
	public LocalDate getDateRestitutionEff() {
		return dateRestitutionEff;
	}
}
