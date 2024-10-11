package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface InterfaceDAO <T>{

	ArrayList<T> getAll();
	boolean add(T x);
	boolean delete(T x);
	boolean update(T x, T y);
	T find(String name);
}
