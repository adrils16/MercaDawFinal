package es.tiernoparla.daw.mercadaw.view;

import es.tiernoparla.daw.mercadaw.controller.*;
import es.tiernoparla.daw.mercadaw.model.Sede;
import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAO;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public abstract class ViewController {

    public static final String ESTILO_CLARO = "estiloClaroFinal.css";
    public static final String ESTILO_OSCURO = "estiloOscuro.css";
    public static final String TITULO_MSG_ERROR = "Importante!";

    protected boolean esClaro = true;
    protected MercadawController controller;

    // protected ObservableList<Producto> productos;
    // protected ObservableList<Empleado> empleados;

    protected MercaDawDAO dao;
    protected Sede mercadaw;

    public MercadawController getController() {
        return controller;
    }

    public void setController(MercadawController controller) {
        this.controller = controller;
    }

    

    // public ObservableList<Producto> getProductos() {
    //     return productos;
    // }

    // public void setProductos(ObservableList<Producto> productos) {
    //     this.productos = productos;
    // }

    // public ObservableList<Empleado> getEmpleados() {
    //     return empleados;
    // }

    // public void setEmpleados(ObservableList<Empleado> empleados) {
    //     this.empleados = empleados;
    // }

    protected boolean campoRelleno(TextField campo) {
        boolean relleno = false;
        if (campo != null && !"".equals(campo.getText().trim())) {
            relleno = true;
        }
        return relleno;
    }

    protected boolean areaRellena(TextArea area) {
        boolean relleno = false;
        if (area != null && !"".equals(area.getText().trim())) {
            relleno = true;
        }
        return relleno;
    }

    protected void mostrarAviso(String msg, AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(TITULO_MSG_ERROR);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }

    public static String getEstiloClaro() {
        return ESTILO_CLARO;
    }

    public static String getEstiloOscuro() {
        return ESTILO_OSCURO;
    }

    public static String getTituloMsgError() {
        return TITULO_MSG_ERROR;
    }

    public boolean isEsClaro() {
        return esClaro;
    }

    public void setEsClaro(boolean esClaro) {
        this.esClaro = esClaro;
    }

}
