package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class VisualizarDatosProductoViewController extends ViewController{
    
    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private Button btnVisualizarDatos;

    @FXML
    private AnchorPane container;

    @FXML
    private Label lblIdProducto;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txfIdProducto;

    @FXML
    private TextArea txaDatosProducto;

    @FXML
    void initialize() {
        txaDatosProducto.setEditable(false);
    }

    @FXML
    void cambiarModo(MouseEvent event) {
        container.getStylesheets().clear();
        if ( esClaro == false ) {
            container.getStylesheets().add(getClass().getResource(ESTILO_CLARO).toExternalForm());
            esClaro = true;
        } else if( esClaro == true) {
            container.getStylesheets().add(getClass().getResource(ESTILO_OSCURO).toExternalForm());
            esClaro = false;
        }
    }

    @FXML
    void visualizarDatosProducto(MouseEvent event) {

        String MSG_ERROR = "No existe el producto con ese ID";

        try {

            int id = Integer.parseInt(txfIdProducto.getText());

            txaDatosProducto.setText(controller.visualizarDatosProducto(id));
            
        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
        
    }

    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.GESTION_PRODUCTO);
    }
}
