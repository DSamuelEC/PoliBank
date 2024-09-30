package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
	private TcDTO cupo;
	private ArrayList<ParejaDTO> parejas;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public TcDTO getCupo() {
		return cupo;
	}

	public void setCupo(TcDTO cupo) {
		this.cupo = cupo;
	}

	public ArrayList<ParejaDTO> getParejas() {
		return parejas;
	}

	public void setParejas(ArrayList<ParejaDTO> parejas) {
		this.parejas = parejas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}