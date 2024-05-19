package es.tiernoparla.daw.mercadaw.view;

import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAO;
import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAOFactory;
import es.tiernoparla.daw.mercadaw.model.dao.enums.TipoDB;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class VisualizarDatosProductoViewController extends ViewController{
    
    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private Button btnVisualizarDatos;

    @FXML
    private AnchorPane container;

    @FXML
    private Label lblIdProducto;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txfIdProducto;

   @FXML
   private TextArea txaDatosProducto;

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
    void visualizarDatosProducto(MouseEvent event) {

        String MSG_ERROR = "No existe el producto con ese ID";

        MercaDawDAO dao = MercaDawDAOFactory.crear(TipoDB.MARIADB);

        try {

            int id = Integer.parseInt(txfIdProducto.getText())-1;

            txaDatosProducto.setText(controller.visualizarDatosProducto(id));
            
        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
        
    }

    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.GESTION_PRODUCTO);
    }
}
