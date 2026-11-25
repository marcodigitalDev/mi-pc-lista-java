package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class VentanaVentas extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo;
	private JLabel lblLogo;
	private JPanel pnlLinea;
	private JLabel lblLaptops;
	private JScrollPane scpLaptops;
	private JTable tblLaptops;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblEmpresa;
	private JTextField txtEmpresa;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JLabel lblVentas;
	private JLabel lblBuscar;
	private JTextField txtBuscar;
	private JScrollPane scpVentas;
	private JTable tblVentas;
	private JButton btnVender;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private Tienda tienda;

	public VentanaVentas(Tienda tie) {
		tienda = tie;

		setTitle("Ventas");
		setModal(true);
		setResizable(false);
		setBounds(100, 60, 936, 610);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		lblTitulo = new JLabel("Ventas");
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblTitulo.setBounds(15, 14, 400, 28);
		getContentPane().add(lblTitulo);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("src/imagenes/logo_pequeno.png"));
		lblLogo.setBounds(779, 5, 126, 44);
		getContentPane().add(lblLogo);

		pnlLinea = new JPanel();
		pnlLinea.setBackground(new Color(225, 0, 0));
		pnlLinea.setBounds(0, 54, 936, 3);
		getContentPane().add(pnlLinea);

		lblLaptops = new JLabel("1. Seleccione la laptop e ingrese los datos de la venta (empresa es opcional)");
		lblLaptops.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblLaptops.setBounds(15, 68, 700, 18);
		getContentPane().add(lblLaptops);

		scpLaptops = new JScrollPane();
		scpLaptops.setBounds(15, 92, 890, 150);
		getContentPane().add(scpLaptops);

		tblLaptops = new JTable();
		tblLaptops.setModel(tienda.getModeloLaptops());
		tblLaptops.setRowHeight(24);
		tblLaptops.setSelectionBackground(new Color(255, 215, 215));
		tblLaptops.setSelectionForeground(Color.BLACK);
		tblLaptops.setShowGrid(true);
		tblLaptops.setGridColor(new Color(225, 225, 225));
		tblLaptops.getColumn("Código").setPreferredWidth(55);
		tblLaptops.getColumn("Marca").setPreferredWidth(75);
		tblLaptops.getColumn("Modelo").setPreferredWidth(110);
		tblLaptops.getColumn("Procesador").setPreferredWidth(110);
		tblLaptops.getColumn("RAM").setPreferredWidth(60);
		tblLaptops.getColumn("Almacenamiento").setPreferredWidth(115);
		tblLaptops.getColumn("Pantalla").setPreferredWidth(70);
		tblLaptops.getColumn("Sistema").setPreferredWidth(120);
		tblLaptops.getColumn("Precio S/.").setPreferredWidth(80);
		tblLaptops.getColumn("Stock").setPreferredWidth(50);
		tblLaptops.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblLaptops.getTableHeader().setReorderingAllowed(false);
		// Las celdas no se editan directamente en la tabla
		tblLaptops.setDefaultEditor(Object.class, null);
		scpLaptops.setViewportView(tblLaptops);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 258, 60, 16);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(75, 254, 120, 25);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(207, 258, 60, 16);
		getContentPane().add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(267, 254, 120, 25);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(399, 258, 60, 16);
		getContentPane().add(lblEmpresa);

		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(459, 254, 120, 25);
		getContentPane().add(txtEmpresa);
		txtEmpresa.setColumns(10);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(591, 258, 65, 16);
		getContentPane().add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(656, 254, 60, 25);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

		btnVender = new JButton("Vender");
		btnVender.setIcon(new ImageIcon("src/imagenes/vender.png"));
		btnVender.addActionListener(this);
		btnVender.setBounds(780, 250, 125, 32);
		getContentPane().add(btnVender);

		lblVentas = new JLabel("2. Ventas registradas");
		lblVentas.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblVentas.setBounds(15, 298, 400, 18);
		getContentPane().add(lblVentas);

		scpVentas = new JScrollPane();
		scpVentas.setBounds(15, 322, 890, 180);
		getContentPane().add(scpVentas);

		tblVentas = new JTable();
		tblVentas.setModel(tienda.getModeloVentas());
		tblVentas.setRowHeight(24);
		tblVentas.setSelectionBackground(new Color(255, 215, 215));
		tblVentas.setSelectionForeground(Color.BLACK);
		tblVentas.setShowGrid(true);
		tblVentas.setGridColor(new Color(225, 225, 225));
		tblVentas.getColumn("N° venta").setPreferredWidth(60);
		tblVentas.getColumn("Código").setPreferredWidth(55);
		tblVentas.getColumn("Producto").setPreferredWidth(155);
		tblVentas.getColumn("Nombre").setPreferredWidth(95);
		tblVentas.getColumn("Apellido").setPreferredWidth(95);
		tblVentas.getColumn("Empresa").setPreferredWidth(110);
		tblVentas.getColumn("Cantidad").setPreferredWidth(65);
		tblVentas.getColumn("Precio unit. S/.").setPreferredWidth(110);
		tblVentas.getColumn("Importe total S/.").setPreferredWidth(120);
		tblVentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblVentas.getTableHeader().setReorderingAllowed(false);
		// Las celdas no se editan directamente en la tabla
		tblVentas.setDefaultEditor(Object.class, null);
		scpVentas.setViewportView(tblVentas);

		lblBuscar = new JLabel("N° venta");
		lblBuscar.setBounds(15, 522, 70, 16);
		getContentPane().add(lblBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(85, 518, 100, 25);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon("src/imagenes/buscar.png"));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(195, 514, 125, 32);
		getContentPane().add(btnConsultar);

		btnEliminar = new JButton("Eliminar venta");
		btnEliminar.setIcon(new ImageIcon("src/imagenes/eliminar.png"));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(745, 514, 160, 32);
		getContentPane().add(btnEliminar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVender) {
			actionPerformedBtnVender(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
	}

	protected void actionPerformedBtnVender(ActionEvent arg0) {
		int fila, cantidad;
		String nombre, apellido, empresa;

		fila = tblLaptops.getSelectedRow();
		nombre = getTexto(txtNombre);
		apellido = getTexto(txtApellido);
		empresa = getTexto(txtEmpresa);
		cantidad = getCantidad();

		if (fila == -1) {
			mensaje("Seleccione una laptop de la tabla");
		}
		else if (nombre.equals("") || apellido.equals("")) {
			mensaje("Ingrese el nombre y el apellido");
		}
		else if (cantidad < 1) {
			mensaje("La cantidad debe ser un número entero desde 1");
		}
		else if (cantidad > tienda.getStock(fila)) {
			mensaje("Stock insuficiente. Unidades disponibles: " + tienda.getStock(fila));
		}
		else {
			tienda.registrarVenta(fila, nombre, apellido, empresa, cantidad);
			txtNombre.setText("");
			txtApellido.setText("");
			txtEmpresa.setText("");
			txtCantidad.setText("");
			seleccionar(tblVentas.getRowCount() - 1);
		}
	}

	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		int fila;

		fila = tienda.buscarFila(tienda.getModeloVentas(), getTexto(txtBuscar));

		if (fila == -1) {
			mensaje("No existe una venta con ese número");
		}
		else {
			seleccionar(fila);
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		int fila, respuesta;

		fila = tblVentas.getSelectedRow();

		if (fila == -1) {
			mensaje("Seleccione una venta de la tabla");
		}
		else {
			respuesta = JOptionPane.showConfirmDialog(this,
					"¿Eliminar la venta " + tblVentas.getValueAt(fila, 0)
							+ "? Las unidades volverán al stock si la laptop sigue en el catálogo.",
					"Confirmar", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				tienda.eliminarVenta(fila);
			}
		}
	}

	String getTexto(JTextField txt) {
		return txt.getText().trim();
	}

	// Retorna -1 si no es un número entero
	int getCantidad() {
		try {
			return Integer.parseInt(getTexto(txtCantidad));
		}
		catch (NumberFormatException e) {
			return -1;
		}
	}

	// Desplaza la tabla hasta mostrar la fila seleccionada
	void seleccionar(int fila) {
		tblVentas.setRowSelectionInterval(fila, fila);
		tblVentas.scrollRectToVisible(tblVentas.getCellRect(fila, 0, true));
	}

	void mensaje(String cad) {
		JOptionPane.showMessageDialog(this, cad);
	}
}
