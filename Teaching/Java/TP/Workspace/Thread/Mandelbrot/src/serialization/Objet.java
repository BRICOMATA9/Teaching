package serialization;;

import serialization.Creator;
import serialization.MySerializable;
import serialization.SerializerBuffer;

public class Objet implements MySerializable {

    public static final Creator<Objet> CREATOR = Objet::new;
    private int i;

    public Objet() {
    }

    public Objet(int i ) {
        this.i = i;
    }

    public int getI() {
        return this.i;
    }

    public void setI( int i) {
        this.i = i;
    }

    @Override
    public void serialize( SerializerBuffer ms ) {
        ms.writeInt(i);
    }

    @Override
    public void deserialize( SerializerBuffer ms ) {
        this.i = ms.readInt();
    }

}
