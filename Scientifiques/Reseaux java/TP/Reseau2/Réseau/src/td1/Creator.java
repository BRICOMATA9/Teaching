package td1;

public interface Creator<T extends MySerializable> {

    public abstract T init();

}
