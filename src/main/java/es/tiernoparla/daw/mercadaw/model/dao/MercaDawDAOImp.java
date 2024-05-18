package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public abstract class MercaDawDAOImp implements MercaDawDAO{

    public final String MSG_ERROR_CONEXION = "Error al conectar con la base de datos";

    protected final String URL = "jdbc:mariadb://localhost:3306/%s?user=%s&password=%s";
    protected final String DATABASE_NAME = "mercadaw";
    protected final String DATABASE_USER = "root";
    protected final String DATABASE_PASS = "secret";

    protected Connection conexion;

    public MercaDawDAOImp() {
        try {
            conexion = DriverManager.getConnection(String.format(URL, DATABASE_NAME, DATABASE_USER, DATABASE_PASS));
        } catch (SQLException e) {
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
        final String SQL = "INSERT INTO PRODUCTOS (nombre, marca, precio, altura, anchura, peso, num_elementos, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(SQL);

        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getMarca());
        ps.setDouble(3, producto.getPrecio());
        ps.setDouble(4, producto.getCaracteristica().getAltura());
        ps.setDouble(5, producto.getCaracteristica().getAnchura());
        ps.setDouble(6, producto.getCaracteristica().getPeso());
        ps.setInt(7, producto.getCaracteristica().getNumElementos());
        ps.setString(8, producto.getDescripcion());

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

    public String buscarListadoStockProd() throws SQLException{
        //TODO sobre vistas
        final String SQL = "SELECT PRODUCTOS.EAN, NOMBRE, STOCK FROM PRODUCTOS, PRODUCTO_SEDE WHERE PRODUCTOS.EAN = PRODUCTO_SEDE.EAN;";
        String listado = "";
        try (PreparedStatement ps = conexion.prepareStatement(SQL)) {
            listado = ps.toString();
        } catch (SQLException e) {
            //TODO
            
        }
        return listado;
    }

    public String visualizarDatosProd() {
        //TODO sobre vistas
        final String SQL = "SELECT EAN, NOMBRE FROM PRODUCTOS;";
        String listado = "";
        try (PreparedStatement ps = conexion.prepareStatement(SQL)) {
            listado = ps.toString();
        } catch (SQLException e) {
            //TODO
            
        }
        return listado;
    }

    public String visualizarEmp() {
        //TODO sobre vistas
        final String SQL = "SELECT ID, NOMBRE, APELLIDOS, CATEGORIA FROM EMPLEADOS;";
        String listado = "";
        try (PreparedStatement ps = conexion.prepareStatement(SQL)) {
            listado = ps.toString();
        } catch (SQLException e) {
            //TODO
            
        }
        return listado;
    }

    public String listarCompras() {
        //TODO sobre vistas
        final String SQL = ";";
        String listado = "";
        try (PreparedStatement ps = conexion.prepareStatement(SQL)) {
            listado = ps.toString();
        } catch (SQLException e) {
            //TODO
            
        }
        return listado;
    }
}
