package app;

import java.util.Locale;
import javax.swing.table.DefaultTableModel;

// Cada modelo contiene las filas y columnas que muestra una tabla (JTable)
public class Tienda {

	private DefaultTableModel modeloLaptops;
	private DefaultTableModel modeloVentas;
	private int numeroLaptop;
	private int numeroVenta;

	public Tienda() {
		numeroLaptop = 0;
		numeroVenta = 0;

		modeloLaptops = new DefaultTableModel();
		modeloLaptops.addColumn("Código");
		modeloLaptops.addColumn("Marca");
		modeloLaptops.addColumn("Modelo");
		modeloLaptops.addColumn("Procesador");
		modeloLaptops.addColumn("RAM");
		modeloLaptops.addColumn("Almacenamiento");
		modeloLaptops.addColumn("Pantalla");
		modeloLaptops.addColumn("Sistema");
		modeloLaptops.addColumn("Precio S/.");
		modeloLaptops.addColumn("Stock");

		modeloVentas = new DefaultTableModel();
		modeloVentas.addColumn("N° venta");
		modeloVentas.addColumn("Código");
		modeloVentas.addColumn("Producto");
		modeloVentas.addColumn("Nombre");
		modeloVentas.addColumn("Apellido");
		modeloVentas.addColumn("Empresa");
		modeloVentas.addColumn("Cantidad");
		modeloVentas.addColumn("Precio unit. S/.");
		modeloVentas.addColumn("Importe total S/.");

		registrarLaptop("Lenovo", "IdeaPad 3", "Intel Core i5", "8 GB", "512 GB SSD",
				"15.6\"", "Windows 11", 2199.90, 8);
		registrarLaptop("HP", "ProBook 440", "Intel Core i7", "16 GB", "512 GB SSD",
				"14\"", "Windows 11 Pro", 3899.00, 5);
		registrarLaptop("Asus", "VivoBook 15", "AMD Ryzen 5", "8 GB", "256 GB SSD",
				"15.6\"", "Windows 11", 1899.50, 3);
		registrarLaptop("Dell", "Latitude 3440", "Intel Core i5", "16 GB", "512 GB SSD",
				"14\"", "Windows 11 Pro", 3299.00, 4);
	}

	public DefaultTableModel getModeloLaptops() {
		return modeloLaptops;
	}

	public DefaultTableModel getModeloVentas() {
		return modeloVentas;
	}

	public void registrarLaptop(String mar, String mod, String pro, String ram, String alm,
			String pan, String sis, double pre, int sto) {
		numeroLaptop++;
		modeloLaptops.addRow(new Object[] { String.format("L%03d", numeroLaptop),
				mar, mod, pro, ram, alm, pan, sis, formatear(pre), sto });
	}

	// El código no cambia al actualizar
	public void actualizarLaptop(int fila, String mar, String mod, String pro, String ram,
			String alm, String pan, String sis, double pre, int sto) {
		modeloLaptops.setValueAt(mar, fila, 1);
		modeloLaptops.setValueAt(mod, fila, 2);
		modeloLaptops.setValueAt(pro, fila, 3);
		modeloLaptops.setValueAt(ram, fila, 4);
		modeloLaptops.setValueAt(alm, fila, 5);
		modeloLaptops.setValueAt(pan, fila, 6);
		modeloLaptops.setValueAt(sis, fila, 7);
		modeloLaptops.setValueAt(formatear(pre), fila, 8);
		modeloLaptops.setValueAt(sto, fila, 9);
	}

	// Las ventas realizadas se conservan
	public void eliminarLaptop(int fila) {
		modeloLaptops.removeRow(fila);
	}

	public String getDatoLaptop(int fila, int columna) {
		return modeloLaptops.getValueAt(fila, columna).toString();
	}

	public double getPrecio(int fila) {
		return Double.parseDouble(getDatoLaptop(fila, 8));
	}

	public int getStock(int fila) {
		return Integer.parseInt(getDatoLaptop(fila, 9));
	}

	public double calcularImporte(int can, double pre) {
		return can * pre;
	}

	// La venta guarda una copia del producto y del precio del momento
	public void registrarVenta(int fila, String nom, String ape, String emp, int can) {
		double precio, importe;
		precio = getPrecio(fila);
		importe = calcularImporte(can, precio);
		numeroVenta++;
		modeloVentas.addRow(new Object[] { String.format("V%03d", numeroVenta),
				getDatoLaptop(fila, 0),
				getDatoLaptop(fila, 1) + " " + getDatoLaptop(fila, 2),
				nom, ape, emp, can, formatear(precio), formatear(importe) });
		modeloLaptops.setValueAt(getStock(fila) - can, fila, 9);
	}

	// Si la laptop ya no existe en el catálogo, no hay stock que devolver
	public void eliminarVenta(int fila) {
		String codigo;
		int cantidad, filaLaptop;
		codigo = modeloVentas.getValueAt(fila, 1).toString();
		cantidad = Integer.parseInt(modeloVentas.getValueAt(fila, 6).toString());
		filaLaptop = buscarFila(modeloLaptops, codigo);
		if (filaLaptop != -1) {
			modeloLaptops.setValueAt(getStock(filaLaptop) + cantidad, filaLaptop, 9);
		}
		modeloVentas.removeRow(fila);
	}

	// Busca un código en la primera columna y retorna su fila, o -1 si no existe
	public int buscarFila(DefaultTableModel modelo, String codigo) {
		for (int i = 0; i < modelo.getRowCount(); i++) {
			if (modelo.getValueAt(i, 0).toString().equalsIgnoreCase(codigo)) {
				return i;
			}
		}
		return -1;
	}
	// Indica si la laptop de la fila coincide con el código y, si se filtra por
	// precio, si está dentro del presupuesto y tiene stock disponible
	public boolean coincideBusqueda(int fila, String codigo, double minimo, double maximo,
			boolean filtrarPrecio) {
		boolean coincideCodigo, coincidePrecio;
		double precio;

		coincideCodigo = codigo.isEmpty() || getDatoLaptop(fila, 0).equalsIgnoreCase(codigo);
		precio = getPrecio(fila);
		coincidePrecio = !filtrarPrecio
				|| (precio >= minimo && precio <= maximo && getStock(fila) > 0);
		return coincideCodigo && coincidePrecio;
	}

	// Locale.US asegura el punto decimal en cualquier computadora
	public String formatear(double monto) {
		return String.format(Locale.US, "%.2f", monto);
	}
}
