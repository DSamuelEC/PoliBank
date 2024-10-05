package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.*;

public class PanelAgregarParejasUsuario extends JPanel {

	private JButton btnAgregarPareja;
	private JTextField txtAliasPareja, txtCupoPareja;

	public PanelAgregarParejasUsuario() {
		setLayout(null);
		setBackground(new Color(200, 200, 255));
		inicializarComponentes();
		setVisible(true);
	}

	private void inicializarComponentes() {
		JLabel lblAlias = new JLabel("Alias de la Pareja:");
		lblAlias.setBounds(10, 10, 120, 25);
		txtAliasPareja = new JTextField(15);
		txtAliasPareja.setBounds(140, 10, 150, 25);

		JLabel lblCupo = new JLabel("Cupo en Dólares:");
		lblCupo.setBounds(10, 40, 120, 25);
		txtCupoPareja = new JTextField(5);
		txtCupoPareja.setBounds(140, 40, 150, 25);

		btnAgregarPareja = new JButton("Agregar Pareja");
		btnAgregarPareja.setBounds(300, 10, 160, 25);

		add(lblAlias);
		add(txtAliasPareja);
		add(lblCupo);
		add(txtCupoPareja);
		add(btnAgregarPareja);
	}

	public JButton getBtnAgregarPareja() {
		return btnAgregarPareja;
	}

	public void setBtnAgregarPareja(JButton btnAgregarPareja) {
		this.btnAgregarPareja = btnAgregarPareja;
	}

	public JTextField getTxtAliasPareja() {
		return txtAliasPareja;
	}

	public void setTxtAliasPareja(JTextField txtAliasPareja) {
		this.txtAliasPareja = txtAliasPareja;
	}

	public JTextField getTxtCupoPareja() {
		return txtCupoPareja;
	}

	public void setTxtCupoPareja(JTextField txtCupoPareja) {
		this.txtCupoPareja = txtCupoPareja;
	}

	
}