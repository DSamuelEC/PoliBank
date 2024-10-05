package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.*;

public class PanelDatosUsuario extends JPanel {

	private JLabel lblUserName, lblCupoUsuario;

	public PanelDatosUsuario() {
		setLayout(null);
		setBackground(new Color(200, 200, 255));
		inicializarComponentes();
		setVisible(true);
	}

	private void inicializarComponentes() {
		lblUserName = new JLabel("Usuario: ");
		lblUserName.setBounds(5, 1, 120, 25);

		lblCupoUsuario = new JLabel("Cupo: ");
		lblCupoUsuario.setBounds(270, 1, 120, 25);

		add(lblCupoUsuario);
		add(lblUserName);

	}

	public JLabel getLblUserName() {
		return lblUserName;
	}

	public void setLblUserName(JLabel lblUserName) {
		this.lblUserName = lblUserName;
	}

	public JLabel getLblCupoUsuario() {
		return lblCupoUsuario;
	}

	public void setLblCupoUsuario(JLabel lblCupoUsuario) {
		this.lblCupoUsuario = lblCupoUsuario;
	}
}