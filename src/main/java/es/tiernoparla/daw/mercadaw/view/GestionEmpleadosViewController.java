package es.tiernoparla.daw.mercadaw.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import es.tiernoparla.daw.mercadaw.utils.writer.MarkdownUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * TODO Documentar clase
 */
public class GestionEmpleadosViewController extends ViewController{

    @FXML
    private Button btnAltaEmpleado;

    @FXML
    private Button btnCalculoNomina;

    @FXML
    private Button btnListadoEmpleados;

    @FXML
    private Button btnModo;

    @FXML
    private Button btnAtras;

    @FXML
    private AnchorPane container;

    @FXML
    private Label lblTitulo;

    @FXML
    void volverAtras(MouseEvent event) {
        controller.cargarPantalla(Vista.INICIO);
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

    @FXML
    void calcularNominas(MouseEvent event) throws SQLException, IOException {
        final String MSG_NOMINAS = "Las nominas se han creado correctamente en un ficero Markdown.";

        List<String> nominas = controller.calcularNominas();
        for (String nomina : nominas) {
            MarkdownUtil.crearNominaMd(nomina); // Almacenar en el fichero Markdown
        }

        mostrarAviso(MSG_NOMINAS, AlertType.INFORMATION);

    }

    @FXML
    void darAltaEmpleado(MouseEvent event) {
        controller.cargarPantalla(Vista.DAR_ALTA_EMPLEADO);
    }

    @FXML
    void visualizarEmpleados(MouseEvent event) throws Exception {

        controller.cargarPantalla(Vista.VISUALIZAR_LISTADO_EMPLEADOS);

    }

}
