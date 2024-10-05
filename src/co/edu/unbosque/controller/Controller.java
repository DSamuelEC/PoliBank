package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
			loginCreateBtn();
		});
		ventanaP.getpLogin().getBtnSubmit().addActionListener(e -> {
			ventanaP.getpLogin().setVisible(false);
			ventanaP.getpHomeUser().setVisible(true);

		});
		ventanaP.getpCrearUsuario().getBtnCreateUser().addActionListener(e -> {
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
		System.out.println(bank.getBankDAO());
	}

	public void loginCreateBtn() {
		ventanaP.getpLogin().setVisible(false);
		ventanaP.getpCrearUsuario().setVisible(true);
	}

	public void capturarDatosLogin() {
		String nombre = ventanaP.getpCrearUsuario().getTxtUserName().getText();
		double cupoTotal = Double.parseDouble(ventanaP.getpCrearUsuario().getTxtSaldoTC().getText());
		
		String nombrePareja = ventanaP.getpCrearUsuario().getTxtParejaNombre().getText();
		double cupoPareja = Double.parseDouble(ventanaP.getpCrearUsuario().getTxtParejaCupo().getText());
		
		UsuarioDTO userDTO = new UsuarioDTO();
		ParejaDTO parejaDTO = new ParejaDTO();
		ArrayList<ParejaDTO> parejas = new ArrayList<ParejaDTO>();
		
		parejaDTO.setNombrePareja(nombrePareja);
		parejaDTO.setCupoAsignado(cupoPareja);
		parejas.add(parejaDTO);
		
		userDTO.setNombreUsuario(nombre);
		userDTO.setCupoTotal(cupoTotal);
		userDTO.setParejas(parejas);
		
		
		if(bank.adicionarUsuario(userDTO)) {
			System.out.println("se creo");
		} else {
			System.out.println("no se creo");
		}

		ventanaP.getpCrearUsuario().setVisible(false);
		ventanaP.getpLogin().setVisible(true);

		System.out.println(userDTO);
	}
}
