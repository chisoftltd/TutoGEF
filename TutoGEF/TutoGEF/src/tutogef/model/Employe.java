package tutogef.model;


public class Employe extends Node {
	private String prenom;
	public static final String PROPERTY_FIRSTNAME = "EmployePrenom";
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPrenom() {
		return this.prenom;
	}
}
