package co.edu.unbosque.model.persistence;

public interface InterfaceDAO <T>{

	String getAll();
	boolean add(T x);
	boolean delete(T x);
	boolean update(T x, T y);
	T find(String name);
}
