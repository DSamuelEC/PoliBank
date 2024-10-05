package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelHomeUser extends JPanel {
	
	
	private PanelBotones pBotones;
	private PanelDatosUsuario pDatosUsuario;
	private PanelAgregarParejasUsuario pAgregarParejasUsuario;
	private PanelTableParejas pTableParejas;
	

	public PanelHomeUser() {
		setLayout(null);
		setBackground(new Color(41, 119, 255));
		inicializarComponentes();
		setVisible(false);
	}

	private void inicializarComponentes() {	
		pDatosUsuario = new PanelDatosUsuario();
		pDatosUsuario.setBounds(8, 10, 470, 24);

		
		pAgregarParejasUsuario = new PanelAgregarParejasUsuario();
		pAgregarParejasUsuario.setBounds(8, 42, 470, 100);

		pTableParejas = new PanelTableParejas();
		pTableParejas.setBounds(8, 150, 470, 180);
		
		
		pBotones = new PanelBotones();
		pBotones.setBounds(8, 340, 470, 85);


		add(pAgregarParejasUsuario);
		add(pBotones);
		add(pDatosUsuario);
		add(pTableParejas);
	}

	public PanelBotones getpBotones() {
		return pBotones;
	}

	public void setpBotones(PanelBotones pBotones) {
		this.pBotones = pBotones;
	}

	public PanelDatosUsuario getpDatosUsuario() {
		return pDatosUsuario;
	}

	public void setpDatosUsuario(PanelDatosUsuario pDatosUsuario) {
		this.pDatosUsuario = pDatosUsuario;
	}

	public PanelAgregarParejasUsuario getpAgregarParejasUsuario() {
		return pAgregarParejasUsuario;
	}

	public void setpAgregarParejasUsuario(PanelAgregarParejasUsuario pAgregarParejasUsuario) {
		this.pAgregarParejasUsuario = pAgregarParejasUsuario;
	}

	public PanelTableParejas getpTableParejas() {
		return pTableParejas;
	}

	public void setpTableParejas(PanelTableParejas pTableParejas) {
		this.pTableParejas = pTableParejas;
	}

}