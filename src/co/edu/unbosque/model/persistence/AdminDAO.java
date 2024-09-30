package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Pareja;

public class AdminDAO implements InterfaceDAO<Pareja>{

	private ArrayList<Pareja> datos;
	private Archivo archivo;
	
	public AdminDAO() {
		datos = new ArrayList<Pareja>();
		archivo = new Archivo();
	}
	
	public void actualizarBD() {
		datos = archivo.leerArchivo();
	}
	
	@Override
	public String getAll() {
		String rta = "";
		datos = archivo.leerArchivo();
		if(!datos.isEmpty()) {
			for(Pareja x : datos) {
				rta += x + "\n";
			}
		}
		return rta;
	}

	@Override
	public boolean add(Pareja x) {
		if(find(x) == null) {
			datos.add(x);
			archivo.escribirArchivo(datos);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Pareja x) {
		Pareja y = find(x);
		if(y != null) {
			try {
				datos.remove(y);
				archivo.getUbicacionArchivo().delete();
				archivo.getUbicacionArchivo().createNewFile();
				archivo.escribirArchivo(datos);
				return true;
			}catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean update(Pareja x, Pareja y) {
		Pareja e = find(x);
		if(e != null) {
			datos.remove(e);
			e.setAlias(y.getAlias());
			e.setCupoAsignado(y.getCupoAsignado());
			datos.add(e);
			return true;
		}
		return false;
	}

	@Override
	public Pareja find(Pareja x) {
		Pareja encontrado = null;
		if(!datos.isEmpty()) {
			for(Pareja y : datos) {
				if( y.getAlias().equals(x.getAlias())) {
					encontrado = y;
				}
			}
		}
		
		return encontrado;
	}

}
