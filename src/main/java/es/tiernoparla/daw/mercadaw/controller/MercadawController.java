package es.tiernoparla.daw.mercadaw.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.tiernoparla.daw.mercadaw.App;
import es.tiernoparla.daw.mercadaw.model.Sede;
import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAO;
import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAOFactory;
import es.tiernoparla.daw.mercadaw.model.dao.enums.TipoDB;
import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Imprimible;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Caracteristica;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import es.tiernoparla.daw.mercadaw.model.entity.producto.ProductoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;
import es.tiernoparla.daw.mercadaw.utils.export.ExportarCSV;
import es.tiernoparla.daw.mercadaw.utils.export.enums.Ruta;
import es.tiernoparla.daw.mercadaw.utils.export.enums.Tabla;
import es.tiernoparla.daw.mercadaw.utils.reader.Lector;
import es.tiernoparla.daw.mercadaw.utils.reader.LectorFactory;
import es.tiernoparla.daw.mercadaw.utils.reader.enumeracion.TipoLector;
import es.tiernoparla.daw.mercadaw.utils.writer.MarkdownUtil;
import es.tiernoparla.daw.mercadaw.utils.writer.NominaMercaDAW;
import es.tiernoparla.daw.mercadaw.utils.writer.PDFUtil;
import es.tiernoparla.daw.mercadaw.view.ViewController;
import es.tiernoparla.daw.mercadaw.view.Vista;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Clase que define el estado y comportamiento del controlador de la aplicación, 
 * que conecta las funcionalidades del modelo con la vista y viceversa.
 */
public class MercadawController extends Application{

    private static Stage currentStage;
    private MercaDawDAO dao = MercaDawDAOFactory.crear(TipoDB.MARIADB);;
    private Sede mercadaw = new Sede();
    private Lector lector;

    /**
     * Lanza la vista principal para el inicio de la app
     * 
     * @param stage
     * @throws IOException
     */
    public void start(Stage stage) throws IOException {
        currentStage = stage;
        cargarVista(Vista.INICIO);
    }

    /**
     * Este metodo coge cualquier vista que le pase por parametro y te devuelve la
     * vista para mostrarla
     * 
     * @param ficheroView
     * @return viewController
     * @throws IOException
     */
    public ViewController cargarVista(Vista ficheroView) throws IOException {

        final String ICONO = "file:images/logo.png";
        final String TITULO = "MercaDAW";

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ficheroView.getRuta()));
        Parent root = (Parent) fxmlLoader.load();

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
     * Este metodo es al que van a llamar desde las vistas para que cargue cualquier
     * VISTA
     * 
     * @param vista
     */
    public void cargarPantalla(Vista vista) {

        final String ERR_CARGA = "Error al cargar la vista : %s";

        try {
            cargarVista(vista);
        } catch (IOException e) {
            System.err.println(String.format(ERR_CARGA, vista.getRuta()));
        }

    }

    // PRODUCTOS
    /**
     * Da de alta un producto en la base de datos y en la sede
     * @param categoria Categoria del producto
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param precio Precio del producto
     * @param altura Altura del producto
     * @param anchura Anchura del producto
     * @param peso Peso del producto
     * @param numElementos Número de elementos del producto
     * @param descripcion Descripción del producto
     * @throws IOException
     * @throws SQLException
     */
    public void darAltaProducto(String categoria, String nombre, String marca, double precio, double altura, double anchura, double peso, int numElementos, String descripcion)throws IOException, SQLException{

        CategoriaProducto cp = null;

        switch (categoria) {
            case "Alimentacion":
                cp = CategoriaProducto.ALIMENTACION;
                break;

            case "Drogueria":
                cp = CategoriaProducto.COSMETICA;
                break;

            case "Cosmetica":
                cp = CategoriaProducto.COSMETICA;
                break;
        }

        Caracteristica caracteristica = new Caracteristica(altura, anchura, peso, numElementos);
        Producto producto = ProductoFactory.crear(cp, nombre, marca, precio, caracteristica, descripcion);

        if (!mercadaw.getProductos().contains(producto)) {
            mercadaw.darAlta(producto);
            dao.insertar(producto);
        }
    }

    /**
     * Da de alta varios productos a partir de un fichero CSV
     * @param fichero Fichero CSV con los productos a dar de alta
     * @throws Exception
     */
    public void darAltaVariosProductosCSV(File fichero) throws Exception{

        lector = LectorFactory.obtenerLector(TipoLector.CSV);
        mercadaw.darAlta(lector.leerProducto(lector.cargar(fichero)));
        dao.insertarProductos(mercadaw.getProductos());

    }

    /**
     * Da de alta varios productos a partir de un fichero JSON
     * @param fichero Fichero JSON con los productos a dar de alta
     * @throws Exception
     */
    public void darAltaVariosProductosJSON(File fichero) throws Exception{

        lector = LectorFactory.obtenerLector(TipoLector.JSON);
        mercadaw.darAlta(lector.leerProducto(lector.cargar(fichero)));
        dao.insertarProductos(mercadaw.getProductos());

    }

    // EMPLEADOS
    /**
     * Da de alta un empleado en la base de datos y en la sede
     * @param categoria Categoria del empleado
     * @param nombre Nombre del empleado
     * @param apellidos Apellidos del empleado
     * @throws IOException
     * @throws SQLException
     */
    public void darAltaEmpleado(String categoria, String nombre, String apellidos)throws IOException, SQLException{

        CategoriaEmpleado ce = null;

        switch (categoria) {

            case "Empleado":
                ce = CategoriaEmpleado.EMPLEADO;
                break;

            case "Reponedor":
                ce = CategoriaEmpleado.REPONEDOR;
                break;

            case "Cajero":
                ce = CategoriaEmpleado.CAJERO;
                break;

            case "Encargado":
                ce = CategoriaEmpleado.ENCARGADO;
                break;

        }

        Empleado empleado = EmpleadoFactory.crear(ce, nombre, apellidos, 0);

        if (!mercadaw.getEmpleados().contains(empleado))
            mercadaw.darAlta(empleado);
        dao.insertar(empleado);
    }

    /**
     * Da de alta varios empleados a partir de un fichero CSV
     * @param fichero Fichero CSV con los empleados a dar de alta
     * @throws Exception
     */
    public void darAltaVariosEmpleadosCSV(File fichero) throws Exception{

        lector = LectorFactory.obtenerLector(TipoLector.CSV);
        mercadaw.darAlta(lector.leerEmpleado(lector.cargar(fichero)));
        dao.insertarEmpleados(mercadaw.getEmpleados());
    }

    /**
     * Da de alta varios empleados a partir de un fichero JSON
     * @param fichero Fichero JSON con los empleados a dar de alta
     * @throws Exception
     */
    public void darAltaVariosEmpleadosJSON(File fichero) throws Exception{

        lector = LectorFactory.obtenerLector(TipoLector.JSON);
        mercadaw.darAlta(lector.leerEmpleado(lector.cargar(fichero)));
        dao.insertarEmpleados(mercadaw.getEmpleados());
    }

    /**
     * Llama al método exportarCSV() de la clase ExportarCSV para exportar los datos de las tablas de la base de datos a ficheros CSV.
     */
    public void exportarDatos() {
        ExportarCSV ex = new ExportarCSV();
        ex.exportarCSV(Tabla.CLIENTES.getQuery(), Ruta.CLIENTES.getRuta());
        ex.exportarCSV(Tabla.COMPRA.getQuery(), Ruta.COMPRA.getRuta());
        ex.exportarCSV(Tabla.EMPLEADOS.getQuery(), Ruta.EMPLEADOS.getRuta());
        ex.exportarCSV(Tabla.PRODUCTO_SEDE.getQuery(), Ruta.PRODUCTO_SEDE.getRuta());
        ex.exportarCSV(Tabla.PRODUCTOS.getQuery(), Ruta.PRODUCTOS.getRuta());
        ex.exportarCSV(Tabla.SEDE.getQuery(), Ruta.SEDE.getRuta());
        ex.exportarCSV(Tabla.COMPRA_PRODUCTOS.getQuery(), Ruta.COMPRA_PRODUCTOS.getRuta());
    }

    public List<Empleado> listarEmpleados() throws SQLException {

        return dao.visualizarListaEmpleados();

    }

    public List<Producto> listarProductos() throws SQLException {

        return dao.visualizarListaProductos();

    }

    /**
     * Llama al método imprimir() de la clase Impresora, que a su vez llama al
     * método imprimir()
     * de las clases que hayan implementado la interfaz Imprimible.
     * 
     * @param i Un objeto de tipo Imprimible.
     * @return Un String con información detalla del objeto.
     * @throws SQLException
     */
    public String visualizarDatosProducto(int ean) throws SQLException {

        Imprimible i = dao.visualizarListaProductos().get(ean);

        return mercadaw.visualizar(i);

    }

    public String visualizarPrecioProducto(int ean) throws SQLException {

        Producto p = dao.visualizarListaProductos().get(ean);

        return mercadaw.obtenerPrecioVenta(p);

    }

    /**
     * Llama a los métodos del modelo para imprimir una etiqueta de un producto.
     * @param ean El id del producto del que se quiere imprimir la etiqueta.
     * @throws SQLException
     * @throws IOException
     */
    public void imprimirEtiqueta(int ean) throws SQLException, IOException {
        Producto p = dao.visualizarListaProductos().get(ean);

        MarkdownUtil.crearEtiqueta(mercadaw.imprimirEtiqueta(p));
    }

    public void exportarEtiquetaPDF() throws IOException {
        PDFUtil.exportarEtiquetaPDF();
    }

    /**
     * Llama el método listarEmpleados() de la clase MercadawController y además llama al método calcularImportes() de la clase NominaMercaDAW.
     * @return Una lista de String con las nominas de los empleados.
     * @throws SQLException
     */
    public List<String> calcularNominas() throws SQLException {
        List<Empleado> empleados = listarEmpleados();
        NominaMercaDAW nomina = new NominaMercaDAW();
        List<String> nominas = new ArrayList<>();

        for (Empleado empleado : empleados) {
            String contenidoNomina = nomina.calcularImportes(empleado);
            nominas.add(contenidoNomina);
        }

        return nominas;
    }

}