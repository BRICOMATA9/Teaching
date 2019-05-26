package serialization;

/**
 * Interface fonctionnelle pour initialisé un objet (à déserialiser)
 * 
 * @param <T>:
 *            Type de l'objet à déserialiser
 */
public interface Creator<T extends MySerializable> {

    public abstract T init();

}
