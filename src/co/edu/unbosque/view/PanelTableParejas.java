package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class PanelTableParejas extends JPanel {

	private JTextArea txaParejas;
	private JScrollPane scrollPanel;

	public PanelTableParejas() {
		setLayout(new BorderLayout());
		setBackground(new Color(255, 255, 255));
		inicializarComponentes();
		setVisible(true);
	}

	private void inicializarComponentes() {
		txaParejas = new JTextArea();
		txaParejas.setEditable(false); // En false hace que el JTextArea no sea editable
		txaParejas.setLineWrap(true); // Ajusta el texto automáticamente

//		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPanel = new JScrollPane(txaParejas);
		add(scrollPanel, BorderLayout.CENTER);
	}

	public void cargarParejas(String[] parejas) {
		for (String pareja : parejas) {
			txaParejas.append(pareja + "\n");
		}
	}

	public JTextArea getTxaParejas() {
		return txaParejas;
	}

	public void setTxaParejas(JTextArea txaParejas) {
		this.txaParejas = txaParejas;
	}

	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}

	public void setScrollPanel(JScrollPane scrollPanel) {
		this.scrollPanel = scrollPanel;
	}
}