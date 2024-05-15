package es.tiernoparla.daw.mercadaw.model.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

/**
 * Esta clase realiza todas las operaciones relacionadas con la Base de Datos
 */
public abstract class MercaDawMariaDBDAOImp implements MercaDawDAO {

    private final String URL = "jdbc:mariadb://localhost:3306/%s?user=%s&password=%s";
    private final String DATABASE_NAME = "mercadaw";
    private final String DATABASE_USER = "usuario";
    private final String DATABASE_PASS = "usuario";

    private Connection conexion;

    public MercaDawMariaDBDAOImp() throws Exception{
        conexion = DriverManager.getConnection(String.format(URL, DATABASE_NAME, DATABASE_USER, DATABASE_PASS));
    }

    /**
     * Crea la tabla PRODUCTOS.
     */
    @Override
    public void crearTablaProductos() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS PRODUCTOS (" +
                    "ID_PRODUCTO INT AUTO_INCREMENT PRIMARY KEY," +
                    "NOMBRE VARCHAR(50) NOT NULL," +
                    "MARCA VARCHAR(25) NOT NULL," +
                    "PRECIO NUMBER NOT NULL," +
                    "ALTURA NUMBER NOT NULL," +
                    "ANCHURA NUMBER NOT NULL," +
                    "PESO NUMBER NOT NULL," +
                    "NUM_ELEMENTOS INT NOT NULL," +
                    "DESCRIPCION VARCHAR(100) NOT NULL)";

        PreparedStatement st = conexion.prepareStatement(sql);

        st.execute();
        st.close();
    }

    /**
     * Crea la tabla EMPLEADOS.
     */
    @Override
    public void crearTablaEmpleados() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS EMPLEADOS (" +
                            "ID_EMPLEADO INT AUTO_INCREMENT PRIMARY KEY," +
                            "NOMBRE VARCHAR(25) NOT NULL," +
                            "APELLIDOS VARCHAR(25) NOT NULL," +
                            "SALARIO NUMBER NOT NULL)";

        PreparedStatement st = conexion.prepareStatement(sql);

        st.execute();
        st.close();
    }

    /**
     * Crea la tabla COMPRA.
     */
    @Override
    public void crearTablaCompras() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS COMPRA (" +
                        "ID_COMPRA INT AUTO_INCREMENT PRIMARY KEY," +
                        "HORA NUMBER NOT NULL," +
                        "FECHA DATE NOT NULL," +
                        "DNI VARCHAR(9) NOT NULL," +
                        "FOREIGN KEY (DNI) REFERENCES CLIENTE(DNI))";
        PreparedStatement st = conexion.prepareStatement(sql);

        st.execute();
        st.close();
    }

    /**
     * Inserta un producto en la tabla Productos.
     * @param producto Producto que se quiere insertar.
     * @return Número de productos insertados.
     */
    @Override
    public int insertar(Producto producto) throws SQLException{
        int numRegistrosActualizados = 0;
        String sql = "INSERT INTO productos (nombre, marca, precio, altura, anchura, peso, numElementos, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getMarca());
        ps.setDouble(3, producto.getPrecio());
        ps.setDouble(4, producto.getAltura());
        ps.setDouble(5, producto.getAnchura());
        ps.setDouble(6, producto.getPeso());
        ps.setInt(7, producto.getNumElementos());
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
    public int insertar(List<Producto> productos) throws SQLException{

        String sql = "INSERT INTO productos (nombre, marca, precio, altura, anchura, peso, numElementos, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

            for (Producto producto : productos) {
                ps.setString(1, producto.getNombre());
                ps.setString(2, producto.getMarca());
                ps.setDouble(3, producto.getPrecio());
                ps.setDouble(4, producto.getAltura());
                ps.setDouble(5, producto.getAnchura());
                ps.setDouble(6, producto.getPeso());
                ps.setInt(7, producto.getNumElementos());
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
        String sql = "INSERT INTO empleados (nombre, salario, id) VALUES (?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellidos());
        ps.setInt(3, empleado.getId());

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
    public int insertar(Empleado[] empleados) throws SQLException{
        int numRegistrosActualizados = 0;
        String sql = "INSERT INTO empleados (nombre, salario, id) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            for (Empleado empleado : empleados) {
                ps.setString(1, empleado.getNombre());
                ps.setString(2, empleado.getApellidos());
                ps.setInt(3, empleado.getId());
                ps.addBatch();
            }
            numRegistrosActualizados = ps.executeBatch().length;
        }
        return numRegistrosActualizados;
    }

    /**
     * Actualiza un producto de la tabla Productos.
     * @param producto Producto que se quiere actualizar.
     * @return Número de productos actualizados.
     */   
    @Override
    public int actualizar(Producto producto) throws SQLException{
        int numRegistrosActualizados = 0;
        String sql = "UPDATE productos SET nombre = ?, marca = ?, precio = ?, altura = ?, anchura = ?, peso = ?, numElementos = ?, descripcion = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setDouble(3, producto.getPrecio());
            ps.setDouble(4, producto.getAltura());
            ps.setDouble(5, producto.getAnchura());
            ps.setDouble(6, producto.getPeso());
            ps.setInt(7, producto.getNumElementos());
            ps.setString(8, producto.getDescripcion());
            numRegistrosActualizados = ps.executeUpdate();
        }
        return numRegistrosActualizados;
    }

    /**
     * Actualiza un empleado de la tabla Empleados.
     * @param empleado Empleado que se quiere actualizar.
     * @return Número de empleados actualizados.
     */     
    @Override
    public int actualizar(Empleado empleado) throws SQLException{
        int numRegistrosActualizados = 0;
        String sql = "UPDATE empleados SET nombre = ?, apellido = ?, salario = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellidos());
            ps.setInt(3, empleado.getId());
            ps.setDouble(4, empleado.CATEGORIA.getSueldo());
            numRegistrosActualizados = ps.executeUpdate();
        }
        return numRegistrosActualizados;
    }

    /**
     * Borra un producto de la tabla Productos.
     * @param producto Producto que queremos borrar.
     * @return Número de productos borrados.
     */  
    @Override
    public int borrar(Producto producto) throws SQLException{
        int numRegistrosBorrados = 0;
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            //TODO
            //ps.setInt(1, producto.getId()); AÑADIR IDPRODUCTO A PRODUCTO
            numRegistrosBorrados = ps.executeUpdate();
        }
        return numRegistrosBorrados;
    }

    /**
     * Borra un empleado de la tabla Empleados.
     * @param empleado Empleado que queremos borrar.
     * @return Número de empleados borrados.
     */     
    @Override
    public int borrar(Empleado empleado) throws SQLException{
        int numRegistrosBorrados = 0;
        String sql = "DELETE FROM empleados WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, empleado.getId());
            numRegistrosBorrados = ps.executeUpdate();
        }
        return numRegistrosBorrados;
    }
    
    private String leerScriptSQL(String rutaScript) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaScript))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }
        }
        return sb.toString();
    }

    private void ejecutarScriptSQL(String script) throws SQLException {
        try (Statement statment = conexion.createStatement()) {
            statment.executeUpdate(script);
        }
    }
}
