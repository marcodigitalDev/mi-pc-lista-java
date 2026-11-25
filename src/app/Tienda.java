package app;

import java.util.Locale;
import javax.swing.table.DefaultTableModel;

// Guarda en memoria las laptops y las ventas de la tienda
// Cada modelo contiene las filas y columnas que muestra una tabla (JTable)
public class Tienda {

	// Declaración de variables
	private DefaultTableModel modeloLaptops;
	private DefaultTableModel modeloVentas;
	private int numeroLaptop;
	private int numeroVenta;

	// Crea la tienda con cuatro laptops de ejemplo
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

	// Retorna el modelo de la tabla de laptops
	public DefaultTableModel getModeloLaptops() {
		return modeloLaptops;
	}

	// Retorna el modelo de la tabla de ventas
	public DefaultTableModel getModeloVentas() {
		return modeloVentas;
	}

	// Agrega una laptop al final de la tabla con un código automático
	public void registrarLaptop(String mar, String mod, String pro, String ram, String alm,
			String pan, String sis, double pre, int sto) {
		numeroLaptop++;
		modeloLaptops.addRow(new Object[] { String.format("L%03d", numeroLaptop),
				mar, mod, pro, ram, alm, pan, sis, formatear(pre), sto });
	}

	// Cambia los datos de la laptop de una fila; el código no cambia
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

	// Elimina la laptop de una fila; las ventas realizadas se conservan
	public void eliminarLaptop(int fila) {
		modeloLaptops.removeRow(fila);
	}

	// Retorna un dato de la laptop de una fila como texto
	public String getDatoLaptop(int fila, int columna) {
		return modeloLaptops.getValueAt(fila, columna).toString();
	}

	// Retorna el precio de la laptop de una fila
	public double getPrecio(int fila) {
		return Double.parseDouble(getDatoLaptop(fila, 8));
	}

	// Retorna el stock de la laptop de una fila
	public int getStock(int fila) {
		return Integer.parseInt(getDatoLaptop(fila, 9));
	}

	// Calcula y retorna el importe total de una venta
	public double calcularImporte(int can, double pre) {
		return can * pre;
	}

	// Agrega una venta y descuenta el stock de la laptop
	// La venta guarda una copia del producto y del precio del momento
	public void registrarVenta(int fila, int can) {
		double precio, importe;
		precio = getPrecio(fila);
		importe = calcularImporte(can, precio);
		numeroVenta++;
		modeloVentas.addRow(new Object[] { String.format("V%03d", numeroVenta),
				getDatoLaptop(fila, 0),
				getDatoLaptop(fila, 1) + " " + getDatoLaptop(fila, 2),
				can, formatear(precio), formatear(importe) });
		modeloLaptops.setValueAt(getStock(fila) - can, fila, 9);
	}

	// Elimina la venta de una fila y devuelve las unidades al stock
	// Si la laptop ya no existe en el catálogo, no hay stock que devolver
	public void eliminarVenta(int fila) {
		String codigo;
		int cantidad, filaLaptop;
		codigo = modeloVentas.getValueAt(fila, 1).toString();
		cantidad = Integer.parseInt(modeloVentas.getValueAt(fila, 3).toString());
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

	// Retorna un monto como texto con dos decimales
	// Locale.US asegura el punto decimal en cualquier computadora
	public String formatear(double monto) {
		return String.format(Locale.US, "%.2f", monto);
	}
}
