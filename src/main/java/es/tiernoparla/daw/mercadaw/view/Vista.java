package es.tiernoparla.daw.mercadaw.view;


public enum Vista {

    INICIO("view/principalView.fxml"),
    GESTION_EMPLEADOS("view/gestionEmpleadosView.fxml"),
    GESTION_PRODUCTO("view/gestionProductoView.fxml"),
    GESTION_COMPRAS("view/gestionComprasView.fxml"),
    DAR_ALTA_PRODUCTO("view/darAltaProductoView.fxml"),
    DAR_ALTA_COMPRA("view/darAltaCompraView.fxml"),
    DAR_ALTA_EMPLEADO("view/darAltaEmpleadoView.fxml"),
    DATOS_PRODUCTO("view/datosProductoView.fxml"),
    IMPRIMIR__ETIQUETA("view/imprimirEtiquetaView.fxml"),
    MOSTRAR_STOCK("view/mostarStockProductosView.fxml"),
    PRECIO_VENTA("view/obtenerPrecioVentaProductoView.fxml"),
    VISUALIZAR_DATOS_PRODUCTO("view/visualizarDatosProductoView.fxml"),
    VISUALIZAR_LISTADO_COMPRAS("view/visualizarListadoComprasView.fxml"),
    VISUALIZAR_LISTADO_EMPLEADOS("view/visualizarListadoEmpleadosView.fxml"),
    ;

    private String ruta;

    private Vista(String ruta){
        this.ruta = ruta;
    }

    public String getRuta(){
        return ruta;
    }
}
