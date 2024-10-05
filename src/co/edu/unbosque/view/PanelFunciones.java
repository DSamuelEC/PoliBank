package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class PanelFunciones extends JPanel {
	
	private JTextField txtLoverName;
	private JTextField txtSaldoTC;
	private JButton btnSubmit;

	public PanelFunciones() {
		setLayout(null);
		setBackground(new Color(183, 210, 255));

		inicializarComponentes();

		setVisible(false);
	}

	public void inicializarComponentes() {
		txtLoverName = new JTextField();
		txtLoverName.setBounds(70, 130, 350, 40);
		configurarPlaceholder(txtLoverName, "LoverName");

		txtSaldoTC = new JTextField();
		txtSaldoTC.setBounds(70, 200, 350, 40);
		configurarPlaceholder(txtSaldoTC, "Saldo");

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(190, 270, 120, 20);
		btnSubmit.setActionCommand("Submit");

		add(txtLoverName);
		add(txtSaldoTC);
		add(btnSubmit);
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
	
	public JTextField getTxtLoverName() {
		return txtLoverName;
	}

	public void setTxtLoverName(JTextField txtLoverName) {
		this.txtLoverName = txtLoverName;
	}

	public JTextField getTxtSaldoTC() {
		return txtSaldoTC;
	}

	public void setTxtSaldoTC(JTextField txtSaldoTC) {
		this.txtSaldoTC = txtSaldoTC;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

}
