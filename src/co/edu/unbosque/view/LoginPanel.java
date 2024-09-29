package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private JTextField txtUserName, txtPassword;
	private JButton btnCreateUser, btnSubmit;

	public LoginPanel() {
		setLayout(new GridLayout(2, 2));
		setBackground(Color.CYAN);

		inicializarComponentes();

		setVisible(true);
	}

	private void inicializarComponentes() {
		txtUserName = new JTextField();
		configurarPlaceholder(txtUserName, "UserName");

		txtPassword = new JTextField();
		configurarPlaceholder(txtPassword, "Password");

		btnSubmit = new JButton("Submit");
		btnSubmit.setActionCommand("Sumbit Login");

		btnCreateUser = new JButton("Create User");
		btnCreateUser.setActionCommand("Create User Login");

		add(txtUserName);
		add(txtPassword);
		add(btnSubmit);
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

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}
}
