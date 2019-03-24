package utilities;

import serialization.Creator;
import serialization.MySerializable;
import serialization.SerializerBuffer;

public class Point implements MySerializable {
    public static final Creator<Point> CREATOR = Point::new;
    private double                     abscisse;
    private double                     ordonne;

    public Point() {
    }

    public Point( double abs, double ord ) {
        this.abscisse = abs;
        this.ordonne = ord;
    }

    public double getAbscisse() {
        return this.abscisse;
    }

    public void setAbscisse( double abs ) {
        this.abscisse = abs;
    }

    public double getOrdonne() {
        return this.ordonne;
    }

    public void setOrdonne( double ord ) {
        this.ordonne = ord;
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
