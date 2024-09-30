package co.edu.unbosque.model.persistence;

import java.io.Serializable;
//YA NO SE USA
public class TcDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private double cupoTotal, cupoDisponible;

	public double getCupoTotal() {
		return cupoTotal;
	}

	public void setCupoTotal(double cupoTotal) {
		this.cupoTotal = cupoTotal;
	}

	public double getCupoDisponible() {
		return cupoDisponible;
	}

	public void setCupoDisponible(double cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}