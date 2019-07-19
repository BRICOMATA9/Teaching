package Interface;

@FunctionalInterface
public interface Function<T>{
	public Boolean apply(T t) throws Exception;
}
