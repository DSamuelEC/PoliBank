package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import co.edu.unbosque.model.Bank;
import co.edu.unbosque.model.Usuario;
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
			submitLogin();
		});
		ventanaP.getpCrearUsuario().getBtnCreateUser().addActionListener(e -> {
			capturarDatosLogin();
		});
		ventanaP.getpHomeUser().getpAgregarParejasUsuario().getBtnAgregarPareja().addActionListener(e -> {
			ventanaP.getpHomeUser().setVisible(false);
			ventanaP.getpFunciones().setVisible(true);
		});
		ventanaP.getpHomeUser().getpBotones().getBtnActualizarPareja().addActionListener(e -> {
			ventanaP.getpHomeUser().setVisible(false);
			ventanaP.getpFunciones().setVisible(true);
		});
		ventanaP.getpHomeUser().getpBotones().getBtnEliminarPareja().addActionListener(e -> {
			ventanaP.getpHomeUser().setVisible(false);
			ventanaP.getpFunciones().setVisible(true);
		});
		ventanaP.getpHomeUser().getpBotones().getBtnVerTodo().addActionListener(e -> {
			ventanaP.getpHomeUser().setVisible(false);
			ventanaP.getpFunciones().setVisible(true);
		});
		ventanaP.getpHomeUser().getpBotones().getBtnSalir().addActionListener(e -> {
			ventanaP.getpHomeUser().setVisible(false);
			ventanaP.getpFunciones().setVisible(true);
		});
		ventanaP.getpFunciones().getBtnSubmit().addActionListener(e -> {
			ventanaP.getpFunciones().setVisible(false);
			ventanaP.getpHomeUser().setVisible(true);
		});
		ventanaP.getpFunciones().getBtnSubmit().addActionListener(e -> {

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

	public void submitLogin() {
		String nombre = ventanaP.getpLogin().getTxtUserName().getText();
		if (bank.find(nombre) != null) {
			Usuario usuario = bank.find(nombre);

			ventanaP.getpLogin().setVisible(false);
			ventanaP.getpHomeUser().setVisible(true);
			
			ventanaP.getpHomeUser().getpDatosUsuario().getLblUserName().setText(usuario.getNombreUsuario());
			ventanaP.getpHomeUser().getpDatosUsuario().getLblCupoUsuario()
					.setText(String.valueOf("$" + usuario.getTarjetaCredito().getCupoTotal()));
			
			ventanaP.getpHomeUser().getpTableParejas();
		} else {
			System.out.println("No funca pa");
		}

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

		if (bank.adicionarUsuario(userDTO)) {
			System.out.println("se creo");
		} else {
			System.out.println("no se creo");
		}

		ventanaP.getpCrearUsuario().setVisible(false);
		ventanaP.getpLogin().setVisible(true);

		System.out.println(userDTO);
	}
}
