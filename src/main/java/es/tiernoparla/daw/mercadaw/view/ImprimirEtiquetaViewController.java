package es.tiernoparla.daw.mercadaw.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAO;
import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAOFactory;
import es.tiernoparla.daw.mercadaw.model.dao.enums.TipoDB;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    public void initialize() throws Exception{
        MercaDawDAO dao = MercaDawDAOFactory.crear(TipoDB.MARIADB);

        List<Producto> listaProductos = dao.visualizarListaProductos();

        productos = FXCollections.observableArrayList(listaProductos);

        colId.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));

        tblProductos.setItems(productos);
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
    void imprimirEtiqueta(MouseEvent event) throws SQLException, IOException{

        int id = Integer.parseInt(txfIdProducto.getText())-1;

        controller.imprimirEtiqueta(id);
    }

    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.GESTION_PRODUCTO);
    }
}
