package co.edu.unbosque.view;

public class VentanaPrincipal {
	
	public VentanaPrincipal() {
		setTitle("");
		setSize(0,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(0,0,0));
		getContentPane().setLayout(new BorderLayout(10,10));
		
		inicializarComponentes();
		
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void inicializarComponentes() {
	}
}

}
