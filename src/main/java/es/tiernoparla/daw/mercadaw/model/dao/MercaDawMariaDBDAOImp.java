package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Caracteristica;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import es.tiernoparla.daw.mercadaw.model.entity.producto.ProductoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;

public class MercaDawMariaDBDAOImp implements MercaDawDAO{

    public final String MSG_ERROR_CONEXION = "Error al conectar con la base de datos";

    public final String URL = "jdbc:mariadb://localhost:3306/%s?user=%s&password=%s";
    public final String DATABASE_NAME = "mercadaw";
    public final String DATABASE_USER = "root";
    public final String DATABASE_PASS = "secret";

    private Connection conexion;

    public MercaDawMariaDBDAOImp() {
        try {
            conexion = DriverManager.getConnection(String.format(URL, DATABASE_NAME, DATABASE_USER, DATABASE_PASS));
        } catch (SQLException e) {
            System.err.println(MSG_ERROR_CONEXION);
        }
    }

    /**
     * Inserta un producto en la tabla Productos.
     * @param producto Producto que se quiere insertar.
     * @return Número de productos insertados.
     */
    @Override
    public int insertar(Producto producto) throws SQLException{
        int numRegistrosActualizados = 0;
        final String SQL = "INSERT INTO PRODUCTOS (nombre, marca, precio, altura, anchura, peso, num_elementos, descripcion, categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(SQL);

        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getMarca());
        ps.setDouble(3, producto.getPrecio());
        ps.setDouble(4, producto.getCaracteristica().getAltura());
        ps.setDouble(5, producto.getCaracteristica().getAnchura());
        ps.setDouble(6, producto.getCaracteristica().getPeso());
        ps.setInt(7, producto.getCaracteristica().getNumElementos());
        ps.setString(8, producto.getDescripcion());
        ps.setString(9, producto.getCategoria());

        numRegistrosActualizados = ps.executeUpdate();

        return numRegistrosActualizados;
    }

    /**
     * Inserta una lista de producto en la tabla Productos.
     * @param productos Lista de productos que se quiere insertar.
     * @return Número de productos insertados.
     */
    @Override
    public int insertarProductos(List<Producto> productos) throws SQLException{

        final String SQL = "INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(SQL);

            for (Producto producto : productos) {
                ps.setString(1, producto.getNombre());
                ps.setString(2, producto.getMarca());
                ps.setDouble(3, producto.getPrecio());
                ps.setDouble(4, producto.getCaracteristica().getAltura());
                ps.setDouble(5, producto.getCaracteristica().getAnchura());
                ps.setDouble(6, producto.getCaracteristica().getPeso());
                ps.setInt(7, producto.getCaracteristica().getNumElementos());
                ps.setString(8, producto.getDescripcion());
                ps.addBatch();
            }

        //Quito el autocommit por si falla algún insert que no haga ninguno.
        conexion.setAutoCommit(false);
        ps.executeBatch();
        conexion.setAutoCommit(true);
            
        ps.close();
        return productos.size();

    }

    /**
     * Inserta un empleado en la tabla Empleados.
     * @param empleado Empleado que se quiere insertar.
     * @return Número de empleados insertados.
     */ 
    @Override
    public int insertar(Empleado empleado) throws SQLException{
        int numRegistrosActualizados = 0;
        final String SQL = "INSERT INTO EMPLEADOS (nombre, apellidos, salario, categoria) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(SQL);

        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellidos());
        ps.setInt(3, empleado.getSueldo());
        ps.setString(4, empleado.getCategoria().toString());

        numRegistrosActualizados = ps.executeUpdate();
        ps.close();

        return numRegistrosActualizados;
    }

    /**
     * Inserta una lista de empleados en la tabla Empleados.
     * @param empleados Lista de empleados que se quiere insertar.
     * @return Número de empleaods insertados.
     */
    @Override
    public int insertarEmpleados(List<Empleado> empleados) throws SQLException{
        int numRegistrosActualizados = 0;
        final String SQL = "INSERT INTO EMPLEADOS (nombre, apellidos, salario, categoria) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement ps = conexion.prepareStatement(SQL)) {
            for (Empleado empleado : empleados) {
                ps.setString(1, empleado.getNombre());
                ps.setString(2, empleado.getApellidos());
                ps.setInt(3, empleado.getSueldo());
                ps.setString(4, empleado.getCategoria().toString());
                ps.addBatch();
            }
            numRegistrosActualizados = ps.executeBatch().length;
        }
        return numRegistrosActualizados;
    }

    /**
     * Lista el id, nombre, apellidos y categoría de cada empleado desde la vista VISTA_EMPLEADOS.
     * @return Listado de empleados y su informacion.
     */
    @Override
    public List<Empleado> visualizarListaEmpleados() throws SQLException{
        final String SQL = "SELECT ID_EMPLEADO, NOMBRE, APELLIDOS, CATEGORIA FROM VISTA_EMPLEADOS;";
        List<Empleado> empleados = new ArrayList<>();

        CategoriaEmpleado ce = null;

            try (PreparedStatement ps = conexion.prepareStatement(SQL); 
            ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    int id = rs.getInt("ID_EMPLEADO");
                    String nombre = rs.getString("NOMBRE");
                    String apellidos = rs.getString("APELLIDOS");
                    String categoria = rs.getString("CATEGORIA");
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
                    empleados.add(EmpleadoFactory.crear(ce, nombre, apellidos, id));
                }
            } catch (SQLException e) {
                System.err.println(MSG_ERROR_CONEXION);
            }

        return empleados;
    }

    @Override
    public List<Producto> visualizarListaProductos() throws SQLException {
        final String SQL = "SELECT EAN, NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION, CATEGORIA FROM VISTA_PRODUCTOS ORDER BY EAN;";
        List<Producto> productos = new ArrayList<>();

        CategoriaProducto cp = null;

            try (PreparedStatement ps = conexion.prepareStatement(SQL); 
            ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    String nombre = rs.getString("NOMBRE");
                    String marca = rs.getString("MARCA");
                    double precio = rs.getDouble("PRECIO");
                    double altura = rs.getDouble("ALTURA");
                    double anchura = rs.getDouble("PESO");
                    double peso = rs.getDouble("PESO");
                    int numElementos = rs.getInt("NUM_ELEMENTOS");
                    String descripcion = rs.getString("DESCRIPCION");
                    String categoria = rs.getString("CATEGORIA");
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
                    productos.add(ProductoFactory.crear(cp, nombre, marca, precio, new Caracteristica(altura, anchura, peso, numElementos), descripcion));
                }
            } catch (SQLException e) {
                System.err.println(MSG_ERROR_CONEXION);
            }

        return productos;
    }

    
    public String getMSG_ERROR_CONEXION() {
        return MSG_ERROR_CONEXION;
    }



    public String getURL() {
        return URL;
    }



    public String getDATABASE_NAME() {
        return DATABASE_NAME;
    }



    public String getDATABASE_USER() {
        return DATABASE_USER;
    }



    public String getDATABASE_PASS() {
        return DATABASE_PASS;
    }



    public Connection getConexion() {
        return conexion;
    }



    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
