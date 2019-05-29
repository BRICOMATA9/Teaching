package td1;

public class Test1 implements MySerializable {
    public static final Creator<Test1> CREATOR = Test1::new;
    private int                        i;
    private Test2                      t;
    private String                     s;

    public Test1() {

    }

    public Test1( int i, Test2 t, String s ) {
        this.i = i;
        this.t = t;
        this.s = s;
    }

    @Override
    public void writeToBuff( SerializerBuffer ms ) {
        ms.writeInt( this.i );
        ms.writeMySerializable( t );
        ms.writeString( this.s );

    }

    @Override
    public void readFromBuff( SerializerBuffer ms ) {
        this.i = ms.readInt();
        ms.readMySerializable( CREATOR );
        this.s = ms.readString();
    }

    @Override
    public String toString() {
        return "Test1 [i=" + this.i + this.t + ", s=" + this.s + "]";
    }

    public static void main( String[] args ) {
        Test2 tt = null;
        Test1 t = new Test1( 32, tt, "foo€Test" );
        SerializerBuffer b = new SerializerBuffer( 1024 );
        System.out.println( "Pre :" + t );
        b.writeMySerializable( t );
        b.writeMySerializable( t );
        b.buffer.flip();
        Test1 t2 = new Test1();
        t2 = b.readMySerializable( Test1.CREATOR );
        System.out.println( "Post :" + t2 );
        t2 = b.readMySerializable( Test1.CREATOR );
        System.out.println( "Post :" + t2 );

    }

}
