package DAO;

import java.util.stream.Stream;

public interface IDAO <T>{
	
	public Stream<?> getId();
	public Stream<T> getAll();
	public <V> T getById(V t) throws Exception;
	public void ajouter(T t) throws Exception;
	public Boolean supprimer(T t) throws Exception;
	public Boolean modifier(T t) throws Exception;

}
