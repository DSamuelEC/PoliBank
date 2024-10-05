package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.*;

public class PanelBotones extends JPanel {
	

	private JButton btnAgregarPareja, btnActualizarPareja, btnEliminarPareja, btnSalir, btnVerTodo;

		public PanelBotones() {
			setLayout(null);
			setBackground(new Color(200, 200, 255));
			inicializarComponentes();
			setVisible(true);
		}

		private void inicializarComponentes() {
			
			btnActualizarPareja = new JButton("Actualizar Pareja");
			btnActualizarPareja.setBounds(5, 10, 150, 25);
			btnEliminarPareja = new JButton("Eliminar Pareja");
			btnEliminarPareja.setBounds(165, 10, 150, 25);
			btnVerTodo = new JButton("Ver Todo");
			btnVerTodo.setBounds(325, 10, 140, 25);
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(165, 50, 150, 25);

			add(btnActualizarPareja);
			add(btnEliminarPareja);
			add(btnSalir);
			add(btnVerTodo);
		}

		public JButton getBtnAgregarPareja() {
			return btnAgregarPareja;
		}

		public void setBtnAgregarPareja(JButton btnAgregarPareja) {
			this.btnAgregarPareja = btnAgregarPareja;
		}

		public JButton getBtnActualizarPareja() {
			return btnActualizarPareja;
		}

		public void setBtnActualizarPareja(JButton btnActualizarPareja) {
			this.btnActualizarPareja = btnActualizarPareja;
		}

		public JButton getBtnEliminarPareja() {
			return btnEliminarPareja;
		}

		public void setBtnEliminarPareja(JButton btnEliminarPareja) {
			this.btnEliminarPareja = btnEliminarPareja;
		}

		public JButton getBtnSalir() {
			return btnSalir;
		}

		public void setBtnSalir(JButton btnSalir) {
			this.btnSalir = btnSalir;
		}

		public JButton getBtnVerTodo() {
			return btnVerTodo;
		}

		public void setBtnVerTodo(JButton btnVerTodo) {
			this.btnVerTodo = btnVerTodo;
		}

		
	}

