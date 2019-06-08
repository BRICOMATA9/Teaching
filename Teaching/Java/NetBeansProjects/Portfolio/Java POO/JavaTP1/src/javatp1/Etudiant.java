
package javatp1;

/**
 *
 * @author armel
 */
public class Etudiant {
    /**
     * @param identtifiant est l'identifiant unique de l'étudiant
     * @param t_notes est le tableau regroupant les notes de l'étudiant
     * @param taille est la taille du tableau de note 
     * @param nomE est le nom  de l'étudiant accessible à tous
     * @param prenomE est le prénom de l'étudiant accessible à tous
     */
    private String identtifiant;
    private float notes[];
    private int taille;
    public String nomE;
    public String prenomE;

    public String getIdenttifiant() {
        return identtifiant;
    }

    public void setIdenttifiant(String identtifiant) {
        this.identtifiant = identtifiant;
    }

    /*public float[] getNotes() {
        return notes;
    }

    public void setNotes(float[] notes) {
        this.notes = notes;
    }*/

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
    
    public void afficheNotes(float[] notes, int taille) {
        for(int i=0; i<taille; i++){
            if(i<taille-1)
                System.out.print(notes[i] + ", ");
            else
                System.out.println(notes[i] + ".");
        }
    }
    
    public Etudiant(){
        this.identtifiant = null;
        this.notes = null;
        this.taille = 0;
        this.nomE = null;
        this.prenomE = null;
    }
    
    public Etudiant(float t_notes[]){
        this.taille = t_notes.length;
        for(int i=0; i<this.taille; i++){
        this.notes[i] = t_notes[i];
        }
    }
    
    public void modifier(String id, float notes[], int taille, String nomE, String prenomE){
    this.identtifiant = id;
    this.taille = taille;
    this.nomE = nomE;
    this.prenomE = prenomE;
    for(int i=0; i<taille; i++){
        this.notes[i] = notes[i];
    }
    }
}
