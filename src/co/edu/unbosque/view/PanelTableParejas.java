package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.*;

public class PanelTableParejas extends JPanel{

	private JTable tableParejas;

		public PanelTableParejas() {
			setLayout(null);
			setBackground(new Color(255, 255, 255));
			inicializarComponentes();
			setVisible(true);
		}

		private void inicializarComponentes() {
			tableParejas = new JTable();
			JScrollPane scrollPanel = new JScrollPane(tableParejas);
			scrollPanel.setBounds(8, 150, 470, 180);
			scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		}

		public JTable getTableParejas() {
			return tableParejas;
		}

		public void setTableParejas(JTable tableParejas) {
			this.tableParejas = tableParejas;
		}

		
	}

