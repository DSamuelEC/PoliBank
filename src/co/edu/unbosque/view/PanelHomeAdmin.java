package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelHomeAdmin extends JPanel {
	
	private PanelUsuariosAdmin pUsuariosAdmin;
	

	public PanelHomeAdmin() {
		setLayout(null);
		setBackground(new Color(41, 119, 255));
		inicializarComponentes();
		setVisible(false);
	}

	private void inicializarComponentes() {	

		pUsuariosAdmin = new PanelUsuariosAdmin();
		pUsuariosAdmin.setBounds(8, 150, 470, 180);

		add(pUsuariosAdmin);
	}

	public PanelUsuariosAdmin getpUsuariosAdmin() {
		return pUsuariosAdmin;
	}

	public void setpUsuariosAdmin(PanelUsuariosAdmin pUsuariosAdmin) {
		this.pUsuariosAdmin = pUsuariosAdmin;
	}
}