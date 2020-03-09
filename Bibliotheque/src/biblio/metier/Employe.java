package biblio.metier;

public class Employe extends Utilisateur {

	private String codeMatricule;
	private EnumCategorieEmploye categorieEmploye;

	// Constructeur
	
	public Employe(int idUtilisateur, String nom, String prenom, String pseudonyme, String pwd) {
		super(idUtilisateur, nom, prenom,pseudonyme,pwd);
	}
	public Employe(String nom, String prenom) {
		super(nom, prenom);
	}

	public Employe() {
		super();
	}

	// Accesseur / Getter
//	public Livre getEmprunt() {
//		return emprunt;
//	}
	public EnumCategorieEmploye getCategorieEmploye() {
		return categorieEmploye;
	}
	// Mutateur / Setter
	public void setCodeMatricule(String codeMatricule) {
		this.codeMatricule = codeMatricule;
	}

	public void setCategorieEmploye(EnumCategorieEmploye categorieEmploye) {
		this.categorieEmploye = categorieEmploye;
	}

	@Override
	public String toString() {
//		return super.toString() + "\n codeMatricule : "+codeMatricule+"\n";
		return super.toString() + "\n";
	}
}
