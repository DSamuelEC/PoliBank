package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCardLover extends JPanel {
	private JLabel lblLoverName, lblLoverSpend;
	private String loverName, loverSpend;

	public PanelCardLover(String loverName, String loverSpend) {
		setLayout(null);
		setSize(300, 100);;
		setBackground(new Color(183, 242, 255));

		this.loverName = loverName;
		this.loverSpend = loverSpend;

		inicializarComponentes();

		setVisible(false);
	}

	private void inicializarComponentes() {
		lblLoverName = new JLabel(loverName);
		lblLoverName.setBounds(20, 20, 120, 50);

		lblLoverSpend = new JLabel(loverSpend);
		lblLoverName.setBounds(150, 20, 120, 50);

	}

	public JLabel getLblLoverName() {
		return lblLoverName;
	}

	public void setLblLoverName(JLabel lblLoverName) {
		this.lblLoverName = lblLoverName;
	}

	public JLabel getLblLoverSpend() {
		return lblLoverSpend;
	}

	public void setLblLoverSpend(JLabel lblLoverSpend) {
		this.lblLoverSpend = lblLoverSpend;
	}

	public String getLoverName() {
		return loverName;
	}

	public void setLoverName(String loverName) {
		this.loverName = loverName;
	}

	public String getLoverSpend() {
		return loverSpend;
	}

	public void setLoverSpend(String loverSpend) {
		this.loverSpend = loverSpend;
	}
}
