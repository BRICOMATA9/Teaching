/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 9 : Collectionner un nombre fixe d'objets
#	Section  : Quelques techniques utiles
#	Fichier  : Classe.java
#	Class    : Classe  
*/

public class Classe  {
  private  Etudiant  [] liste;
  public Classe()   {
		System.out.print("Nombre d'etudiants : ");
		int nbetudiants = Lire.i();
		liste = new Etudiant[nbetudiants];		
		for(int i = 0; i < liste.length; i ++)
			liste[i] = new Etudiant();
	}
 public void afficheLesEtudiants() 	{
  for (Etudiant e : liste) e.afficheUnEtudiant();
 }

 private  int ouEstLePlusPetit( int debut)  {
	int i = debut, j;
	for(j = debut+1; j < liste.length; j++)
		if (liste[j].quelleMoyenne() < liste[i].quelleMoyenne())
			i = j;
	return i;
 }
 public  void classerParMoyenne()  {
	int indiceDuPlusPetit ;
	Etudiant tmp;
	for(int i = 0; i < liste.length; i ++)   {
		indiceDuPlusPetit = ouEstLePlusPetit( i);
		tmp = liste[i];
		liste[i] = liste[indiceDuPlusPetit];
		liste[indiceDuPlusPetit] = tmp;
	}
 }
}