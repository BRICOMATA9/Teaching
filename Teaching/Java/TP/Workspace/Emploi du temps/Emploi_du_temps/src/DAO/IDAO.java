package DAO;

import java.util.stream.Stream;

import BDD.TP;

public interface IDAO <T> {
	
	public Stream<?> getId() throws Exception;
	public Stream<T> getAll() throws Exception;
	public <V> T getById(V t) throws Exception;
	public Boolean ajouter(T t) throws Exception;
	public Boolean supprimer(T t) throws Exception;
	public Boolean modifier(T t) throws Exception;
	default public Stream<TP> getAllSeance() throws Exception{return null;}
}
