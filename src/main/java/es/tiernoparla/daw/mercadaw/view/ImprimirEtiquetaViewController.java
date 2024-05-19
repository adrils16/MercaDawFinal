package es.tiernoparla.daw.mercadaw.view;

import java.io.IOException;
import java.sql.SQLException;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Clase que representa el funcionamiento de la vista encargada de imprimir una etiqueta de un determinado Producto.
 */
public class ImprimirEtiquetaViewController extends ViewController{
    
    @FXML
    private Button btnAtras;

    @FXML
    private Button btnImprimirEtiqueta;

    @FXML
    private Button btnModo;

    @FXML
    private AnchorPane container;

    @FXML
    private TableColumn<Producto, Integer> colId;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private Label lblIdProducto;

    @FXML
    private Label lblTitulo;

    @FXML
    private TableView<Producto> tblProductos;

    @FXML
    private TextField txfIdProducto;

    @FXML
    private ObservableList<Producto> productos;

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

    /**
     * Imprime una etiqueta dado un id de producto
     * @param event Click en el botón de imprimir etiqueta
     * @throws SQLException
     * @throws IOException
     */
    @FXML
    void imprimirEtiqueta(MouseEvent event) throws SQLException, IOException{

        final String MSG_EXITO = "Etiqueta impresa con éxito";

        int id = Integer.parseInt(txfIdProducto.getText())-1;
        controller.imprimirEtiqueta(id);
        controller.exportarEtiquetaPDF();

        mostrarAviso(MSG_EXITO, AlertType.INFORMATION);
    }

    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.GESTION_PRODUCTO);
    }
}
