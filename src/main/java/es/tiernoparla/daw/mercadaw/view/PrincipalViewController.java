package es.tiernoparla.daw.mercadaw.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * TODO Documentar clase y métodos
 */
public class PrincipalViewController extends ViewController {

    @FXML
    private Button btnEmpleados;

    @FXML
    private Button btnExportar;

    @FXML
    private Button btnModo;

    @FXML
    private Button btnProductos;

    @FXML
    private AnchorPane container;

    @FXML
    public void initialize() {
        
        container.getStylesheets().clear();

        if (esClaro == true){
            container.getStylesheets().add(PrincipalViewController.class.getResource(ESTILO_CLARO).toExternalForm());
        } else if (esClaro == false) {
            container.getStylesheets().add(PrincipalViewController.class.getResource(ESTILO_OSCURO).toExternalForm());
        }
    }

    @FXML
    void exportarDatos(MouseEvent event) {
        controller.exportarDatos();
    }

    @FXML
    void gestionarEmpleados(MouseEvent event) throws IOException {
        controller.cargarPantalla(Vista.GESTION_EMPLEADOS);
    }

    @FXML
    void gestionarProductos(MouseEvent event) throws IOException {
        controller.cargarPantalla(Vista.GESTION_PRODUCTO);
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

}
    