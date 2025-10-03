package co.edu.uniquindio.fx10.controlador;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controlador para el Dashboard principal
 */
public class DashboardController {

    public void abrirListadoProducto() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/fx10/vista/ListadoProducto.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Listado de Productos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void abrirFormularioProducto() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/fx10/vista/FormularioProducto.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Formulario Producto");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

