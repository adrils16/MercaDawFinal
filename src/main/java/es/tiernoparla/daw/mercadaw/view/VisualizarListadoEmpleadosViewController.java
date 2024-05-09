package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class VisualizarListadoEmpleadosViewController extends ViewController{
    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private Button btnMostrar;

    @FXML
    private AnchorPane container;

    @FXML
    private TableColumn<?, ?> colApellidos;

    @FXML
    private TableColumn<?, ?> colCategoria;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private Label lblTitulo;

    @FXML
    private TableView<?> tblEmpleados;

    @FXML
    void cambiarModo(MouseEvent event) {

    }

    @FXML
    void mostrarEmpleados(MouseEvent event) {

    }

    @FXML
    void volverAtras(MouseEvent event) {

    }

}
