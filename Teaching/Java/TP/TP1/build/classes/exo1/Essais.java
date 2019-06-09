package exo1;

public class Essais {

    public static void main(String args[]) {

// Identifiez l’erreur 1 et corrigez
        int i = 0;
        for (i = 0; i < 5; i++) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");

// Identifiez l’erreur 2 et corrigez 
//        float a = (float) 3.0;
//        float a1 = 3.0f;
        double a = 3.0;
        double b = 4;
//        float c;
        double c;
        c = Math.sqrt(a * a + b * b);
        System.out.println("c = " + c);

// Identifiez l’erreur 3 et corrigez 
        byte b1 = 42;
        char c1 = 'a';
        short s = 1024;
        int i1 = 50000;
        float f = 5.67f;
        double d = .1234;
        double resultat = (f * b) + (i / c) - (d * s);
        System.out.print((f * b) + " + " + (i / c) + " - " + (d * s));
        System.out.println(" = " + resultat);
        byte b2 = 10;
        int b3 = (int)b2 * (int)b1;
        System.out.println("b3 = " + b3);
    }
    
/**
* Resume du role de la methode.
* Commentaires détailles sur le role de la methode
* @param val la valeur a traiter
* @return la valeur calculée
*/
    public int methode(int val) {
        return 0;
    }

}