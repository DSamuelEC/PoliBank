package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelHomeAdmin extends JPanel {
	
	
	private PanelBotones pBotones;
	private PanelAgregarParejasUsuario pAgregarParejasUsuario;
	
	private PanelUsuariosAdmin pUsuariosAdmin;
	

	public PanelHomeAdmin() {
		setLayout(null);
		setBackground(new Color(41, 119, 255));
		inicializarComponentes();
		setVisible(false);
	}

	private void inicializarComponentes() {	
		pAgregarParejasUsuario = new PanelAgregarParejasUsuario();
		pAgregarParejasUsuario.setBounds(8, 42, 470, 100);

		pUsuariosAdmin = new PanelUsuariosAdmin();
		pUsuariosAdmin.setBounds(8, 150, 470, 180);
		
		pBotones = new PanelBotones();
		pBotones.setBounds(8, 340, 470, 85);

		add(pAgregarParejasUsuario);
		add(pBotones);
		add(pUsuariosAdmin);
	}
}