package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class DarAltaEmpeadoViewController extends ViewController{
    
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private Button btnCSV;

    @FXML
    private Button btnJSON;

    @FXML
    private Button btnXML;

    @FXML
    private AnchorPane container;

    @FXML
    private GridPane gridContainer;

    @FXML
    private Label lblApellidos;

    @FXML
    private Label lblCategoria;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txfApellidos;

    @FXML
    private TextField txfCategoria;

    @FXML
    private TextField txfNombre;

    @FXML
    void cambiarModo(MouseEvent event) {

    }

    @FXML
    void darAltaEmpleado(MouseEvent event) {

    }

    @FXML
    void darAltaVariosEmpleadosCSV(MouseEvent event) {

    }

    @FXML
    void darAltaVariosEmpleadosJSON(MouseEvent event) {

    }

    @FXML
    void darAltaVariosEmpleadosXML(MouseEvent event) {

    }
    
    @FXML
    void volverAtras(MouseEvent event) {

    }
}
