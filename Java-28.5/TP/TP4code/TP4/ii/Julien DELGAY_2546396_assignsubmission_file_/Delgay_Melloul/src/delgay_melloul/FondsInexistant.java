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
public class FondsInexistant extends Exception {

    /**
     * Creates a new instance of <code>FondsInexistant</code> without detail
     * message.
     */
    public FondsInexistant() {
        System.out.println("Aucun fond n'est associe a cette cle dans la HashMap");
    }

    /**
     * Constructs an instance of <code>FondsInexistant</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public FondsInexistant(String msg) {
        super(msg);
    }
}
