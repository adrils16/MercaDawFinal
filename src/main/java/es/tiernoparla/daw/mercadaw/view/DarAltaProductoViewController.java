package es.tiernoparla.daw.mercadaw.view;

import java.io.File;
import java.io.FileReader;

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

/**
 * Clase controladora de la vista DarAltaProducto
 * donde se pueden dar de alta productos de forma individual o a partir de un fichero CSV o JSON
 */
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

    /**
     * Da de alta un Producto en la BD y lo inserta en la lista de Sede, a partir de los datos introducidos por el usuario.
     * @param event
     */
    @FXML
    void darAltaProducto(MouseEvent event) {

        final String MSG_ERROR = "Categoría no válida o campos incorrectos";
        final String MSG_EXITO = "Producto dado de alta correctamente";
        final String MSG_ERROR_CAMPOS = "Rellene todos los campos, por favor";

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


            if (camposRellenos()){

                controller.darAltaProducto(categoria, nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);

                mostrarAviso(MSG_EXITO, AlertType.CONFIRMATION);
                
            } else {

                mostrarAviso(MSG_ERROR_CAMPOS, AlertType.ERROR);

            }

        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    /**
     * Da de alta varios productos a partir de un fichero CSV
     * @param event
     */
    @FXML
    void darAltaVariosProductosCSV(MouseEvent event) {

        final String DESCRPICION_FILTRO = "Ficheros CSV";
        final String EXTENSION_FILTRO = "*.csv";
        final String MSG_ERROR = "Error al cargar el fichero CSV";
        final String MSG_EXITO = "Productos dados de alta correctamente";

        ExtensionFilter filtro = new ExtensionFilter(DESCRPICION_FILTRO, EXTENSION_FILTRO);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(filtro);
        File fichero = fileChooser.showOpenDialog(new Stage());

        if (fichero != null) {
            try (FileReader fr = new FileReader(fichero)) {
                int valor = fr.read();
                while (valor != -1) {
                    valor = fr.read();
                }

                controller.darAltaVariosProductosCSV(fichero);
                mostrarAviso(MSG_EXITO, AlertType.CONFIRMATION);

            } catch (Exception e) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            }
        }
    }

    /**
     * Da de alta varios productos a partir de un fichero JSON
     * !no funciona
     * @param event
     */
    @FXML
    void darAltaVariosProductosJSON(MouseEvent event) {
        final String DESCRPICION_FILTRO = "Ficheros JSON";
        final String EXTENSION_FILTRO = "*.json";
        final String MSG_ERROR = "Error al cargar el fichero JSON";

        ExtensionFilter filtro = new ExtensionFilter(DESCRPICION_FILTRO, EXTENSION_FILTRO);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(filtro);
        File fichero = fileChooser.showOpenDialog(new Stage());

        if (fichero != null) {
            try (FileReader fr = new FileReader(fichero)) {
                int valor = fr.read();

                while (valor != -1) {
                    valor = fr.read();
                }

                controller.darAltaVariosProductosJSON(fichero);

            } catch (Exception e) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            }
        }
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

    /**
     * Comprueba si los campos están rellenos
     * @return true si todos los campos están rellenos, false en caso contrario
     */
    private boolean camposRellenos() {
        return campoRelleno(txfNombre) && campoRelleno(txfMarca) && campoRelleno(txfCategoria) && campoRelleno(txfPrecio)
                && campoRelleno(txfAltura) && campoRelleno(txfAnchura) && campoRelleno(txfPeso)
                && campoRelleno(txfNumElementos) && areaRellena(txaDescripcion);
    }
}
