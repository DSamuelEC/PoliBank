package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pareja;
import co.edu.unbosque.model.Usuario;

public class MapHandler {

	public static ArrayList<Pareja> convertirParejaDTOtoPareja(ArrayList<ParejaDTO> parejasDTOs) {
		Pareja x;
		ArrayList<Pareja> parejas = new ArrayList<Pareja>();

		for (ParejaDTO pareDTO : parejasDTOs) {
			x = new Pareja(pareDTO.getNombrePareja(), pareDTO.getCupoAsignado());
			parejas.add(x);
		}
		return parejas;
	}

	public static ArrayList<ParejaDTO> convertirParejastoParejasDTO(ArrayList<Pareja> parejas) {
		ParejaDTO x;
		ArrayList<ParejaDTO> parejasDTOs = new ArrayList<ParejaDTO>();

		for (Pareja pare : parejas) {
			x = new ParejaDTO();
			x.setNombrePareja(pare.getAlias());
			x.setCupoAsignado(pare.getCupoAsignado());
			parejasDTOs.add(x);
		}
		return parejasDTOs;
	}

	public static Usuario convertirUsuarioDTOtoUsuario(UsuarioDTO uDTO) {
		Usuario x = new Usuario(uDTO.getNombreUsuario(), uDTO.getCupoTotal());
		x.setParejas(convertirParejaDTOtoPareja(uDTO.getParejas()));
		return x;
	}

	public static UsuarioDTO convertirUsuariotoUsarioDTO(Usuario user) {
		UsuarioDTO x = new UsuarioDTO(); // es el contructor por defecto de una clase que NO tiene constructor, por
											// transportar informacion no se crea el constructor

		x.setNombreUsuario(user.getNombreUsuario());
		x.setCupoTotal(user.getTarjetaCredito().getCupoTotal());
		x.setParejas(convertirParejastoParejasDTO(user.getParejas()));
		return x;
	}

	public static ArrayList<Usuario> convertirAdminDTOtoAdmin(ArrayList<UsuarioDTO> usersDTO) {
		ArrayList<Usuario> x = new ArrayList<Usuario>();
		for (UsuarioDTO uDTO : usersDTO) {
			Usuario aux = convertirUsuarioDTOtoUsuario(uDTO);
			x.add(aux);
		}
		return x;
	}

	public static ArrayList<UsuarioDTO> convertirAdmintoAdminDTO(ArrayList<Usuario> users) {
		ArrayList<UsuarioDTO> x = new ArrayList<UsuarioDTO>();
		for (Usuario u : users) {
			UsuarioDTO aux = convertirUsuariotoUsarioDTO(u);
			x.add(aux);
		}
		return x;
	}
}
