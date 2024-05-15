package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class DarAltaCompraViewController extends ViewController{
    
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private AnchorPane container;

    @FXML
    private GridPane gridContainer;

    @FXML
    private Label lblCodPostal;

    @FXML
    private Label lblIdProducto;

    @FXML
    private Label lblNombreCliente;

    @FXML
    private Label lblNumProductos;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txfCodPostal;

    @FXML
    private TextField txfIdProducto;

    @FXML
    private TextField txfNombreCliente;

    @FXML
    private TextField txfNumProductos;

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

        final String ERROR = "Error al dar de alta la compra";

        try {
            String nombreCliente = txfNombreCliente.getText();
            String codPostal = txfCodPostal.getText();
            int idProducto = Integer.parseInt(txfIdProducto.getText());
            int numProductos = Integer.parseInt(txfNumProductos.getText());

            //TODO falta implementar alta compra en BBDD

        } catch (Exception e) {
            mostrarAviso(ERROR, AlertType.ERROR);
        }
    }

    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.GESTION_COMPRAS);
    }

}
