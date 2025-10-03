package co.edu.uniquindio.fx10.repositorio;

import co.edu.uniquindio.fx10.modelo.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Repositorio centralizado para gestionar los productos
 * Singleton para garantizar una única instancia en toda la aplicación
 */
public class RepositorioProducto {

        private static RepositorioProducto instancia; // Singleton
        private final ObservableList<Producto> productos;

        private RepositorioProducto() {
            productos = FXCollections.observableArrayList();
            productos.add(new Producto("P001", "Portátil", "Computador portátil Lenovo", 3500000, 5));
            productos.add(new Producto("P002", "Celular", "Samsung Galaxy A54", 1800000, 10));
            productos.add(new Producto("P003", "Mouse", "Mouse inalámbrico Logitech", 120000, 25));
        }

        public static RepositorioProducto getInstancia() {
            if (instancia == null) {
                instancia = new RepositorioProducto();
            }
            return instancia;
        }

         public ObservableList<Producto> getProductos() {
            return productos;
    }

        public void agregarProducto(Producto producto) {
            productos.add(producto);
        }

    public void actualizarProducto(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(producto.getCodigo())) {
                productos.set(i, producto); // 🔹 reemplaza el producto en la lista
                break;
            }
        }
    }
}

