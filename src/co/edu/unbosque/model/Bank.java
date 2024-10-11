package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.BankDAO;
import co.edu.unbosque.model.persistence.MapHandler;
import co.edu.unbosque.model.persistence.UsuarioDTO;

public class Bank {
	private ArrayList<Usuario> clientes;
	private BankDAO bankDAO;
	private Usuario usuario;

	public Bank() {
		clientes = new ArrayList<Usuario>();
		bankDAO = new BankDAO();
		usuario = null;
	}

	public boolean adicionarPareja(String nombrePareja, double cupoPareja) {
		Pareja pareja = new Pareja(nombrePareja, cupoPareja);

		Usuario usuarioCopia = usuario;
		usuario.getParejas().add(pareja);
		System.out.println(bankDAO.update(usuarioCopia, usuario));
		return bankDAO.update(usuarioCopia, usuario);
	}

	public Pareja buscarPareja(String accion, String nombrePareja, double cupoPareja) {
		Pareja parejaEncontrada = null;
		if (!usuario.getParejas().isEmpty()) {
			switch (accion) {
			case "actualizar":
				for (Pareja parejita : usuario.getParejas()) {
					if (parejita.getAlias().equals(nombrePareja)) {
						parejaEncontrada = parejita;
					}
				}
				break;
			case "borrar":
				for (Pareja parejita : usuario.getParejas()) {
					if (parejita.getAlias().equals(nombrePareja) && parejita.getCupoAsignado() == cupoPareja) {
						parejaEncontrada = parejita;
					}
				}
				break;
			default:
				break;
			}

		}
		return parejaEncontrada;
	}

	public boolean actualizarPareja(String nombrePareja, double cupoPareja) {
		Pareja x = buscarPareja("actualizar", nombrePareja, cupoPareja);
		if (x != null) {
			Pareja parejaActualizada = new Pareja(nombrePareja, cupoPareja);
			Usuario usuarioCopia = usuario;

			usuario.getParejas().remove(x);
			usuario.getParejas().add(parejaActualizada);
			System.out.println(bankDAO.update(usuarioCopia, usuario));
			return bankDAO.update(usuarioCopia, usuario);
		}
		System.out.println("No funca paaaa");
		return false;
	}

	public boolean borrarPareja(String nombrePareja, double cupoPareja) {
		Pareja x = buscarPareja("borrar", nombrePareja, cupoPareja);
		if (x != null) {
			Usuario usuarioCopia = usuario;
			usuario.getParejas().remove(x);

			System.out.println(bankDAO.update(usuarioCopia, usuario));
			return bankDAO.update(usuarioCopia, usuario);
		}
		System.out.println("No funca paaaa");
		return false;
	}

	public boolean adicionarUsuario(UsuarioDTO userDTO) {
		Usuario nuevoUsuario = MapHandler.convertirUsuarioDTOtoUsuario(userDTO);
		Usuario usuarioExistente = bankDAO.find(nuevoUsuario.getNombreUsuario());
		if (usuarioExistente != null) {
			System.out.println("Ya existe un cliente con ese nombre");
			return false;
		}
		return bankDAO.add(nuevoUsuario);
	}

	public boolean eliminarUsuario(UsuarioDTO userDTO) {
		Usuario user = MapHandler.convertirUsuarioDTOtoUsuario(userDTO);
		return bankDAO.delete(user);
	}

	public boolean actualizarUsuario(UsuarioDTO user1DTO, UsuarioDTO user2DTO) {
		Usuario user1 = MapHandler.convertirUsuarioDTOtoUsuario(user1DTO);
		Usuario user2 = MapHandler.convertirUsuarioDTOtoUsuario(user2DTO);
		return bankDAO.update(user1, user2);
	}

	public String obtenerUsuarios() {
		return bankDAO.getAll();
	}

	public void actualizarBD() {
		bankDAO.actualizarBD();
	}

	public Usuario find(String name) {
		return bankDAO.find(name);
	}

	public ArrayList<Usuario> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Usuario> clientes) {
		this.clientes = clientes;
	}

	public BankDAO getBankDAO() {
		return bankDAO;
	}

	public void setBankDAO(BankDAO bankDAO) {
		this.bankDAO = bankDAO;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}