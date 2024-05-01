package es.tiernoparla.daw.mercadaw.view;

public abstract class ViewController {

    
    protected MercadawContoller controller;

    public MercadawContoller getController() {
        return controller;
    }

    public void setController(MercadawContoller controller) {
        this.controller = controller;
    }
    
}
