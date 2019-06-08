package modele;

public class Portefeuille{
  
    private String nom;   
    private String ID;   
    private int nombre_actions;  
    private String valeur_action;
    private String Total;

  

	public Portefeuille(String nom, String ID, int nombre_actions, String valeur_action,String Total,Object image,Object image2) {
        super();
        this.ID=ID;
        this.nom = nom;
        this.nombre_actions=nombre_actions;
        this.valeur_action=valeur_action;
        this.Total=Total;
     
       
    }


    public int getNombre_actions() {
		return nombre_actions;
	}


	public void setNombre_actions(int nombre_actions) {
		this.nombre_actions = nombre_actions;
	}


	public String getValeur_action() {
		return valeur_action;
	}


	public void setValeur_action(String valeur_action) {
		this.valeur_action = valeur_action;
	}

    public String getTotal() {
        return Total;
    }
 
    public void setTotal(String Total) {
        this.Total= Total;
    }
    /* Nom de l'entreprise */
    
   public String getNom() {
        return nom;
    }
 
    public void setNom(String nom) {
        this.nom= nom;
    }
 
    /* Nombre d'actions */
    
    public int getnombre_actions() {
        return nombre_actions;
    }
 
    public void setnombre_actions(int value) {
        this.nombre_actions = value;
    }

    public String getID(){
    	return ID;
    }

    public void setID(String ID){
    	this.ID=ID;
    }

    /* Valeur de l'action */
 
    public String getvaleur_action() {
        return valeur_action;
    }
 
    public void setvaleur_action(String valeur_action) {
        this.valeur_action = valeur_action;
    }
}