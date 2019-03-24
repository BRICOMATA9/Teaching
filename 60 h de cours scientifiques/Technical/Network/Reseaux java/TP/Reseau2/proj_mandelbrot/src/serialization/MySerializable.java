package serialization;

public interface MySerializable {

    void serialize( SerializerBuffer ms );

    void deserialize( SerializerBuffer ms );

}
