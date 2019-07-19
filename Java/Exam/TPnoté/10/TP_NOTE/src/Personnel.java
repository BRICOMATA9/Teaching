import java.util.ArrayList;
import java.util.Scanner;


public class Personnel extends Employe 
{
	
	//Variables
	protected ArrayList<Employe>collection = new ArrayList<Employe>();
	private int semaine;
	
	//Getters & Setters
	public int Get_semaine()
	{
		return this.semaine;
	}
	public void set_semaine()
	{
		System.out.println("Pour quelle semaine voulez-vous afficher vos informations ? \n Doit être compris entre 1 et 5 !");
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner (System.in);
		String typing = keyboard.nextLine();
		int semaine_nombre = 0;
		boolean vérif = false;
		do 
		{
			if (typing==null)
			{
				vérif = false;
			}
			try 
			{
			    new java.math.BigDecimal(typing);
			    semaine_nombre = Integer.parseInt(typing); 
			    if ((semaine_nombre<=0) || (semaine_nombre>=5))
				{
				    vérif = true;
				}
			} catch (NumberFormatException e)			
			{
				vérif = false;
			}
			if (vérif==false)
			{
				System.out.println("Pour quelle semaine voulez-vous afficher vos informations ? \\n Doit être compris entre 1 et 5 !");
				typing = keyboard.nextLine();
			}
		}while (vérif==false);
		this.semaine = semaine_nombre;
	}
	//Methods
	void ajouterEmploye(Employe X) 
	{
		collection.add(X);
	}
	
	
	void AfficherHoraires(int i) 
	{
		String statut ="";
		String nom = "";
		int horaire = 0;	
		for (int j=0 ; j<(this.collection).size() ; j++)
		{
			collection.get(j).calculerHoraire(i);
			nom = collection.get(j).getNom();
			statut = collection.get(j).Get_Statut();
			horaire = collection.get(j).Get_horaire();
			System.out.println( statut+" "+nom + " " + horaire + " heures.");	
		}
	}
	
	void HoraireMensuel() {
		
		for(int i=0; i<collection.size() ; i++)
		{
			System.out.println(collection.get(i));
		}
	}
	
	public static void main(String[] args) {
		
		Personnel p = new Personnel();
		p.ajouterEmploye(new Vente("Pierre", "Business", 45, 2005));
		p.ajouterEmploye(new Vente("Leon", "Vendtout", 25, 2011));
		p.ajouterEmploye(new Production("Yves", "Bosseur", 28, 2000));
		p.ajouterEmploye(new Manutention("Jeanne", "Stockeout", 32, 2008));
		p.calculerHoraire(2);
		//System.out.println("Horaire moyen dans cette entreprise est de " +,p.HoraireMensuel() + "heures.");
		
	}
	
	public void verifierPrime(Employe P) throws ExceptionEmploye{
		
		if(P.date_recru<2007 && P.age>40) {
			
			//On affiche nom, prenom des employes concernes
			System.out.println(P.prenom);
			System.out.println(P.nom);
			
			
		}
		catch(ExceptionEmploye e){
				
		}
		
	}
	public Personnel(String nom, String prenom, int age, int date_recru) 
	{
		super(nom, prenom, age, date_recru);
	}
	

	public Personnel() {
		// TODO Auto-generated constructor stub
	}

	
}
