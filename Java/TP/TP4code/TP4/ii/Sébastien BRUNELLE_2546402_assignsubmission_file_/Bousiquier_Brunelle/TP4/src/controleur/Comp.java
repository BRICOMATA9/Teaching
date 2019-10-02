/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.*;
import modele.*;
/**
 *
 * @author sebas
 */
public abstract class Comp implements Comparable<Fonds>
{
    public abstract boolean equals(Fonds f);
    public abstract int compareTo(Fonds f);
    
}
