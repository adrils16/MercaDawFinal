package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class VisualizarListadoComprasViewController {
    
    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private Button btnMostrarListado;

    @FXML
    private AnchorPane container;

    @FXML
    private TableColumn<?, ?> colCodPostal;

    @FXML
    private TableColumn<?, ?> colCompras;

    @FXML
    private Label lblTitulo;

    @FXML
    private TableView<?> tblListadoCompras;

    @FXML
    void cambiarModo(MouseEvent event) {

    }

    @FXML
    void mostrarListado(MouseEvent event) {

    }

    @FXML
    void volverAtras(MouseEvent event) {

    }
}
