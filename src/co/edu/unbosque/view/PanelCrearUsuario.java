package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class PanelCrearUsuario extends JPanel {

	private JTextField txtUserName, txtSaldoTC, txtParejaNombre, txtParejaCupo;
	private JButton btnCreateUser;

	public PanelCrearUsuario() {
		setLayout(null);
		setBackground(new Color(188, 183, 255));

		inicializarComponentes();

		setVisible(false);
	}

	public void inicializarComponentes() {
		txtUserName = new JTextField();
		txtUserName.setBounds(70, 60, 350, 40);
		configurarPlaceholder(txtUserName, "UserName");

		txtSaldoTC = new JTextField();
		txtSaldoTC.setBounds(70, 130, 350, 40);
		configurarPlaceholder(txtSaldoTC, "Cupo");

		btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(190, 270, 120, 20);
		btnCreateUser.setActionCommand("Create User");

		add(txtUserName);
		add(txtSaldoTC);
		add(btnCreateUser);
	}
	
	private void configurarPlaceholder(JTextField textField, String placeholder) {
		// Establecer el placeholder inicialmente
		textField.setText(placeholder);
		textField.setForeground(Color.GRAY);

		textField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Si el texto es igual al placeholder, lo borra y cambia el color
				if (textField.getText().equals(placeholder)) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Si el campo está vacío al perder el foco, restablece el placeholder
				if (textField.getText().isEmpty()) {
					textField.setForeground(Color.GRAY);
					textField.setText(placeholder);
				}
			}
		});
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

	public JButton getBtnCreateUser() {
		return btnCreateUser;
	}

	public void setBtnCreateUser(JButton btnCreateUser) {
		this.btnCreateUser = btnCreateUser;
	}

}