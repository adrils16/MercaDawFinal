package es.tiernoparla.daw.mercadaw.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Clase controladora de la vista Principal
 * donde se pueden gestionar empleados y productos y exportar datos de la base de datos
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

    /**
     * Método que se ejecuta al pulsar el botón de exportar datos
     * y exporta los datos de la base de datos a un fichero CSV
     * @param event 
     */
    @FXML
    void exportarDatos(MouseEvent event) {
        controller.exportarDatos();
    }

    /**
     * Método que se ejecuta al pulsar el botón de gestionar empleados
     * y carga la pantalla de gestión de empleados
     * @param event 
     */
    @FXML
    void gestionarEmpleados(MouseEvent event) throws IOException {
        controller.cargarPantalla(Vista.GESTION_EMPLEADOS);
    }

    /**
     * Método que se ejecuta al pulsar el botón de gestionar productos
     * y carga la pantalla de gestión de productos
     * @param event 
     */
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
    