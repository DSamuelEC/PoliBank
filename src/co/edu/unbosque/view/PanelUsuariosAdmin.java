package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class PanelUsuariosAdmin extends JPanel {

	private JTextArea txaUsuarios;
	private JScrollPane scrollPanel;

	public PanelUsuariosAdmin() {
		setLayout(new BorderLayout());
		setBackground(new Color(255, 255, 255));
		inicializarComponentes();
		setVisible(true);
	}

	private void inicializarComponentes() {
		txaUsuarios = new JTextArea();
		txaUsuarios.setEditable(false); // En false hace que el JTextArea no sea editable
		txaUsuarios.setLineWrap(true); // Ajusta el texto automáticamente

//		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPanel = new JScrollPane(txaUsuarios);
		add(scrollPanel, BorderLayout.CENTER);
	}
	
	public void limpiarArea() {
		txaUsuarios.setText("");
	}

	public void cargarUsuarios(String[] usuarios) {
		for (String usuario : usuarios) {
			txaUsuarios.append(usuario + "\n");
		}
	}

	public JTextArea getTxaParejas() {
		return txaUsuarios;
	}

	public void setTxaParejas(JTextArea txaParejas) {
		this.txaUsuarios = txaParejas;
	}

	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}

	public void setScrollPanel(JScrollPane scrollPanel) {
		this.scrollPanel = scrollPanel;
	}
}