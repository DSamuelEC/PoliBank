package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	private PanelLogin pLogin;
	private PanelCrearUsuario pCrearUsuario;
	private Funciones pFunciones;

	public VentanaPrincipal() {
		setTitle("PoliBank");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.gray);
		getContentPane().setLayout(new BorderLayout());

		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inicializarComponentes() {
		pLogin = new PanelLogin();
		getContentPane().add(pLogin);
		pCrearUsuario = new PanelCrearUsuario();
		getContentPane().add(pCrearUsuario);
		pFunciones = new Funciones();
		getContentPane().add(pFunciones);
		
	}
}