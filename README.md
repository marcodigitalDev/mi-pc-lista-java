# Mi PC Lista

Sistema de escritorio en Java (Swing) para que los vendedores administren laptops y registren ventas.

## Qué hace

- **Productos:** tabla con las características, el precio y el stock de cada laptop. Permite consultar por código, registrar, actualizar y eliminar.
- **Ventas:** se elige una laptop de la tabla, se ingresan nombre, apellido, empresa (opcional) y cantidad, y se vende. Cada venta guarda esos datos, producto, precio unitario e importe total, y descuenta el stock. Permite consultar por número y eliminar; al eliminar una venta, las unidades vuelven al stock si la laptop sigue en el catálogo.

Los datos están en memoria y se pierden al cerrar el programa. Al iniciar hay cuatro laptops de ejemplo. Los códigos (`L001`, `V001`) se generan automáticamente.

## Cómo importarlo y ejecutarlo en Eclipse

Requiere Java 15 o superior.

1. Elija **File > Import > General > Existing Projects into Workspace**.
2. En **Select root directory**, elija la carpeta del proyecto.
3. Marque `mi-pc-lista-java` y pulse **Finish**.
4. Abra `src/app/MenuPrincipal.java`, haga clic derecho y elija **Run As > Java Application**.

## Clases

| Clase | Función |
|---|---|
| `MenuPrincipal` | Inicia el programa y abre las demás ventanas. |
| `VentanaProductos` | Muestra y administra las laptops. |
| `VentanaVentas` | Registra, muestra y elimina ventas. |
| `Tienda` | Guarda las filas de laptops y ventas en dos `DefaultTableModel`, que las tablas (`JTable`) muestran. |

Las ventanas de productos y ventas usan `JDialog` modal: hay que cerrar una para abrir la otra.

Las imágenes están en `src/imagenes`.
