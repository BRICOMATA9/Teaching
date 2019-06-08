/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Exemples Chapitre 12 : Un composant JavaBean 
#	Exercice 12.5
#	Fichier : Phrase.java
#	Class : Phrase
*/
package librairieDeBean ;

import java.io.Serializable;

public class Phrase		implements java.io.Serializable {
	private String phrase ;
	public void setPhrase(String p){
		phrase = p;
		phrase = phrase.replace('a', '*');
		phrase = phrase.replace('o', '!');
		phrase = phrase.replace('e', '%');
	}
	public String getPhrase(){
		return phrase;
	}
} // Fin de Phrase
