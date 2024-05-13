package es.tiernoparla.daw.mercadaw.view;

import es.tiernoparla.daw.mercadaw.controller.*;
public abstract class ViewController {

    public static final String ESTILO_CLARO = "estiloClaroFinal.css";
    public static final String ESTILO_OSCURO = "estiloOscuro.css";
    
    protected boolean esClaro = true;
    protected MercadawController controller;

    public MercadawController getController() {
        return controller;
    }

    public void setController(MercadawController controller) {
        this.controller = controller;
    }
}
