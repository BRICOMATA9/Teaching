/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delgay_melloul;

/**
 *
 * @author julien
 */
public class FondsExistant extends Exception {

    /**
     * Creates a new instance of <code>FondsExistant</code> without detail
     * message.
     */
    public FondsExistant() {
        System.out.println("La cle du fond a ajouter existe deja dans la HashMap");
    }

    /**
     * Constructs an instance of <code>FondsExistant</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public FondsExistant(String msg) {
        super(msg);
    }
}
