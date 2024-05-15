package es.tiernoparla.daw.mercadaw.view;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import es.tiernoparla.daw.mercadaw.utils.reader.Lector;
import es.tiernoparla.daw.mercadaw.utils.reader.LectorFactory;
import es.tiernoparla.daw.mercadaw.utils.reader.LectorImp;
import es.tiernoparla.daw.mercadaw.utils.reader.enumeracion.TipoLector;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class DarAltaProductoViewController extends ViewController {

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
    private Label lblAltura;

    @FXML
    private Label lblAnchura;

    @FXML
    private Label lblCategoria;

    @FXML
    private Label lblDescripcion;

    @FXML
    private Label lblMarca;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblNumElementos;

    @FXML
    private Label lblPeso;

    @FXML
    private Label lblPrecio;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextArea txaDescripcion;

    @FXML
    private TextField txfAltura;

    @FXML
    private TextField txfAnchura;

    @FXML
    private TextField txfCategoria;

    @FXML
    private TextField txfMarca;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfNumElementos;

    @FXML
    private TextField txfPeso;

    @FXML
    private TextField txfPrecio;

    @FXML
    public void initialize() {
        this.productos = FXCollections.observableArrayList(new ArrayList<>());
    }

    @FXML
    void darAltaProducto(MouseEvent event) {

        final String MSG_ERROR = "Error al dar de alta el producto";
        final String MSG_ERROR_PRODUCTO = "Ya exitse ese producto";
        final String MSG_EXITO = "Producto dado de alta correctamente";

        try {
            String nombre = txfNombre.getText();
            String marca = txfMarca.getText();
            String categoria = txfCategoria.getText();
            double precio = Double.parseDouble(txfPrecio.getText());
            double altura = Double.parseDouble(txfAltura.getText());
            double anchura = Double.parseDouble(txfAnchura.getText());
            double peso = Double.parseDouble(txfPeso.getText());
            int numElementos = Integer.parseInt(txfNumElementos.getText());
            String descripcion = txaDescripcion.getText();

            // if (this.productos.contains(producto)) {
            //     mostrarAviso(MSG_ERROR_PRODUCTO, AlertType.ERROR);
            // } else {
            //     //TODO insertar a lista
            //     //TODO insertar BBDD
            // }

        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    @FXML
    void darAltaVariosProductosCSV(MouseEvent event) {

        final String DESCRPICION_FILTRO = "Ficheros CSV";
        final String EXTENSION_FILTRO = "*.csv";
        final String MSG_ERROR = "Error al cargar el fichero CSV";

        ExtensionFilter filtro = new ExtensionFilter(DESCRPICION_FILTRO, EXTENSION_FILTRO);

        FileChooser fileChooser = new FileChooser();
        File fichero = fileChooser.showOpenDialog(new Stage());
        fileChooser.getExtensionFilters().add(filtro);

        if (fichero != null) {
            try (FileReader fr = new FileReader(fichero)) {
                String cadena = " ";
                int valor = fr.read();
                while (valor != -1) {
                    cadena += (char) valor;
                    valor = fr.read();
                }

                new LectorFactory();
                Lector lector = LectorFactory.obtenerLector(TipoLector.CSV);

                this.productos.addAll(lector.leerProducto(LectorImp.cargar(fichero)));
                //TODO

            } catch (Exception e) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            }
        }
    }

    @FXML
    void darAltaVariosProductosJSON(MouseEvent event) {
        final String DESCRPICION_FILTRO = "Ficheros JSON";
        final String EXTENSION_FILTRO = "*.json";
        final String MSG_ERROR = "Error al cargar el fichero JSON";

        ExtensionFilter filtro = new ExtensionFilter(DESCRPICION_FILTRO, EXTENSION_FILTRO);

        FileChooser fileChooser = new FileChooser();
        File fichero = fileChooser.showOpenDialog(new Stage());
        fileChooser.getExtensionFilters().add(filtro);

        if (fichero != null) {
            try (FileReader fr = new FileReader(fichero)) {
                String cadena = " ";
                int valor = fr.read();

                while (valor != -1) {
                    cadena += (char) valor;
                    valor = fr.read();
                }

                this.productos.addAll(new LectorFactory().obtenerLector(TipoLector.JSON).leerProducto(LectorImp.cargar(fichero)));

            } catch (Exception e) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            }
        }
    }

    @FXML
    void darAltaVariosProductosXML(MouseEvent event) {

    }

    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.GESTION_PRODUCTO);
    }

    @FXML
    void cambiarModo(MouseEvent event) {

        container.getStylesheets().clear();
        if (esClaro == false) {
            container.getStylesheets().add(getClass().getResource(ESTILO_CLARO).toExternalForm());
            esClaro = true;
        } else if (esClaro == true) {
            container.getStylesheets().add(getClass().getResource(ESTILO_OSCURO).toExternalForm());
            esClaro = false;
        }
    }
}
