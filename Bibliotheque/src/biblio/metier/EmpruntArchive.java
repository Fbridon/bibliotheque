package biblio.metier;

import java.time.LocalDate;

public class EmpruntArchive {
	private LocalDate dateEmprunt;
	private LocalDate dateRestitutionEff;
	
	// Constructeur
	public EmpruntArchive(LocalDate dateEmprunt,LocalDate dateRestitutionEff) {
		setDateEmprunt(dateEmprunt);
		setDateRestitutionEff(dateRestitutionEff);

	}

	// Accesseur / Getter
	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}
	public LocalDate getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	// Mutateur / Setter
	public void setDateEmprunt(LocalDate d) {
		this.dateEmprunt = d;
	}
	public void setDateRestitutionEff(LocalDate d) {
		this.dateRestitutionEff = d;
	}

}
