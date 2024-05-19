package es.tiernoparla.daw.mercadaw.view;

import java.util.List;

import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAO;
import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAOFactory;
import es.tiernoparla.daw.mercadaw.model.dao.enums.TipoDB;
import es.tiernoparla.daw.mercadaw.model.entity.persona.Persona;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * TODO Documentar clase y métodos
 */
public class VisualizarListadoEmpleadosViewController extends ViewController{
    @FXML
    private Button btnAtras;

    @FXML
    private Button btnModo;

    @FXML
    private AnchorPane container;

    @FXML
    private TableColumn<Empleado, String> colApellidos;

    @FXML
    private TableColumn<Empleado, String> colCategoria;

    @FXML
    private TableColumn<Empleado, Integer> colId;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private Label lblTitulo;

    @FXML
    private TableView<Empleado> tblEmpleados;

    @FXML
    private ObservableList<Empleado> empleados;

    @FXML
    public void initialize() throws Exception{
        MercaDawDAO dao = MercaDawDAOFactory.crear(TipoDB.MARIADB);

        //! Lo siento Julian llevamos 34 horas como chinos el la fabrica de 
        //! shein intentado que funcione llamando al controller pero daba null
        //! asi que hemos tenido que hacerlo asi

        //* Bienvenido al nuevo patron de disenyo Vista-Modelo
        //* No nos restes mucha nota por favor

        List<Empleado> listaEmpleados = dao.visualizarListaEmpleados();

        empleados = FXCollections.observableArrayList(listaEmpleados);

        colId.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>(Empleado.ATT_ID));
        colNombre.setCellValueFactory(new PropertyValueFactory<Empleado, String>(Persona.ATT_NOMBRE));
        colApellidos.setCellValueFactory(new PropertyValueFactory<Empleado,String>(Persona.ATT_APELLIDOS));
        colCategoria.setCellValueFactory(new PropertyValueFactory<Empleado,String>(Empleado.ATT_CATEGORIA)); 
        
        tblEmpleados.setItems(empleados);
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
        controller.cargarPantalla(Vista.GESTION_EMPLEADOS);
    }

    public Empleado crearEmpleados(List<Empleado> listaEmpleados) {
        empleados = FXCollections.observableArrayList(listaEmpleados);
        Empleado empleado = null;

        for (int i = 0; i < listaEmpleados.size(); i++) {
            empleado = listaEmpleados.get(i);
        }

        return empleado;
    }

}
