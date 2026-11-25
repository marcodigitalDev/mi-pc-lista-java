package app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MenuPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JLabel lblLogo;
	private JPanel pnlLinea;
	private JLabel lblTitulo;
	private JLabel lblResumen;
	private JButton btnProductos;
	private JButton btnVentas;
	private JButton btnSalir;
	private Tienda tienda;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		// La misma tienda se entrega a todas las ventanas
		tienda = new Tienda();

		setTitle("Mi PC Lista");
		setResizable(false);
		setBounds(100, 100, 500, 430);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("src/imagenes/logo.png"));
		lblLogo.setBounds(117, 12, 251, 88);
		getContentPane().add(lblLogo);

		pnlLinea = new JPanel();
		pnlLinea.setBackground(new Color(225, 0, 0));
		pnlLinea.setBounds(0, 110, 500, 3);
		getContentPane().add(pnlLinea);

		lblTitulo = new JLabel("Sistema de gestión para vendedores");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitulo.setBounds(10, 128, 465, 26);
		getContentPane().add(lblTitulo);

		lblResumen = new JLabel("Administre el catálogo de laptops y registre sus ventas.");
		lblResumen.setHorizontalAlignment(SwingConstants.CENTER);
		lblResumen.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblResumen.setForeground(Color.DARK_GRAY);
		lblResumen.setBounds(10, 158, 465, 20);
		getContentPane().add(lblResumen);

		btnProductos = new JButton("Productos");
		btnProductos.setIcon(new ImageIcon("src/imagenes/productos.png"));
		btnProductos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProductos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProductos.addActionListener(this);
		btnProductos.setBounds(53, 205, 180, 110);
		getContentPane().add(btnProductos);

		btnVentas = new JButton("Ventas");
		btnVentas.setIcon(new ImageIcon("src/imagenes/ventas.png"));
		btnVentas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVentas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVentas.addActionListener(this);
		btnVentas.setBounds(253, 205, 180, 110);
		getContentPane().add(btnVentas);

		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon("src/imagenes/salir.png"));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(188, 335, 110, 32);
		getContentPane().add(btnSalir);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProductos) {
			actionPerformedBtnProductos(arg0);
		}
		if (arg0.getSource() == btnVentas) {
			actionPerformedBtnVentas(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
	}

	protected void actionPerformedBtnProductos(ActionEvent arg0) {
		VentanaProductos ventana = new VentanaProductos(tienda);
		ventana.setVisible(true);
	}

	protected void actionPerformedBtnVentas(ActionEvent arg0) {
		VentanaVentas ventana = new VentanaVentas(tienda);
		ventana.setVisible(true);
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		System.exit(0);
	}
}
