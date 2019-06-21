package bdd;

public class Enseignant extends Personne{

	private String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Personne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + ", Grade=" + grade;
	}
}
