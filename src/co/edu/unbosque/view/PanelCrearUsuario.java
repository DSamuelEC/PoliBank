package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class PanelCrearUsuario extends JPanel {

	private JTextField txtUserName;
	private JTextField txtSaldoTC;
	private JTextField txtPassword;
	private JButton btnCreateUser;
	
	public PanelCrearUsuario() {
		setLayout(new GridLayout(400, 400));
		setBackground(Color.white);

		inicializarComponentes();

		setVisible(true);
	}

	public void inicializarComponentes() {
		txtUserName = new JTextField("UserName");
		txtUserName.setBounds(30, 30, 150, 20);
		txtUserName.setActionCommand("UserName");

		txtSaldoTC = new JTextField("Saldo TC");
		txtSaldoTC.setBounds(30, 70, 120, 20);
		txtSaldoTC.setActionCommand("Saldo TC");
		
		txtPassword = new JTextField("Password");
		txtPassword.setBounds(30, 110, 120, 20);
		txtPassword.setActionCommand("Password");

		btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(130, 160, 120, 20);
		btnCreateUser.setActionCommand("Create User Login");

		add(txtUserName);
		add(txtPassword);
		add(txtSaldoTC);	
		add(btnCreateUser);
	}

	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(JTextField txtUserName) {
		this.txtUserName = txtUserName;
	}

	public JTextField getTxtSaldoTC() {
		return txtSaldoTC;
	}

	public void setTxtSaldoTC(JTextField txtSaldoTC) {
		this.txtSaldoTC = txtSaldoTC;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JButton getBtnCreateUser() {
		return btnCreateUser;
	}

	public void setBtnCreateUser(JButton btnCreateUser) {
		this.btnCreateUser = btnCreateUser;
	}
	
}
