import Interface.*;
import java.io.*;
import java.net.*;

public class Main{
		public URL image;
		public Main(){//on sauvegarde le chemin de l'image d'accueil pour qu'elle puisse etre charger, quel que soit l'emplassement du jar
			image = this.getClass().getResource("image.jpg");
			if (image == null){ new Dialogue("Impossible de charger l'image d'accueil"); System.exit(0);}
		}
    public static void main(String args[]){//on donne un nom a notre application   
        	new Windows("Extraction d'information",new Main().image);//et on affiche la fenetre d'accueil
    }
}
