package es.tiernoparla.daw.mercadaw.view;

import java.util.Map;

import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MostrarStockProductosViewController extends ViewController{
    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Integer> colStock;

    @FXML
    private AnchorPane container;

    @FXML
    private Label lblTitulo;

    @FXML
    private TableView<Producto> tblStock;

    private ObservableMap <String,Integer> stock;

    @FXML
    void initialize(){
        
        stock = FXCollections.observableHashMap();
        
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

    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.GESTION_PRODUCTO);
    }

}
