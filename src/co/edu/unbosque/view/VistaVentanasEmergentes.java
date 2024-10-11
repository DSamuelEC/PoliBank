package co.edu.unbosque.view;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class VistaVentanasEmergentes {

	public VistaVentanasEmergentes() {

	}

	public void mostrarInformacion(String mensaje, int n) {
		if (n == 1) {

			JOptionPane.showMessageDialog(null, mensaje, "INFORMACION", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, mensaje, "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public double leerDatoReal(String mensaje) {
		double dato = 0;
		boolean salida = true;
		do {
			try {
				String aux = JOptionPane.showInputDialog(mensaje);
				dato = Double.parseDouble(aux);
				salida = true;
			} catch (NumberFormatException e) {
				mostrarInformacion("ERROR: ingreso de valor no valido", 1);
				salida = false;
			} catch (NullPointerException e) {
				mostrarInformacion("adios", 1);
				// o simplemente uso:
				System.exit(0);
				// o ambos
			}
		} while (!salida);

		return dato;
	}
}
