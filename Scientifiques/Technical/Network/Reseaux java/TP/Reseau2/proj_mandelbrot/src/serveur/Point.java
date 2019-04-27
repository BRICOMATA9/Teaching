package serveur;

import serialization.Creator;
import serialization.MySerializable;
import serialization.SerializerBuffer;

public class Point implements MySerializable {
    public static final Creator<Point> CREATOR = Point::new;
    private double                     abscisse;
    private double                     ordonne;

    public Point() {

    }

    public Point( double x, double y ) {
        this.abscisse = x;
        this.ordonne = y;
    }

    /**
     * @return the abscisse
     */
    public double getAbscisse() {
        return abscisse;
    }

    /**
     * @param abscisse
     *            the abscisse to set
     */
    public void setAbscisse( double abscisse ) {
        this.abscisse = abscisse;
    }

    /**
     * @return the ordonne
     */
    public double getOrdonne() {
        return ordonne;
    }

    /**
     * @param ordonne
     *            the ordonne to set
     */
    public void setOrdonne( double ordonne ) {
        this.ordonne = ordonne;
    }

    public String toString() {
        return "(" + abscisse + "," + ordonne + ")";
    }

    @Override
    public void serialize( SerializerBuffer ms ) {
        ms.writeDouble( abscisse );
        ms.writeDouble( ordonne );
    }

    @Override
    public void deserialize( SerializerBuffer ms ) {
        this.abscisse = ms.readDouble();
        this.ordonne = ms.readDouble();
    }
}
