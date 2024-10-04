package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class PanelCrearUsuario extends JPanel {

	private JTextField txtUserName, txtSaldoTC, txtParejaNombre, txtParejaCupo;
	private JLabel lblInfo1, lblInfo2;
	private JButton btnCreateUser;

	public PanelCrearUsuario() {
		setLayout(null);
		setBackground(new Color(188, 183, 255));

		inicializarComponentes();

		setVisible(false);
	}

	public void inicializarComponentes() {
		lblInfo1 = new JLabel("Ingrese sus datos, al finalizar use el boton 'Create User'");
		lblInfo1.setBounds(70, 60, 350, 40);

		txtUserName = new JTextField();
		txtUserName.setBounds(70, 100, 350, 40);
		configurarPlaceholder(txtUserName, "UserName");

		txtSaldoTC = new JTextField();
		txtSaldoTC.setBounds(70, 160, 350, 40);
		configurarPlaceholder(txtSaldoTC, "Cupo");

		lblInfo2 = new JLabel("Debe ingresar una pareja para buen funcionamiento ");
		lblInfo2.setBounds(70, 200, 350, 40);
		
		txtParejaNombre = new JTextField();
		txtParejaNombre.setBounds(70, 280, 130, 40);
		configurarPlaceholder(txtParejaNombre, "Nombre pareja");
		
		txtParejaCupo = new JTextField();
		txtParejaCupo.setBounds(210, 280, 130, 40);
		configurarPlaceholder(txtParejaCupo, "Cupo pareja");	

		btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(70, 340, 120, 20);
		btnCreateUser.setActionCommand("Create User");

		add(lblInfo1);
		add(txtUserName);
		add(txtSaldoTC);
		add(lblInfo2);
		add(txtParejaNombre);
		add(txtParejaCupo);
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

	public JTextField getTxtParejaNombre() {
		return txtParejaNombre;
	}

	public void setTxtParejaNombre(JTextField txtParejaNombre) {
		this.txtParejaNombre = txtParejaNombre;
	}

	public JTextField getTxtParejaCupo() {
		return txtParejaCupo;
	}

	public void setTxtParejaCupo(JTextField txtParejaCupo) {
		this.txtParejaCupo = txtParejaCupo;
	}

	public JLabel getLblInfo1() {
		return lblInfo1;
	}

	public void setLblInfo1(JLabel lblInfo1) {
		this.lblInfo1 = lblInfo1;
	}

	public JLabel getLblInfo2() {
		return lblInfo2;
	}

	public void setLblInfo2(JLabel lblInfo2) {
		this.lblInfo2 = lblInfo2;
	}
}