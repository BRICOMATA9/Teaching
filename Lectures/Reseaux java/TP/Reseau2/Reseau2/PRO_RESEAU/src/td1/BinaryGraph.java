package td1;

public class BinaryGraph implements MySerializable {
    public static final Creator<BinaryGraph> CREATOR = BinaryGraph::new;
    BinaryGraph                              lhs, rhs;
    int                                      key;

    public BinaryGraph() {

    }

    public BinaryGraph( BinaryGraph lhs, BinaryGraph rhs, int key ) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.key = key;
    }

    public int sum( int k ) {
        if ( k < 0 )
            return 0;
        if ( k == 0 )
            return key;
        int s = key;
        if ( lhs != null )
            s += lhs.sum( k - 1 );
        if ( rhs != null )
            s += rhs.sum( k - 1 );
        return s;
    }

    @Override
    public void writeToBuff( SerializerBuffer ms ) {
        ms.writeMySerializable( lhs );
        ms.writeMySerializable( rhs );
        ms.buffer.putInt( key );

    }

    @Override
    public void readFromBuff( SerializerBuffer ms ) {
        lhs = ms.readMySerializable( CREATOR );
        rhs = ms.readMySerializable( CREATOR );
        key = ms.readInt();
    }

}
