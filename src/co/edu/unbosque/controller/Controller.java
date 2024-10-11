package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import co.edu.unbosque.model.Bank;
import co.edu.unbosque.model.Pareja;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.ParejaDTO;
import co.edu.unbosque.model.persistence.UsuarioDTO;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VistaVentanasEmergentes;

public class Controller implements ActionListener {
	private VentanaPrincipal ventanaP;
	private VistaVentanasEmergentes vistaE;
	private Bank bank;
	private String cambio;

	public Controller() {
		ventanaP = new VentanaPrincipal();
		vistaE = new VistaVentanasEmergentes();
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
			capturarDatosCrearUsuario();
		});
		ventanaP.getpCrearUsuario().getBtnAtras().addActionListener(e -> {
			atras("Login");
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
			atras("Home");
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
		ventanaP.getpHomeUser().getpTableParejas().limpiarArea();
		bank.setUsuario(null);
		run();
	}

	public void atras(String ventana) {
		switch (ventana) {
		case "Home":
			ventanaP.getpFunciones().setVisible(false);
			ventanaP.getpHomeUser().setVisible(true);
			break;
		case "Login":
			ventanaP.getpCrearUsuario().setVisible(false);
			ventanaP.getpLogin().setVisible(true);
			break;
		default:
			break;
		}

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
		try {
			String nombre = ventanaP.getpHomeUser().getpAgregarParejasUsuario().getTxtAliasPareja().getText();
			double cupoTotal = Double
					.parseDouble(ventanaP.getpHomeUser().getpAgregarParejasUsuario().getTxtCupoPareja().getText());
			bank.adicionarPareja(nombre, cupoTotal);
			ventanaP.getpHomeUser().getpTableParejas().getTxaParejas().append("ACTUALIZACION PAREJAS" + "\n");
			ventanaP.getpHomeUser().getpTableParejas()
					.cargarParejas(convertirParejasListtoParejasArray(bank.getUsuario().getParejas()));
			vistaE.mostrarInformacion("Pareja creada correctamente", 0);
		} catch (NumberFormatException e) {
			vistaE.mostrarInformacion("ERROR: ingreso de cupo no valido", 1);
		}
	}

	public void cambiosPareja(String cambio) {
//		String nombre = ventanaP.getpFunciones().getTxtLoverName().getText();
//		double cupoTotal = Double.parseDouble(ventanaP.getpFunciones().getTxtSaldoTC().getText());

		switch (cambio) {
		case "actualizar":
			try {
				String nombre = ventanaP.getpFunciones().getTxtLoverName().getText();
				double cupoTotal = Double.parseDouble(ventanaP.getpFunciones().getTxtSaldoTC().getText());
				if (bank.actualizarPareja(nombre, cupoTotal)) {
					ventanaP.getpFunciones().setVisible(false);
					ventanaP.getpHomeUser().setVisible(true);

					ventanaP.getpHomeUser().getpTableParejas().getTxaParejas().append("ACTUALIZACION PAREJAS" + "\n");
					ventanaP.getpHomeUser().getpTableParejas()
							.cargarParejas(convertirParejasListtoParejasArray(bank.getUsuario().getParejas()));
					vistaE.mostrarInformacion("Pareja actualizada correctamente", 0);
				} else {
					vistaE.mostrarInformacion("ERROR: No se pudo actualizar", 1);
				}
			} catch (NumberFormatException e) {
				vistaE.mostrarInformacion("ERROR: ingreso de cupo no valido", 1);
			}
			break;
		case "eliminar":
			try {
				String nombre = ventanaP.getpFunciones().getTxtLoverName().getText();
				double cupoTotal = Double.parseDouble(ventanaP.getpFunciones().getTxtSaldoTC().getText());
				if (bank.borrarPareja(nombre, cupoTotal)) {
					ventanaP.getpFunciones().setVisible(false);
					ventanaP.getpHomeUser().setVisible(true);

					ventanaP.getpHomeUser().getpTableParejas().getTxaParejas().append("ACTUALIZACION PAREJAS" + "\n");
					ventanaP.getpHomeUser().getpTableParejas()
							.cargarParejas(convertirParejasListtoParejasArray(bank.getUsuario().getParejas()));
					vistaE.mostrarInformacion("Pareja eliminada correctamente", 0);
				} else {
					vistaE.mostrarInformacion("ERROR: No se pudo eliminar", 1);
				}
			} catch (NumberFormatException e) {
				vistaE.mostrarInformacion("ERROR: ingreso de cupo no valido", 1);
			}
			break;
		default:
			break;
		}

	}

	public void submitLogin() {
		String nombre = ventanaP.getpLogin().getTxtUserName().getText();
		if (nombre.equals("ADMIN")) {
			vistaE.mostrarInformacion("Ingreso exitoso ADMIN", 0);
			ventanaP.getpLogin().setVisible(false);
			ventanaP.getpHomeAdmin().setVisible(true);
			System.out.println(bank.getClientes().toString());
			ventanaP.getpHomeAdmin().getpUsuariosAdmin()
					.cargarUsuarios(convertirUsuariosListtoUsuariosArray(bank.getClientes()));
		} else {
			bank.setUsuario(bank.find(nombre));
			if (bank.getUsuario() != null) {
				vistaE.mostrarInformacion("Ingreso exitoso", 0);
				ventanaP.getpLogin().setVisible(false);
				ventanaP.getpHomeUser().setVisible(true);

				ventanaP.getpHomeUser().getpDatosUsuario().getLblUserName()
						.setText(bank.getUsuario().getNombreUsuario());
				ventanaP.getpHomeUser().getpDatosUsuario().getLblCupoUsuario()
						.setText(String.valueOf("$" + bank.getUsuario().getTarjetaCredito().getCupoTotal()));

				ventanaP.getpHomeUser().getpTableParejas()
						.cargarParejas(convertirParejasListtoParejasArray(bank.getUsuario().getParejas()));
			} else {
				vistaE.mostrarInformacion("Usuario no existe o tipo de dato incorrecto", 1);
			}
		}
	}

	public String[] convertirUsuariosListtoUsuariosArray(ArrayList<Usuario> usuariosList) {
		String[] usuarioTexto = new String[usuariosList.size()];
		for (int i = 0; i < usuariosList.size(); i++) {
			usuarioTexto[i] = usuariosList.get(i).toString();
		}
		return usuarioTexto;
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

	public void capturarDatosCrearUsuario() {
		try {
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
				vistaE.mostrarInformacion("Usuario creado con exito, por favor logueese", 0);
				ventanaP.getpCrearUsuario().setVisible(false);
				ventanaP.getpLogin().setVisible(true);
			} else {
				vistaE.mostrarInformacion("ERROR: Ya existe un cliente con ese nombre", 1);
			}
		} catch (NumberFormatException e) {
			vistaE.mostrarInformacion("ERROR: ingreso de cupo no valido", 1);
		}
	}
}
