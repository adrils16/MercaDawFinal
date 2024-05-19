package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ObtenerPrecioVentaProductoViewController extends ViewController{

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private AnchorPane container;

    @FXML
    private Label lblIdProducto;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextArea txaPrecioVenta;

    @FXML
    private TextField txfIdProducto;

    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.GESTION_PRODUCTO);       
    }

    @FXML
    void initialize(){
        txaPrecioVenta.setEditable(false);
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
    void obtenerPrecioVenta(MouseEvent event) {
        final String MSG_ERROR = "No se ha podido encontrar el producto";
        try {
            int idProducto = Integer.parseInt(txfIdProducto.getText())-1;
            txaPrecioVenta.setText(controller.visualizarPrecioProducto(idProducto));

        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }
}
