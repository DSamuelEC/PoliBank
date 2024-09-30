package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelHomeUser extends JPanel {
    private JButton btnAgregarPareja, btnActualizarPareja, btnEliminarPareja, btnSalir, btnVerTodo;
    private JTextField txtAliasPareja, txtCupoPareja;
    private JTable tableParejas;

    public PanelHomeUser() {
        setLayout(null);
        setBackground(new Color(41, 119, 255));
        inicializarComponentes();
        setVisible(false);
    }

    private void inicializarComponentes() {
        // Panel para agregar nueva pareja
        JPanel panelFormularioParejas = new JPanel(null);
        panelFormularioParejas.setBounds(10, 10, 470, 100);
        panelFormularioParejas.setBackground(new Color(200, 200, 255));  // Un color diferente para visualizar el panel

        JLabel lblAlias = new JLabel("Alias de la Pareja:");
        lblAlias.setBounds(10, 10, 120, 25);
        txtAliasPareja = new JTextField(15);
        txtAliasPareja.setBounds(140, 10, 150, 25);

        JLabel lblCupo = new JLabel("Cupo en Dólares:");
        lblCupo.setBounds(10, 40, 120, 25);
        txtCupoPareja = new JTextField(5);
        txtCupoPareja.setBounds(140, 40, 150, 25);

        btnAgregarPareja = new JButton("Agregar Pareja");
        btnAgregarPareja.setBounds(300, 10, 160, 25);

        panelFormularioParejas.add(lblAlias);
        panelFormularioParejas.add(txtAliasPareja);
        panelFormularioParejas.add(lblCupo);
        panelFormularioParejas.add(txtCupoPareja);
        panelFormularioParejas.add(btnAgregarPareja);

        // Tabla para mostrar las parejas
        tableParejas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tableParejas);
        scrollPane.setBounds(11, 120, 467, 150);

        // Panel para botones
        JPanel panelBotones = new JPanel(null);
        panelBotones.setBounds(10, 280, 470, 85);
        panelBotones.setBackground(new Color(200, 200, 255)); 
        btnActualizarPareja = new JButton("Actualizar Pareja");
        btnActualizarPareja.setBounds(5, 10, 150, 25);
        btnEliminarPareja = new JButton("Eliminar Pareja");
        btnEliminarPareja.setBounds(165, 10, 150, 25);
        btnVerTodo = new JButton("Ver Todo");
        btnVerTodo.setBounds(325, 10, 140, 25);
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(165, 50, 150, 25); 

        panelBotones.add(btnActualizarPareja);
        panelBotones.add(btnEliminarPareja);
        panelBotones.add(btnSalir);
        panelBotones.add(btnVerTodo); 

        add(panelFormularioParejas);
        add(scrollPane);
        add(panelBotones);
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

	public JTextField getTxtAliasPareja() {
		return txtAliasPareja;
	}

	public void setTxtAliasPareja(JTextField txtAliasPareja) {
		this.txtAliasPareja = txtAliasPareja;
	}

	public JTextField getTxtCupoPareja() {
		return txtCupoPareja;
	}

	public void setTxtCupoPareja(JTextField txtCupoPareja) {
		this.txtCupoPareja = txtCupoPareja;
	}

	public JTable getTableParejas() {
		return tableParejas;
	}

	public void setTableParejas(JTable tableParejas) {
		this.tableParejas = tableParejas;
	}
    
}
