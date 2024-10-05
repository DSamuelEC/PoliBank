package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class BankDAO implements InterfaceDAO<Usuario> {

	private ArrayList<Usuario> datos;
	private Archivo archivo;

	public BankDAO() {
		this.datos = new ArrayList<Usuario>();
		this.archivo = new Archivo();
	}

	public void actualizarBD() {
		ArrayList<Usuario> usuariosExistentes = archivo.leerArchivo();
		if (usuariosExistentes != null) {
			datos = usuariosExistentes;
		}
	}

	@Override
	public String getAll() {
		String rta = "";
		datos = archivo.leerArchivo();
		if (!datos.isEmpty()) {
			for (Usuario x : datos) {
				rta += x + "\n";
			}
		}
		return rta;
	}

	@Override
	public boolean add(Usuario x) {
		if (find(x.getNombreUsuario()) == null) {
			datos.add(x);
			archivo.escribirArchivo(datos);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Usuario x) {
		Usuario y = find(x.getNombreUsuario());
		if (y != null) {
			try {
				datos.remove(y);
				archivo.getUbicacionArchivo().delete();
				archivo.getUbicacionArchivo().createNewFile();
				archivo.escribirArchivo(datos);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean update(Usuario x, Usuario y) {
		Usuario e = find(x.getNombreUsuario());
		if (e != null) {
			datos.remove(e);
			e.setParejas(y.getParejas());
			datos.add(e);
			return true;
		}
		return false;
	}

	/*
	 * se usa para el login, este metodo busca si ya existe un usuario con solo el
	 * nombre lo va a devolver para que ingrese a su cuenta
	 */

	@Override
	public Usuario find(String name) {
		Usuario encontrado = null;
		if (!datos.isEmpty()) {
			for (Usuario usuario : datos) {
				if (usuario.getNombreUsuario().equals(name)) {
					encontrado = usuario;
				}
			}
		}
		return encontrado;
	}
}
