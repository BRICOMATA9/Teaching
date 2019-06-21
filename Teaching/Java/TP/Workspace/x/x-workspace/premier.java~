

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

    public class premier extends Applet {
    private AudioClip sound;
    boolean isStandalone = false;
    Button bouton_valider = new Button();
    Label label1 = new Label();
    TextField ligne_de_saisie = new TextField();
    Label label_signature_1 = new Label();
    Label label_signature_2 = new Label();
    Label label_resultat = new Label();
    /**Get a parameter value*/
    public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
    (getParameter(key) != null ? getParameter(key) : def);
    }

/*************************************************************************************************/

    /**Construct the applet*/
    public premier() {
    }

/*************************************************************************************************/

    /**Initialize the applet*/
    public void init() {
    try {
    jbInit();
    }
    catch(Exception e) {
    e.printStackTrace();
    }
    }

/*************************************************************************************************/

    /**Component initialization*/
    private void jbInit() throws Exception {
    bouton_valider.setLabel("Tester le nombre");
    bouton_valider.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(ActionEvent e) {
    bouton_valider_actionPerformed(e);
    }
    });
    label1.setText("Entrer un nombre entier à 7 chiffres maximum :");
    ligne_de_saisie.setText("Entrez un nombre ici");
    label_signature_1.setText("Applet Java réalisée par Jean-Christophe MICHEL");
    label_signature_2.setText("http://www.gecif.net");
    label_resultat.setAlignment(1);
    label_resultat.setFont(new java.awt.Font("Dialog", 0, 18));
    label_resultat.setForeground(Color.red);
    label_resultat.setText("Test de primalité d\'un nombre");
    this.add(label1, null);
    this.add(ligne_de_saisie, null);
    this.add(bouton_valider, null);
    this.add(label_resultat, null);
    this.add(label_signature_1, null);
    this.add(label_signature_2, null);
    }

/*************************************************************************************************/

    /**Get Applet information*/
    public String getAppletInfo() {
    return "Applet Information";
    }

/*************************************************************************************************/

    /**Get parameter info*/
    public String[][] getParameterInfo() {
    return null;
    }

/*************************************************************************************************/

    void bouton_valider_actionPerformed(ActionEvent e) {
    String s;
    int a=3,nbr_original,fin=0;
    float r;
    Float obj;
    double d;

    s=ligne_de_saisie.getText();
    obj=Float.valueOf(s);
    nbr_original=obj.intValue();
    d=obj.intValue();

    if (d%2==0) { fin=2; }
    if (d<=0) { fin=2; }
    if (d==1) { fin=2; }
    if (d==2) { fin=1; }
    while (fin==0)
    {
    if (a>=Math.sqrt(d)+1)
    {
    fin=1;
    }
    if ((fin!=1) && ((d % a)==0)) {
    fin=2;
    }

    a=a+2;
    }

    s=String.valueOf(nbr_original);
    if (fin==1) {
    label_resultat.setText(s+" est premier");

    try {
    sound = getAudioClip(getCodeBase(), "premier_oui.au");
    }
    catch(Exception toto) {
    }
    sound.play();

    }
    if (fin==2) {
    label_resultat.setText(s+" n'est pas premier");
    try {
    sound = getAudioClip(getCodeBase(), "premier_non.au");
    }
    catch(Exception toto) {
    }
    sound.play();
    }
    }
    }


/*************************************************************************************************/
/*                                       Fin du programme                                        */
/*************************************************************************************************/

