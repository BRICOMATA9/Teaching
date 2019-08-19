import java.util.List;
import java.util.ArrayList;
public final class MemoireUSB implements MemoireStockage {
	private  List < Bloc > blocs=new ArrayList < Bloc >();
	private final int capacité ;
	private int espaceUtilisé ; 
  
	public MemoireUSB ( int capacité ) { //Constructeur
		this.capacité=capacité;
		blocs.add(new BlocVide(capacité)); //	au depart on a qu'un seul Bloc vide de taille "capacité"
	}
	
	public int test(Fichier f){	//verifier s'il existe un Bloc vide suffisant 
		for(int i=0;i<blocs.size();i++) if(getBlocs(i).getNom()=="vide" && getBlocs(i).getTaille()>=f.getTaille()) return (i); 
			//on parcoure la liste et on verifier l'existance d'un Bloc vide suffisant 
				//s'il existe on retourne son indice 
		return -1;	//sinon on retourn -1
	}
	
	public void defragmentation(){	//pour fusionner les espaces libres
		List < Bloc > nouveau =new ArrayList < Bloc >();//declaration d'une nouvelle liste de Bloc 
		for(int i=0;i<blocs.size();i++)	if(!blocs.get(i).getNom().equals("vide")) nouveau.add(blocs.get(i)); 
			//on met tout les fichiers dans la nouvelle liste "nouveau"
		blocs=nouveau;//on affecte la nouvelle liste à l'ancienne 	
		blocs.add(new BlocVide(capacité-espaceUtilisé));	//on ajoute le Bloc vide resultant  
	}
 
	public int getCapacité(){	//retourne la capacité de la clé USB
		return capacité;
	}

	public int getEspaceUtilisé(){	//retourne l'espace utilisé
		return espaceUtilisé;
	}
	
	public boolean estPleine(){	//verifier si la clé USB est pleine
		if(espaceUtilisé<capacité)return false;
		else return true;
	}
 
	public void ajout (Fichier f){	//pour ajouter un fichier
		if(test(f)<0) defragmentation();//s'il n'existe pas un espace vide suffisant on fait la défragmentation 
		int c=blocs.get(test(f)).getTaille()-f.getTaille(); //"c" reçoit la taille du Bloc vide restant 
		blocs.add(test(f),f);// on ajoute le fichier a la liste  
		espaceUtilisé+=f.getTaille();	//on augmente l'espace utilisé
		blocs.set(test(f),new BlocVide (c));//on insert le Bloc vide restant juste après le fichier ajouté
	}

	public int getTailleBlocs(){	//retourne la taille de la liste
		return blocs.size();
	}
 	
	public Bloc getBlocs(int i){	//retourne le Bloc d'indice i
		return blocs.get(i);
 	}
	
	public Fichier getFichier (String name){	//retourne un fichier qui porte le nom "name"
		int i=0;
		while(!blocs.get(i).getNom().equals(name)) i++;
		return (Fichier)blocs.get(i);
	}
 
	public Fichier suppression (String nom){	//pour supprimer un fichier s'il existe
		int i=0;  	
		while(!blocs.get(i).getNom().equals(nom)) i++; //on fait notre recherche
		espaceUtilisé-=(blocs.get(i).getTaille());
		return (Fichier)blocs.set(i,new BlocVide(blocs.get(i).getTaille()));
			//on supprime le fichier de la liste et on retourne ce fichier		
	}
	
	private final static class BlocVide implements Bloc{	//cette class represente l'espace vide 
		private final int taille ;
		private String nom ;
		public BlocVide ( int taille ) { //Constructeur
			this.taille=taille; 
			this.nom="vide";
		}
		public int getTaille(){	//retourne la taille de l'espace vide
			return taille;
  	}
  
		public String getNom(){	//retourne le nom " vide" de l'espace vide
			return "vide";
		}
		public String toString(){ //pour afficher la taille de l'espace libre 
			return ""+getTaille();
		} 
		
	}
}

