package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	private PanelLogin pLogin;
	private PanelCrearUsuario pCrearUsuario;
	private Funciones pFunciones;

	public VentanaPrincipal() {
		setTitle("PoliBank");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new BorderLayout());
		getContentPane().setLayout(null);

		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inicializarComponentes() {
		pFunciones = new Funciones();
		pFunciones.setBounds(0, 0, 500, 500);
		getContentPane().add(pFunciones);

		pCrearUsuario = new PanelCrearUsuario();
		pCrearUsuario.setBounds(0, 0, 500, 500);
		getContentPane().add(pCrearUsuario);

		pLogin = new PanelLogin();
		pLogin.setBounds(0, 0, 500, 500);
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