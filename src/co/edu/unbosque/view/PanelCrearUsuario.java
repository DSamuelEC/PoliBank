package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.*;

public class PanelCrearUsuario extends JPanel {

	private JTextField txtUserName;
	private JTextField txtSaldoTC;
	private JTextField txtPassword;
	private JButton btnCreateUser;
	
	public PanelCrearUsuario() {
		setLayout(null);
		setBackground(Color.white);

		inicializarComponentes();

		setVisible(true);
	}

	public void inicializarComponentes() {
		txtUserName = new JTextField("UserName");
		txtUserName.setBounds(70, 60, 350, 40);
		txtUserName.setActionCommand("UserName");

		txtSaldoTC = new JTextField("Saldo TC");
		txtSaldoTC.setBounds(70, 130, 350, 40);
		txtSaldoTC.setActionCommand("Saldo TC");
		
		txtPassword = new JTextField("Password");
		txtPassword.setBounds(70, 200, 350, 40);
		txtPassword.setActionCommand("Password");

		btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(190, 270, 120, 20);
		btnCreateUser.setActionCommand("Create User");

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
