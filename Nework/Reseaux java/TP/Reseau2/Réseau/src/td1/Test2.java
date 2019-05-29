package td1;

public class Test2 implements MySerializable {
    public static final Creator<Test2> CREATOR = Test2::new;
    private float                      f1;

    private float                      f2;

    public Test2() {

    }

    public Test2( float f1, float f2 ) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public void writeToBuff( SerializerBuffer ms ) {
        ms.writeFloat( this.f1 );
        ms.writeFloat( this.f2 );

    }

    @Override
    public void readFromBuff( SerializerBuffer ms ) {
        this.f1 = ms.readFloat();
        this.f2 = ms.readFloat();
    }

    @Override
    public String toString() {
        return " ,Test2 [F1=" + this.f1 + ", F2=" + this.f2 + "]";
    }

}
