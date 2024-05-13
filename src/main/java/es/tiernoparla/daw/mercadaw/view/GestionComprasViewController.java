package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GestionComprasViewController extends ViewController{

    @FXML
    private Button btnAltaCompra;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnDatosCompra;

    @FXML
    private AnchorPane container;

    @FXML
    private Label lblTitulo;

    @FXML
    private Button btnModo;

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
    void darAltaCompra(MouseEvent event) {
        controller.cargarPantalla(Vista.DAR_ALTA_COMPRA);
    }

    @FXML
    void visualizarCompras(MouseEvent event) {
        controller.cargarPantalla(Vista.VISUALIZAR_LISTADO_COMPRAS);
    }

}