package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class Funciones extends JPanel {
	
	private JTextField txtLoverName;
	private JTextField txtSaldoTC;
	private JButton btnSubmit;

	public Funciones() {

		setLayout(new GridLayout(400, 400));
		setBackground(Color.white);

		inicializarComponentes();

		setVisible(false);
	}

	public void inicializarComponentes() {
		txtLoverName = new JTextField("LoverName");
		txtLoverName.setBounds(10, 30, 150, 20);
		txtLoverName.setActionCommand("LoverName");

		txtSaldoTC = new JTextField("Saldo TC");
		txtSaldoTC.setBounds(10, 70, 120, 20);
		txtSaldoTC.setActionCommand("Saldo TC");

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(10, 160, 120, 20);
		btnSubmit.setActionCommand("Submit");

		add(txtLoverName);
		add(txtSaldoTC);
		add(btnSubmit);
	}

}
