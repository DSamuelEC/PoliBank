package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	private PanelLogin pLogin;
	private PanelCrearUsuario pCrearUsuario;
	private PanelFunciones pFunciones;
	private PanelHomeUser pHomeUser;

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
		pHomeUser = new PanelHomeUser();
		pHomeUser.setBounds(0, 0, 500, 500);
		getContentPane().add(pHomeUser);

		pCrearUsuario = new PanelCrearUsuario();
		pCrearUsuario.setBounds(0, 0, 500, 500);
		getContentPane().add(pCrearUsuario);

		pFunciones = new PanelFunciones();
		pFunciones.setBounds(0, 0, 500, 500);
		getContentPane().add(pFunciones);
		
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

	public PanelHomeUser getpHomeUser() {
		return pHomeUser;
	}

	public void setpHomeUser(PanelHomeUser pHomeUser) {
		this.pHomeUser = pHomeUser;
	}

	public PanelFunciones getpFunciones() {
		return pFunciones;
	}

	public void setpFunciones(PanelFunciones pFunciones) {
		this.pFunciones = pFunciones;
	}

}