package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {
	private VentanaPrincipal ventanaP;

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

	}

}
