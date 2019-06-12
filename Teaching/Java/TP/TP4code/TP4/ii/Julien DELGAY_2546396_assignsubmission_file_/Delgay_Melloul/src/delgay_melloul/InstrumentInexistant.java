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
public class InstrumentInexistant extends Exception {

    /**
     * Creates a new instance of <code>InstrumentInexistant</code> without
     * detail message.
     */
    public InstrumentInexistant() {
        System.out.println("Aucun instrument ne correspond a cette cle dans la hashmap");
    }

    /**
     * Constructs an instance of <code>InstrumentInexistant</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InstrumentInexistant(String msg) {
        super(msg);
    }
}
