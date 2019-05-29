package td1;

public interface MySerializable {

    void writeToBuff( SerializerBuffer ms );

    void readFromBuff( SerializerBuffer ms );

}
