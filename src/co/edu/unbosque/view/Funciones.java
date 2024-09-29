package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class Funciones extends JPanel {
	
	private JTextField txtLoverName;
	private JTextField txtSaldoTC;
	private JButton btnSubmit;

	public Funciones() {

		setLayout(null);
		setBackground(Color.white);

		inicializarComponentes();

		setVisible(true);
	}

	public void inicializarComponentes() {
		txtLoverName = new JTextField("LoverName");
		txtLoverName.setBounds(70, 130, 350, 40);
		txtLoverName.setActionCommand("LoverName");

		txtSaldoTC = new JTextField("Saldo TC");
		txtSaldoTC.setBounds(70, 200, 350, 40);
		txtSaldoTC.setActionCommand("Saldo TC");

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(190, 270, 120, 20);
		btnSubmit.setActionCommand("Submit");

		add(txtLoverName);
		add(txtSaldoTC);
		add(btnSubmit);
	}

}
