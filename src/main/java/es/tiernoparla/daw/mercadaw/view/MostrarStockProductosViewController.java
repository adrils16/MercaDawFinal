package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MostrarStockProductosViewController {
    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private Button btnMostrar;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colStock;

    @FXML
    private AnchorPane container;

    @FXML
    private Label lblTitulo;

    @FXML
    private TableView<?> tblStock;

    @FXML
    void cambiarModo(MouseEvent event) {

    }

    @FXML
    void volverAtras(MouseEvent event) {

    }

    @FXML
    void mostrarStock(MouseEvent event) {

    }
}
