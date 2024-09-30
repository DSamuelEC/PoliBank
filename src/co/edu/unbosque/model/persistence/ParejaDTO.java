package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;

public class ParejaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombrePareja;
	private double cupoAsignado;

	public String getNombrePareja() {
		return nombrePareja;
	}

	public void setNombrePareja(String nombrePareja) {
		this.nombrePareja = nombrePareja;
	}

	public double getCupoAsignado() {
		return cupoAsignado;
	}

	public void setCupoAsignado(double cupoAsignado) {
		this.cupoAsignado = cupoAsignado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}