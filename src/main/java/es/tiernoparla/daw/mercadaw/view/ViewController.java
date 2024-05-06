package es.tiernoparla.daw.mercadaw.view;

import es.tiernoparla.daw.mercadaw.controller.*;
public abstract class ViewController {

    
    
    protected MercadawController controller;

    public MercadawController getController() {
        return controller;
    }

    public void setController(MercadawController controller) {
        this.controller = controller;
    }

   
    
    
}
