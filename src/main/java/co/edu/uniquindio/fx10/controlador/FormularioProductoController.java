package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.modelo.Producto;
import co.edu.uniquindio.fx10.repositorio.RepositorioProducto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador para el formulario de creación de productos
 */
public class FormularioProductoController {

    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtStock;

    private final RepositorioProducto repo = RepositorioProducto.getInstancia();
    private Producto producto;

    public void setProducto(Producto producto) {
        this.producto = producto;
        if (producto != null) {
            txtCodigo.setText(producto.getCodigo());
            txtCodigo.setDisable(true); // 🔹 No dejar editar código
            txtNombre.setText(producto.getNombre());
            txtDescripcion.setText(producto.getDescripcion());
            txtPrecio.setText(String.valueOf(producto.getPrecio()));
            txtStock.setText(String.valueOf(producto.getStock()));
        }
    }

    @FXML
    public void guardarProducto() {
        try {
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());

            if (producto == null) {
                // 🔹 Nuevo producto
                producto = new Producto(codigo, nombre, descripcion, precio, stock);
                repo.agregarProducto(producto);
            } else {
                // 🔹 Actualizar existente
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setPrecio(precio);
                producto.setStock(stock);
                repo.actualizarProducto(producto);
            }

            mostrarAlerta("Éxito", "Producto guardado correctamente");

            // 🔹 Cierra la ventana
            Stage stage = (Stage) txtCodigo.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}