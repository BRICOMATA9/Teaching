/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laura
 */
public class ExceptionEmploye extends Exception {
    
    public ExceptionEmploye(Employe e)
    {
        System.out.println(e.getNom()+" ,"+e.getAge()+" ans, recruté en "+e.getDate());
    }
}
