package co.edu.unbosque.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCardsLovers extends JPanel {
	private JLabel lblLoverName, lblLoverSpend;
	private PanelCardLover pCard;
	private String name, spend;

	public PanelCardsLovers() {
		setLayout(null);
		setSize(400, 400);
		setBackground(new Color(183, 242, 255));
		
		this.name = "";
		this.spend = "";

		setVisible(false);
	}
//	//[a1[name, spend], a2[name, spend], a3[name, spend]]
//	private void inicializarComponentes(ArrayList<T> amantes) {
//		lblLoverName = new JLabel();
//		lblLoverSpend = new JLabel();
//		for (String aman : amantes) {
////			name = aman.name;
////			pCard = new PanelCardLover(aman.name, TOOL_TIP_TEXT_KEY);
//		}
//	}
}
