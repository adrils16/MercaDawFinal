package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class VisualizarDatosProductoViewController {
    
    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private Button btnMostrarProductos;

    @FXML
    private Button btnVisualizarDatos;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private AnchorPane container;

    @FXML
    private Label lblIdProducto;

    @FXML
    private Label lblTitulo;

    @FXML
    private TableView<?> tblProductos;

    @FXML
    private TextField txfIdProducto;

    @FXML
    void cambiarModo(MouseEvent event) {

    }

    @FXML
    void mostrarProductos(MouseEvent event) {

    }

    @FXML
    void visualizarDatosProducto(MouseEvent event) {

    }

    @FXML
    void volverAtras(MouseEvent event) {

    }
}
