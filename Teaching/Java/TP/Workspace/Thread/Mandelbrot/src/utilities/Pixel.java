package utilities;

import serialization.Creator;
import serialization.MySerializable;
import serialization.SerializerBuffer;

public class Pixel implements MySerializable {
    public static final Creator<Pixel> CREATOR = Pixel::new;
    private int                        abscisse;
    private int                        ordonne;
    private int                        value;

    public Pixel() {
    }

    public Pixel( int x, int y, int value ) {
        this.abscisse = x;
        this.ordonne = y;
        this.value = value;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public void setAbscisse( int abscisse ) {
        this.abscisse = abscisse;
    }

    public int getOrdonne() {
        return ordonne;
    }

    public void setOrdonne( int ordonne ) {
        this.ordonne = ordonne;
    }

    public int getValue() {
        return value;
    }

    public void setValue( int value ) {
        this.value = value;
    }

    public String toString() {
        return "(" + abscisse + "," + ordonne + ", " + value + ")";
    }

    @Override
    public void serialize( SerializerBuffer ms ) {
        ms.writeInt( abscisse );
        ms.writeInt( ordonne );
        ms.writeInt( value );
    }

    @Override
    public void deserialize( SerializerBuffer ms ) {
        this.abscisse = ms.readInt();
        this.ordonne = ms.readInt();
        this.value = ms.readInt();
    }

    @Override
    public boolean equals( Object obj ) {
        boolean val = false;
        try {
            val = ( abscisse == ( (Pixel) obj ).getAbscisse() && ordonne == ( (Pixel) obj ).getOrdonne() );
        } catch ( Exception e ) {
            val = false;
        }
        return val;
    }
}
