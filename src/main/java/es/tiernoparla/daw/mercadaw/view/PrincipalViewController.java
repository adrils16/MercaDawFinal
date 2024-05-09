package es.tiernoparla.daw.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PrincipalViewController extends ViewController {

    public static int contador;

    @FXML
    private Button btnCompras;

    @FXML
    private Button btnEmpleados;

    @FXML
    private Button btnExportar;

    @FXML
    private Button btnImportar;

    @FXML
    private Button btnModo;

    @FXML
    private Button btnProductos;

    @FXML
    private AnchorPane container;

    @FXML
    public void initialize() {
        
        container.getStylesheets().clear();
        container.getStylesheets().add(PrincipalViewController.class.getResource("estiloClaroFinal.css").toExternalForm());
        
    }

    @FXML
    void exportarDatos(MouseEvent event) {

    }

    @FXML
    void gestinarCompras(MouseEvent event) {

    }

    @FXML
    void gestionarEmpleados(MouseEvent event) {

    }

    @FXML
    void gestionarProductos(MouseEvent event) {

    }

    @FXML
    void importarDatos(MouseEvent event) {

    }

    @FXML
    void cambiarModo(MouseEvent event) {

        contador++;

        container.getStylesheets().clear();
        if (contador%2==0) {
            container.getStylesheets().add(getClass().getResource("estiloClaroFinal.css").toExternalForm());
        } else if(contador%2!=0) {
            container.getStylesheets().add(getClass().getResource("estiloOscuro.css").toExternalForm());
        }
    }

}
    