package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class AdminDAO implements InterfaceDAO<Usuario>{

	private ArrayList<Usuario> datos;
	private Archivo archivo;
	
	public AdminDAO() {
		datos = new ArrayList<Usuario>();
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
			for(Usuario x : datos) {
				rta += x + "\n";
			}
		}
		return rta;
	}

	@Override
	public boolean add(Usuario x) {
		if(find(x) == null) {
			datos.add(x);
			archivo.escribirArchivo(datos);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Usuario x) {
		Usuario y = find(x);
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
	public boolean update(Usuario x, Usuario y) {
		Usuario e = find(x);
		if(e != null) {
			datos.remove(e);
			e.setEdad(y.getEdad());
			e.setTipo(y.getTipo());
			datos.add(e);
			return true;
		}
		return false;
	}

	@Override
	public Usuario find(Usuario x) {
		Usuario encontrado = null;
		if(!datos.isEmpty()) {
			for(Usuario y : datos) {
				if( y.getNombre().equals(x.getNombre())) {
					encontrado = y;
				}
			}
		}
		
		return encontrado;
	}

}
