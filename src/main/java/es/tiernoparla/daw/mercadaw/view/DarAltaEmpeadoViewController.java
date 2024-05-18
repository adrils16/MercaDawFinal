package es.tiernoparla.daw.mercadaw.view;

import java.io.File;
import java.io.FileReader;

import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAO;
import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAOFactory;
import es.tiernoparla.daw.mercadaw.model.dao.enums.TipoDB;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.utils.reader.Lector;
import es.tiernoparla.daw.mercadaw.utils.reader.LectorFactory;
import es.tiernoparla.daw.mercadaw.utils.reader.enumeracion.TipoLector;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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

    // @FXML
    // public void initialize() {
    //     this.empleados = FXCollections.observableArrayList();
    // }

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
    void darAltaEmpleado(MouseEvent event) {

        final String MSG_ERROR = "Error al dar de alta el empleado";
        final String MSG_ERROR_EMPLEADO = "Ya exitse ese empleado";
        final String MSG_EXITO = "Empleado dado de alta correctamente";
        final String MSG_ERROR_CAMPOS = "Rellene todos los campos, por favor";
    
        Empleado empleado = null;

        try {
            String nombre = txfNombre.getText();
            String apellidos = txfApellidos.getText();
            CategoriaEmpleado categoria = CategoriaEmpleado.valueOf(txfCategoria.getText().toUpperCase());
            
            empleado = EmpleadoFactory.crear(categoria, nombre, apellidos, 0);
            if (mercadaw.getEmpleados().contains(empleado)) {
                mostrarAviso(MSG_ERROR_EMPLEADO, AlertType.ERROR);
            } else if (camposRellenos()){
                
                mercadaw.darAlta(empleado);
                dao.insertar(empleado);

                mostrarAviso(MSG_EXITO, AlertType.CONFIRMATION);
            } else {
                mostrarAviso(MSG_ERROR_CAMPOS, AlertType.ERROR);
            }

        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }   


    }

    @FXML
    void darAltaVariosEmpleadosCSV(MouseEvent event) {
        final String DESCRPICION_FILTRO = "Ficheros CSV";
        final String EXTENSION_FILTRO = "*.csv";
        final String MSG_ERROR = "Error al cargar el fichero CSV";

        ExtensionFilter filtro = new ExtensionFilter(DESCRPICION_FILTRO, EXTENSION_FILTRO);

        Lector lector = LectorFactory.obtenerLector(TipoLector.CSV);
        MercaDawDAO dao = MercaDawDAOFactory.crear(TipoDB.MARIADB);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(filtro);
        File fichero = fileChooser.showOpenDialog(new Stage());

        if (fichero != null) {
            try (FileReader fr = new FileReader(fichero)){
                int valor = fr.read();

                while (valor != -1) {
                    valor = fr.read();
                }

                mercadaw.darAlta(lector.leerEmpleado(lector.cargar(fichero)));
                dao.insertarEmpleados(mercadaw.getEmpleados());

            } catch (Exception e) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            }
        }
    }

    @FXML
    void darAltaVariosEmpleadosJSON(MouseEvent event) {
        final String DESCRPICION_FILTRO = "Ficheros JSON";
        final String EXTENSION_FILTRO = "*.json";
        final String MSG_ERROR = "Error al cargar el fichero JSON";

        ExtensionFilter filtro = new ExtensionFilter(DESCRPICION_FILTRO, EXTENSION_FILTRO);

        Lector lector = LectorFactory.obtenerLector(TipoLector.JSON);
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(filtro);
        File fichero = fileChooser.showOpenDialog(new Stage());

        if (fichero != null) {
            try (FileReader fr = new FileReader(fichero)){
                int valor = fr.read();

                while (valor != -1) {
                    valor = fr.read();
                }

                mercadaw.darAlta(lector.leerEmpleado(lector.cargar(fichero)));
                dao.insertarEmpleados(mercadaw.getEmpleados());

            } catch (Exception e) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            }
        }
    }
    
    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.GESTION_EMPLEADOS);
    }

    private boolean camposRellenos() {
        return campoRelleno(txfNombre) && campoRelleno(txfApellidos) && campoRelleno(txfCategoria);
    }
}
