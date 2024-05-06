package es.tiernoparla.daw.mercadaw.view;


public enum Vista {

    INICIO("view/principalView.fxml"),
    GESTION_EMPLEADOS("view/gestionEmpleadosView.fxml"),
    GESTION_PRODUCTO("view/gestrionProductoView.fxml"),
    GESTION_COMPRAS("view/gestionComprasView.fxml")
    ;

    private String ruta;

    private Vista(String ruta){
        this.ruta = ruta;
    }

    public String getRuta(){
        return ruta;
    }
}
