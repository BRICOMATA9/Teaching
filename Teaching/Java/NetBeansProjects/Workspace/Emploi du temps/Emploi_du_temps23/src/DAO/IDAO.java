package DAO;

import java.util.Date;
import java.util.stream.Stream;

import BDD.Groupe;
import BDD.Salle;
import BDD.TP;

public interface IDAO <T> {
	
	public Stream<?> getId() throws Exception;
	public Stream<T> getAll() throws Exception;
	public <V> T getById(V t) throws Exception;
	public Boolean ajouter(T t) throws Exception;
	public Boolean supprimer(T t) throws Exception;
	public Boolean modifier(T t) throws Exception;
	default public Stream<TP> getAllSeance() throws Exception{return null;}
	default public Stream<Integer> getIdDispo(Date daet, Date heure,Date duree) throws Exception{return null;}
	default public Stream<Integer> getIdNDispo(Date date) throws Exception{return null;}
	default public Stream<Salle> getByType(String type) throws Exception{return null;}
	default public Stream<Salle> getSalleByGroupe(Groupe g) throws Exception{return null;}
}
