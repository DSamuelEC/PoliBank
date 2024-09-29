package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelLogin extends JPanel {
	private JTextField txtUserName, txtPassword;
	private JButton btnCreateUser, btnSubmit;

	public PanelLogin() {
		setLayout(null);
		setBackground(new Color(41, 119, 255));

		inicializarComponentes();

		setVisible(true);
	}

	private void inicializarComponentes() {
		txtUserName = new JTextField();
		txtUserName.setBounds(30, 100, 420, 40);
		configurarPlaceholder(txtUserName, "UserName");

		txtPassword = new JTextField();
		txtPassword.setBounds(30, 170, 420, 40);
		configurarPlaceholder(txtPassword, "Password");

		btnSubmit = new JButton("Submit");
		btnSubmit.setActionCommand("Sumbit Login");
		btnSubmit.setBounds(30, 240, 200, 40);

		btnCreateUser = new JButton("Create User");
		btnCreateUser.setActionCommand("Create User Login");
		btnCreateUser.setBounds(250, 240, 200, 40);

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
