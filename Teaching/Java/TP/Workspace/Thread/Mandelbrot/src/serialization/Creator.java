package serialization;

public interface Creator<T extends MySerializable> {

    public abstract T init();

}
