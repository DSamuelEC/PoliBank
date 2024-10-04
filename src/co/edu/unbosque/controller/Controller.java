package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.AclEntry;
import java.util.Set;

import co.edu.unbosque.model.Bank;
import co.edu.unbosque.model.persistence.ParejaDTO;
import co.edu.unbosque.model.persistence.UsuarioDTO;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {
	private VentanaPrincipal ventanaP;
	private Bank bank;

	public Controller() {
		ventanaP = new VentanaPrincipal();
		asignarOyentes();
	}

	private void asignarOyentes() {
		ventanaP.getpLogin().getBtnCreateUser().addActionListener(e -> {
			ventanaP.getpLogin().setVisible(false);
			ventanaP.getpCrearUsuario().setVisible(true);

		});
		ventanaP.getpLogin().getBtnSubmit().addActionListener(e -> {

			ventanaP.getpLogin().setVisible(false);
			ventanaP.getpHomeUser().setVisible(true);

		});
		ventanaP.getpCrearUsuario().getBtnCreateUser().addActionListener(e -> {
			ventanaP.getpCrearUsuario().setVisible(false);
			ventanaP.getpLogin().setVisible(true);
			capturarDatosLogin();
		});
		ventanaP.getpFunciones().getBtnSubmit().addActionListener(e -> {

		});
		ventanaP.getpHomeUser().getBtnActualizarPareja().addActionListener(e -> {
			ventanaP.getpHomeUser().setVisible(false);
			ventanaP.getpFunciones().setVisible(true);
		});
		ventanaP.getpHomeUser().getBtnEliminarPareja().addActionListener(e -> {
			ventanaP.getpHomeUser().setVisible(false);
			ventanaP.getpFunciones().setVisible(true);
		});
		ventanaP.getpLogin().getBtnSubmit().addActionListener(e -> {

			ventanaP.getpLogin().setVisible(false);
			ventanaP.getpHomeUser().setVisible(true);

		});
		ventanaP.getpFunciones().getBtnSubmit().addActionListener(e -> {

			ventanaP.getpFunciones().setVisible(false);
			ventanaP.getpHomeUser().setVisible(true);

		});
		ventanaP.getpHomeUser().getBtnSalir().addActionListener(e -> {

			ventanaP.getpHomeUser().setVisible(false);
			ventanaP.getpLogin().setVisible(true);

		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		System.out.println(comando);
	}

	public void run() {
		bank = new Bank();
		bank.actualizarBD();
	}

	public void capturarDatosLogin() {
		String nombre = ventanaP.getpCrearUsuario().getTxtUserName().getText();
		double cupoTotal = Double.parseDouble(ventanaP.getpCrearUsuario().getTxtSaldoTC().getText());
		UsuarioDTO userDTO = new UsuarioDTO();
		
		userDTO.setNombreUsuario(nombre);
		userDTO.setCupoTotal(cupoTotal);
		bank.adicionarUsuario(userDTO);
		System.out.println(userDTO);
	}
}
