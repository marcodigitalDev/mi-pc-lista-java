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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VentanaProductos extends JDialog implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;

	// Declaración de variables
	private JLabel lblTitulo;
	private JLabel lblLogo;
	private JPanel pnlLinea;
	private JLabel lblBuscar;
	private JTextField txtBuscar;
	private JScrollPane scpLaptops;
	private JTable tblLaptops;
	private JLabel lblCodigo;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblProcesador;
	private JLabel lblRam;
	private JLabel lblAlmacenamiento;
	private JLabel lblPantalla;
	private JLabel lblSistema;
	private JLabel lblPrecio;
	private JLabel lblStock;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtProcesador;
	private JTextField txtRam;
	private JTextField txtAlmacenamiento;
	private JTextField txtPantalla;
	private JTextField txtSistema;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JButton btnConsultar;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private Tienda tienda;

	// Crea la GUI
	public VentanaProductos(Tienda tie) {
		tienda = tie;

		setTitle("Productos");
		setModal(true);
		setResizable(false);
		setBounds(100, 60, 936, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		lblTitulo = new JLabel("Productos");
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblTitulo.setBounds(15, 14, 400, 28);
		getContentPane().add(lblTitulo);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("src/imagenes/logo_pequeno.png"));
		lblLogo.setBounds(779, 5, 126, 44);
		getContentPane().add(lblLogo);

		// Línea roja del encabezado
		pnlLinea = new JPanel();
		pnlLinea.setBackground(new Color(225, 0, 0));
		pnlLinea.setBounds(0, 54, 936, 3);
		getContentPane().add(pnlLinea);

		lblBuscar = new JLabel("Código");
		lblBuscar.setBounds(15, 74, 60, 16);
		getContentPane().add(lblBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(75, 70, 110, 25);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon("src/imagenes/buscar.png"));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(195, 66, 125, 32);
		getContentPane().add(btnConsultar);

		scpLaptops = new JScrollPane();
		scpLaptops.setBounds(15, 108, 890, 220);
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
		tblLaptops.getSelectionModel().addListSelectionListener(this);
		scpLaptops.setViewportView(tblLaptops);

		lblCodigo = new JLabel("");
		lblCodigo.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCodigo.setBounds(15, 342, 600, 18);
		getContentPane().add(lblCodigo);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(15, 378, 120, 16);
		getContentPane().add(lblMarca);

		txtMarca = new JTextField();
		txtMarca.setBounds(135, 374, 160, 25);
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(320, 378, 120, 16);
		getContentPane().add(lblModelo);

		txtModelo = new JTextField();
		txtModelo.setBounds(440, 374, 160, 25);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);

		lblProcesador = new JLabel("Procesador");
		lblProcesador.setBounds(625, 378, 120, 16);
		getContentPane().add(lblProcesador);

		txtProcesador = new JTextField();
		txtProcesador.setBounds(745, 374, 160, 25);
		getContentPane().add(txtProcesador);
		txtProcesador.setColumns(10);

		lblRam = new JLabel("Memoria RAM");
		lblRam.setBounds(15, 416, 120, 16);
		getContentPane().add(lblRam);

		txtRam = new JTextField();
		txtRam.setBounds(135, 412, 160, 25);
		getContentPane().add(txtRam);
		txtRam.setColumns(10);

		lblAlmacenamiento = new JLabel("Almacenamiento");
		lblAlmacenamiento.setBounds(320, 416, 120, 16);
		getContentPane().add(lblAlmacenamiento);

		txtAlmacenamiento = new JTextField();
		txtAlmacenamiento.setBounds(440, 412, 160, 25);
		getContentPane().add(txtAlmacenamiento);
		txtAlmacenamiento.setColumns(10);

		lblPantalla = new JLabel("Pantalla");
		lblPantalla.setBounds(625, 416, 120, 16);
		getContentPane().add(lblPantalla);

		txtPantalla = new JTextField();
		txtPantalla.setBounds(745, 412, 160, 25);
		getContentPane().add(txtPantalla);
		txtPantalla.setColumns(10);

		lblSistema = new JLabel("Sistema operativo");
		lblSistema.setBounds(15, 454, 120, 16);
		getContentPane().add(lblSistema);

		txtSistema = new JTextField();
		txtSistema.setBounds(135, 450, 160, 25);
		getContentPane().add(txtSistema);
		txtSistema.setColumns(10);

		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(320, 454, 120, 16);
		getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(440, 450, 160, 25);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		lblStock = new JLabel("Stock");
		lblStock.setBounds(625, 454, 120, 16);
		getContentPane().add(lblStock);

		txtStock = new JTextField();
		txtStock.setBounds(745, 450, 160, 25);
		getContentPane().add(txtStock);
		txtStock.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon("src/imagenes/nuevo.png"));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(15, 502, 125, 32);
		getContentPane().add(btnNuevo);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon("src/imagenes/guardar.png"));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(155, 502, 125, 32);
		getContentPane().add(btnRegistrar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon("src/imagenes/editar.png"));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(295, 502, 125, 32);
		getContentPane().add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("src/imagenes/eliminar.png"));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(435, 502, 125, 32);
		getContentPane().add(btnEliminar);

		limpiarCampos();
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
	}

	// Se ejecuta al cambiar la fila seleccionada en la tabla
	public void valueChanged(ListSelectionEvent arg0) {
		if (tblLaptops.getSelectedRow() == -1) {
			limpiarCampos();
		}
		else {
			mostrarLaptop(tblLaptops.getSelectedRow());
		}
	}

	// Procesa la pulsación del botón Consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		// Declaración de variables
		int fila;

		// Entrada de datos y búsqueda
		fila = tienda.buscarFila(tienda.getModeloLaptops(), getTexto(txtBuscar));

		// Salida de resultados
		if (fila == -1) {
			mensaje("No existe una laptop con ese código");
		}
		else {
			seleccionar(fila);
		}
	}

	// Procesa la pulsación del botón Nuevo
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		tblLaptops.clearSelection();
		limpiarCampos();
		txtMarca.requestFocus();
	}

	// Procesa la pulsación del botón Registrar
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		if (datosValidos()) {
			tienda.registrarLaptop(
					getTexto(txtMarca), getTexto(txtModelo), getTexto(txtProcesador),
					getTexto(txtRam), getTexto(txtAlmacenamiento), getTexto(txtPantalla),
					getTexto(txtSistema), getPrecio(), getStock());
			seleccionar(tblLaptops.getRowCount() - 1);
			mensaje("Laptop registrada");
		}
	}

	// Procesa la pulsación del botón Actualizar
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		// Declaración de variables
		int fila;

		// Entrada de datos
		fila = tblLaptops.getSelectedRow();

		// Proceso y salida de resultados
		if (datosValidos()) {
			tienda.actualizarLaptop(fila,
					getTexto(txtMarca), getTexto(txtModelo), getTexto(txtProcesador),
					getTexto(txtRam), getTexto(txtAlmacenamiento), getTexto(txtPantalla),
					getTexto(txtSistema), getPrecio(), getStock());
			mostrarLaptop(fila);
			mensaje("Laptop actualizada");
		}
	}

	// Procesa la pulsación del botón Eliminar
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		// Declaración de variables
		int fila, respuesta;

		// Entrada de datos
		fila = tblLaptops.getSelectedRow();
		respuesta = JOptionPane.showConfirmDialog(this,
				"¿Eliminar la laptop " + tienda.getDatoLaptop(fila, 0) + "?",
				"Confirmar", JOptionPane.YES_NO_OPTION);

		// Proceso
		if (respuesta == JOptionPane.YES_OPTION) {
			tblLaptops.clearSelection();
			tienda.eliminarLaptop(fila);
		}
	}

	// Lee y retorna el texto de una caja sin espacios a los lados
	String getTexto(JTextField txt) {
		return txt.getText().trim();
	}

	// Lee y retorna el precio con dos decimales, o -1 si no es un número
	double getPrecio() {
		double pre;
		try {
			pre = Double.parseDouble(getTexto(txtPrecio));
			return Math.round(pre * 100) / 100.0;
		}
		catch (NumberFormatException e) {
			return -1;
		}
	}

	// Lee y retorna el stock, o -1 si no es un número entero
	int getStock() {
		try {
			return Integer.parseInt(getTexto(txtStock));
		}
		catch (NumberFormatException e) {
			return -1;
		}
	}

	// Retorna true si la caja de texto está vacía
	boolean estaVacio(JTextField txt) {
		return getTexto(txt).equals("");
	}

	// Retorna true si todos los datos son correctos
	// Si hay un error, muestra un mensaje y retorna false
	boolean datosValidos() {
		if (estaVacio(txtMarca) || estaVacio(txtModelo) || estaVacio(txtProcesador)
				|| estaVacio(txtRam) || estaVacio(txtAlmacenamiento) || estaVacio(txtPantalla)
				|| estaVacio(txtSistema) || estaVacio(txtPrecio) || estaVacio(txtStock)) {
			mensaje("Complete todos los campos");
			return false;
		}
		if (getPrecio() <= 0 || getPrecio() > 99999.99) {
			mensaje("El precio debe ser un número mayor que 0 y hasta 99999.99 (use punto decimal)");
			return false;
		}
		if (getStock() < 0 || getStock() > 9999) {
			mensaje("El stock debe ser un número entero de 0 a 9999");
			return false;
		}
		return true;
	}

	// Muestra en los campos la laptop de una fila
	void mostrarLaptop(int fila) {
		lblCodigo.setText("Laptop seleccionada: " + tienda.getDatoLaptop(fila, 0));
		txtMarca.setText(tienda.getDatoLaptop(fila, 1));
		txtModelo.setText(tienda.getDatoLaptop(fila, 2));
		txtProcesador.setText(tienda.getDatoLaptop(fila, 3));
		txtRam.setText(tienda.getDatoLaptop(fila, 4));
		txtAlmacenamiento.setText(tienda.getDatoLaptop(fila, 5));
		txtPantalla.setText(tienda.getDatoLaptop(fila, 6));
		txtSistema.setText(tienda.getDatoLaptop(fila, 7));
		txtPrecio.setText(tienda.getDatoLaptop(fila, 8));
		txtStock.setText(tienda.getDatoLaptop(fila, 9));
		habilitarBotones(true);
	}

	// Limpia los campos para ingresar una laptop nueva
	void limpiarCampos() {
		lblCodigo.setText("Nueva laptop (el código se genera al registrar)");
		txtMarca.setText("");
		txtModelo.setText("");
		txtProcesador.setText("");
		txtRam.setText("");
		txtAlmacenamiento.setText("");
		txtPantalla.setText("");
		txtSistema.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
		habilitarBotones(false);
	}

	// Con una laptop seleccionada se puede actualizar o eliminar; si no, registrar
	void habilitarBotones(boolean seleccionada) {
		btnRegistrar.setEnabled(!seleccionada);
		btnActualizar.setEnabled(seleccionada);
		btnEliminar.setEnabled(seleccionada);
	}

	// Selecciona una fila y desplaza la tabla hasta mostrarla
	void seleccionar(int fila) {
		tblLaptops.setRowSelectionInterval(fila, fila);
		tblLaptops.scrollRectToVisible(tblLaptops.getCellRect(fila, 0, true));
	}

	// Muestra un mensaje en una ventana emergente
	void mensaje(String cad) {
		JOptionPane.showMessageDialog(this, cad);
	}
}
