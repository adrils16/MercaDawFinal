package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GestionProductoViewController extends ViewController{

    @FXML
    private Button btnAltaProducto;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnDatosProducto;

    @FXML
    private Button btnImprimirEtiqueta;

    @FXML
    private Button btnPrecioVenta;

    @FXML
    private Button btnStock;

    @FXML
    private Button btnModo;

    @FXML
    private Label lblTitulo;

    @FXML
    private AnchorPane container;

    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.INICIO);
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
    void darAltaProducto(MouseEvent event) {
        controller.cargarPantalla(Vista.DAR_ALTA_PRODUCTO);

    }

    @FXML
    void imprimirEtiqueta(MouseEvent event) {
        controller.cargarPantalla(Vista.IMPRIMIR__ETIQUETA);

    }

    @FXML
    void obtenerPrecioVenta(MouseEvent event) {
        controller.cargarPantalla(Vista.PRECIO_VENTA);
    }

    @FXML
    void visualizarDatosProducto(MouseEvent event) {
        controller.cargarPantalla(Vista.VISUALIZAR_DATOS_PRODUCTO);

    }

}
