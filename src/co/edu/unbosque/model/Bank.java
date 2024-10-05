package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.BankDAO;
import co.edu.unbosque.model.persistence.MapHandler;
import co.edu.unbosque.model.persistence.UsuarioDTO;

public class Bank {
	private ArrayList<Usuario> clientes;
	private BankDAO bankDAO;

	public Bank() {
		clientes = new ArrayList<Usuario>();
		bankDAO = new BankDAO();
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

//	public Usuario find(UsuarioDTO userDTO) {
//		Usuario user = MapHandler.convertirUsuarioDTOtoUsuario(userDTO);
//		return bankDAO.find(user.getNombreUsuario());
//	}

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
}