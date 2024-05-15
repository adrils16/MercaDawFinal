package es.tiernoparla.daw.mercadaw.view;

import es.tiernoparla.daw.mercadaw.controller.*;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public abstract class ViewController {

    public static final String ESTILO_CLARO = "estiloClaroFinal.css";
    public static final String ESTILO_OSCURO = "estiloOscuro.css";
    public static final String TITULO_MSG_ERROR = "Importante!";
    
    protected boolean esClaro = true;
    protected MercadawController controller;

    protected ObservableList <Producto> productos;
    protected ObservableList <Empleado> empleados;

    public MercadawController getController() {
        return controller;
    }

    public void setController(MercadawController controller) {
        this.controller = controller;
    }

    public ObservableList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ObservableList<Producto> productos) {
        this.productos = productos;
    }

    public ObservableList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ObservableList<Empleado> empleados) {
        this.empleados = empleados;
    }

    protected void mostrarAviso(String msg, AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(TITULO_MSG_ERROR);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}
