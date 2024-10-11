package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import co.edu.unbosque.model.Bank;
import co.edu.unbosque.model.Pareja;
import co.edu.unbosque.model.persistence.ParejaDTO;
import co.edu.unbosque.model.persistence.UsuarioDTO;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {
	private VentanaPrincipal ventanaP;
	private Bank bank;
	private String cambio;

	public Controller() {
		ventanaP = new VentanaPrincipal();
		bank = new Bank();
		cambio = "";
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
			crearPareja();
		});
		ventanaP.getpHomeUser().getpBotones().getBtnActualizarPareja().addActionListener(e -> {
			generarCambioVentana("actualizar");
		});
		ventanaP.getpHomeUser().getpBotones().getBtnEliminarPareja().addActionListener(e -> {
			generarCambioVentana("eliminar");
		});
		ventanaP.getpHomeUser().getpBotones().getBtnVerTodo().addActionListener(e -> {
			refresh();
		});
		ventanaP.getpHomeUser().getpBotones().getBtnSalir().addActionListener(e -> {
			cerrarSesion();
		});
		ventanaP.getpFunciones().getBtnSubmit().addActionListener(e -> {
			cambiosPareja(cambio);
		});
		ventanaP.getpFunciones().getBtnAtras().addActionListener(e -> {
			atras();
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		System.out.println(comando);
	}

	public void run() {
		bank.actualizarBD();
	}
	
	public void cerrarSesion() {
		ventanaP.getpHomeUser().setVisible(false);
		ventanaP.getpLogin().setVisible(true);
		bank.setUsuario(null);
		run();
	}

	public void atras() {
		ventanaP.getpFunciones().setVisible(false);
		ventanaP.getpHomeUser().setVisible(true);
	}

	public void refresh() {
		ventanaP.getpHomeUser().getpTableParejas().limpiarArea();
		ventanaP.getpHomeUser().getpTableParejas()
				.cargarParejas(convertirParejasListtoParejasArray(bank.getUsuario().getParejas()));
	}

	public void generarCambioVentana(String comando) {
		ventanaP.getpHomeUser().setVisible(false);
		ventanaP.getpFunciones().setVisible(true);
		cambio = comando;
	}

	public void crearPareja() {
		String nombre = ventanaP.getpHomeUser().getpAgregarParejasUsuario().getTxtAliasPareja().getText();
		double cupoTotal = Double
				.parseDouble(ventanaP.getpHomeUser().getpAgregarParejasUsuario().getTxtCupoPareja().getText());
		bank.adicionarPareja(nombre, cupoTotal);
		ventanaP.getpHomeUser().getpTableParejas().getTxaParejas().append("ACTUALIZACION PAREJAS" + "\n");
		ventanaP.getpHomeUser().getpTableParejas()
				.cargarParejas(convertirParejasListtoParejasArray(bank.getUsuario().getParejas()));
	}

	public void cambiosPareja(String cambio) {
		String nombre = ventanaP.getpFunciones().getTxtLoverName().getText();
		double cupoTotal = Double.parseDouble(ventanaP.getpFunciones().getTxtSaldoTC().getText());

		switch (cambio) {
		case "actualizar":
			bank.actualizarPareja(nombre, cupoTotal);
			ventanaP.getpFunciones().setVisible(false);
			ventanaP.getpHomeUser().setVisible(true);

			ventanaP.getpHomeUser().getpTableParejas().getTxaParejas().append("ACTUALIZACION PAREJAS" + "\n");
			ventanaP.getpHomeUser().getpTableParejas()
					.cargarParejas(convertirParejasListtoParejasArray(bank.getUsuario().getParejas()));
		
			
			ventanaP.getpFunciones().setTxtSaldoTC(null);
			break;
		case "eliminar":
			bank.borrarPareja(nombre, cupoTotal);
			ventanaP.getpFunciones().setVisible(false);
			ventanaP.getpHomeUser().setVisible(true);

			ventanaP.getpHomeUser().getpTableParejas().getTxaParejas().append("ACTUALIZACION PAREJAS" + "\n");
			ventanaP.getpHomeUser().getpTableParejas()
					.cargarParejas(convertirParejasListtoParejasArray(bank.getUsuario().getParejas()));
			break;
		default:
			break;
		}

	}

	public void submitLogin() {
		String nombre = ventanaP.getpLogin().getTxtUserName().getText();
		bank.setUsuario(bank.find(nombre));
		if (bank.getUsuario() != null) {

			ventanaP.getpLogin().setVisible(false);
			ventanaP.getpHomeUser().setVisible(true);

			ventanaP.getpHomeUser().getpDatosUsuario().getLblUserName().setText(bank.getUsuario().getNombreUsuario());
			ventanaP.getpHomeUser().getpDatosUsuario().getLblCupoUsuario()
					.setText(String.valueOf("$" + bank.getUsuario().getTarjetaCredito().getCupoTotal()));

			ventanaP.getpHomeUser().getpTableParejas()
					.cargarParejas(convertirParejasListtoParejasArray(bank.getUsuario().getParejas()));
		} else {
			System.out.println("No funca pa");
		}
	}

	public String[] convertirParejasListtoParejasArray(ArrayList<Pareja> parejasList) {
		String[] parejasTexto = new String[parejasList.size()];
		for (int i = 0; i < parejasList.size(); i++) {
			parejasTexto[i] = parejasList.get(i).toString();
		}
		return parejasTexto;
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
