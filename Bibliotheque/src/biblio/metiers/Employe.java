package biblio.metiers;

public class Employe extends Utilisateur {
	//variables
	private String codeMatricule;
	private EnumCategorieEmploye categorieEmploye;
	
	
	//constructor
	public Employe(int idUtilisateur,String pseudonyme,String pwd,String nom,String prenom) {
		super(idUtilisateur,pseudonyme,pwd,nom,prenom);
	}
	//constructor with only real id
	public Employe(String nom,String prenom) {
		super(nom,prenom);
	}
	//constructor a vide
	public Employe() {
		super();
	}
	
	//getter
	public String getCodeMatricule() {
		return codeMatricule;
	}
	
	public EnumCategorieEmploye getCategorieEmploye() {
		return categorieEmploye;
	}
	
	//setter
	public void setCodeMatricule(String codeMatricule) {
		this.codeMatricule = codeMatricule;
	}
	
	public void setCategorieEmploye(EnumCategorieEmploye categorieEmploye) {
		this.categorieEmploye = categorieEmploye;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
