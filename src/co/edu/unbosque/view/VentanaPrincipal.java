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
		getContentPane().setLayout(new BorderLayout());

		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inicializarComponentes() {
		pFunciones = new Funciones();
		getContentPane().add(pFunciones);
		pCrearUsuario = new PanelCrearUsuario();
		getContentPane().add(pCrearUsuario);
		pLogin = new PanelLogin();
		getContentPane().add(pLogin);
		
	}

	public PanelLogin getpLogin() {
		return pLogin;
	}

	public void setpLogin(PanelLogin pLogin) {
		this.pLogin = pLogin;
	}

	public PanelCrearUsuario getpCrearUsuario() {
		return pCrearUsuario;
	}

	public void setpCrearUsuario(PanelCrearUsuario pCrearUsuario) {
		this.pCrearUsuario = pCrearUsuario;
	}

	public Funciones getpFunciones() {
		return pFunciones;
	}

	public void setpFunciones(Funciones pFunciones) {
		this.pFunciones = pFunciones;
	}
}