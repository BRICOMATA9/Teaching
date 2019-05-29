package serialization;

/**
 * Interface personnalisé pour nos sérialisations Tout objet devant etre
 * serialisé implemente cette interface.
 *
 */
public interface MySerializable {

    void serialize( SerializerBuffer ms );

    void deserialize( SerializerBuffer ms );

}
