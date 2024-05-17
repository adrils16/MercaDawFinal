package es.tiernoparla.daw.mercadaw.controller;

import java.io.IOException;

import es.tiernoparla.daw.mercadaw.App;
import es.tiernoparla.daw.mercadaw.view.ViewController;
import es.tiernoparla.daw.mercadaw.view.Vista;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MercadawController extends Application{

    private static Stage currentStage;

    /** 
     * Lanza la vista principal para el inicio de la app
     * @param stage
     * @throws IOException
     */
    public void start(Stage stage) throws IOException {
        currentStage = stage;
        cargarVista(Vista.INICIO);
    }

    /**
     * Este metodo coge cualquier vista que le pase por parametro y te devuelve la vista para mostrarla
     * @param ficheroView
     * @return viewController 
     * @throws IOException
     */
    public ViewController cargarVista(Vista ficheroView) throws IOException{

        final String ICONO = "file:images/logo.png";
        final String TITULO = "MercaDAW";

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ficheroView.getRuta()));
        Parent root = (Parent)fxmlLoader.load();  

    
        ViewController viewController = fxmlLoader.<ViewController>getController();
        viewController.setController(this);
        Scene scene = new Scene(root); 
        Image icono = new Image(ICONO);

        currentStage.getIcons().add(icono);
        currentStage.setTitle(TITULO);
        currentStage.setScene(scene);
        currentStage.setResizable(false);
        currentStage.show();
        
        return viewController;
    }

    /**
     * Este metodo es al que van a llamar desde las vistas para que cargue cualquier VISTA
     * @param vista
     */
    public void cargarPantalla(Vista vista){

        final String ERR_CARGA = "Error al cargar la vista : %s";

        try{
            cargarVista(vista);
        }catch(IOException e){
            System.err.println(String.format(ERR_CARGA, vista.getRuta()));
        }

    }

    //quitar
    public void cargarProducto()throws IOException{
        cargarVista(Vista.GESTION_PRODUCTO);
    }
}
