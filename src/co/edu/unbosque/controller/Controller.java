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

		});
		ventanaP.getpCrearUsuario().getBtnCreateUser().addActionListener(e -> {
			ventanaP.getpCrearUsuario().setVisible(false);
			ventanaP.getpLogin().setVisible(true);
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

	}

}
