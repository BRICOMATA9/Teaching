package Controleur;

import Modele.*;

/**
 * Classe permettant de vérifier toutes les conditions nécessaires au bon déroulement du programme.
 * La vue est liée au contrôleur qui est elle-même liée au modèle.
 * @author Kiary
 */
public class Controleur {
    
    private Portefeuille portefeuilleControleur;
    
    /**
     * Constructeur surchargé.
     * @param pf le portefeuille qu'on souhaite manipuler.
     */
    public Controleur(Portefeuille pf){
        this.portefeuilleControleur=pf;
    }
    
    /**
     * Méthode liée avec l'affichage du menu dans la vue.<br>
     * On y effectue toutes les vérifications nécessaires au bon déroulement des actions souhaitées par l'utilisateur.
     * @param userChoice l'action que souhaite effectuer l'utilisateur.
     * @param keyUser la clé associée à ce que veut faire l'utilisateur.
     * @param amountUser le montant associé à ce que veut faire l'utilisateur / la clé associée à l'action de l'utilisateur.
     */
    public void actionMenu(int userChoice, String keyUser, String amountUser){
        
        switch(userChoice){
            // l'utilisateur ajoute un nouveau fonds dans un portefeuille
            case 1:
                try{
                    // on vérifie que la clé associée au nouveau fonds n'existe pas déjà
                    if(portefeuilleControleur.searchFunds(keyUser)==0){
                        try{
                            portefeuilleControleur.addFundsPortefeuille(keyUser, Double.parseDouble(amountUser));
                            System.out.println("Le fonds a bien été ajouté.");
                        } catch(FondsExistant fe){System.out.println(fe.getMessage());}
                    }
                    else if (portefeuilleControleur.searchFunds(keyUser)!=0){
                        System.out.println("Le fonds n'a pas été ajouté : cette clé est déjà utilisée.");
                    }
                } catch (FondsInexistant fi){System.out.println(fi.getMessage());}
                break;
                // l'utilisateur ajoute un nouveau fonds dans un instrument du portefeuille
            case 2:
                try{
                    // on vérifie que la clé associée au nouveau instrument n'existe pas déjà
                    if(portefeuilleControleur.searchInstrument(keyUser)!=null){
                        try{
                            // On vérifie que la clé associée au fonds qu'on souhaite ajouter à l'instrument existe déjà
                            if(portefeuilleControleur.searchFunds(amountUser)!=0){
                                Fonds f=portefeuilleControleur.getIDFunds().get(amountUser);
                                portefeuilleControleur.addFundsInInstrument(keyUser, f);
                                System.out.println("Le fonds a bien été ajouté dans l'instrument.");
                            }
                            else if(portefeuilleControleur.searchFunds(amountUser)==0){
                                System.out.println("Le fonds n'existe pas dans le portefeuille de base. On ne peut pas l'ajouter dans un instrument du portefeuille");
                            }
                        } catch (FondsInexistant fi) {System.out.println(fi.getMessage());}
                    }
                    // sinon on créé un nouveau instrument dans le portefeuille puis on effectue les mêmes actions
                    else{
                        portefeuilleControleur.getIDInstrument().put(keyUser, new Instrument());
                        System.out.println("Un nouveau instrument a bien été créé dans le portefeuille.");
                        try{
                            if(portefeuilleControleur.searchFunds(amountUser)!=0){
                                Fonds f=portefeuilleControleur.getIDFunds().get(amountUser);
                                portefeuilleControleur.addFundsInInstrument(keyUser, f);
                                System.out.println("Le fonds a bien été ajouté dans l'instrument.");
                            }
                            else if(portefeuilleControleur.searchFunds(amountUser)==0){
                                System.out.println("Le fonds n'existe pas dans le portefeuille de base. On ne peut pas l'ajouter dans un instrument du portefeuille");
                            }
                        } catch (FondsInexistant fi) {fi.getMessage();}
                    }
                } catch (InstrumentInexistant ii) {System.out.println(ii.getMessage());}
                break;
                // l'utilisateur supprime un fonds du portefeuille
            case 3:
                try{
                    // on supprime le fonds puis on vérifie que le fonds a bien été supprimé
                    portefeuilleControleur.deleteFunds(keyUser);
                    if(portefeuilleControleur.searchFunds(keyUser)!=0)
                        System.out.println("Erreur : La suppression n'a pas pu être effectué.");
                    else
                        System.out.println("La vérification a bien été effectué : on a bien supprimé le fonds du portefeuille.");
                } catch(FondsInexistant fi) {fi.getMessage();}
                break;
                // l'utilisateur supprime un instrument du portefeuille
            case 4:
                try{
                    // on supprime l'instrument puis on vérifie que l'instrument a bien été supprimé
                    portefeuilleControleur.deleteInstrument(keyUser);
                    if (portefeuilleControleur.searchInstrument(keyUser)!=null)
                        System.out.println("Erreur : La suppression n'a pas pu être effectué.");
                    else
                        System.out.println("La vérification a bien été effectué: on a bien supprimé l'instrument du portefeuille.");
                }catch (InstrumentInexistant ii){ii.getMessage();}
                break;
                // l'utilisateur trie la liste de fonds d'un instrument par ordre croissant de montant
            case 6:
                try{
                    // on vérifie que l'instrument qu'on souhaite trier existe
                    if(portefeuilleControleur.searchInstrument(keyUser)!=null){
                        portefeuilleControleur.getIDInstrument().get(keyUser).sortByAmount();
                        System.out.print("Voici les fonds triés par montant: ");
                        for(int i=0;i<portefeuilleControleur.searchInstrument(keyUser).size();i++){
                            System.out.print(portefeuilleControleur.searchInstrument(keyUser).get(i).getAmount()+" ");
                        }
                        System.out.println();
                    }
                } catch (InstrumentInexistant ii) {System.out.println(ii.getMessage());}
                break;
                // le développeur se mord les doigts car il a codé comme un cochon
            default:
                System.out.println("Erreur contrôleur ! Danger.");
                break;
        }
    }
    
    /**
     * Getter qui servira à récupérer le portefeuille qu'on est en train d'utiliser pour la vue.
     * @return le portefeuille qu'on est actuellement en train d'utiliser.
     */
    public Portefeuille getControleurPortefeuille(){
        return portefeuilleControleur;
    }
}
