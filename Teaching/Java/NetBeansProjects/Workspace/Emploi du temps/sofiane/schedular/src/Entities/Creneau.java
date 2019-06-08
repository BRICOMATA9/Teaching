/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author hajji
 */
import java.sql.Time;
import java.time.*;
public class Creneau {
    private LocalTime debut;
    private LocalTime fin;

    public Creneau(LocalTime debut, LocalTime Fin) {
        this.debut = debut;
        this.fin = Fin;
    }

    public Creneau() {
    }

    public LocalTime getDebut() {
        return debut;
    }

    public void setDebut(LocalTime debut) {
        this.debut = debut;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime Fin) {
        this.fin = Fin;
    }

    @Override
    public String toString() {
        return debut+"-"+fin;
    }
    
}
