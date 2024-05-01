package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public abstract class MercaDawDAOImp implements MercaDawDAO {

    Connection conexion;

    @Override
    public void crearTablaProductos() throws SQLException {
        String sql = "Sentencia SQL para crear tabla";
        PreparedStatement st = conexion.prepareStatement(sql);

        st.execute();
        st.close();
    }

    @Override
    public void crearTablaEmpleados() throws SQLException {
        String sql = "Sentencia SQL para crear tabla";
        PreparedStatement st = conexion.prepareStatement(sql);

        st.execute();
        st.close();
    }

    @Override
    public void crearTablaCompras() throws SQLException {
        String sql = "Sentencia SQL para crear tabla";
        PreparedStatement st = conexion.prepareStatement(sql);

        st.execute();
        st.close();
    }

    @Override
    public int insertar(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public int insertar(List<Producto> productos) {
        /*
        final String sql = "INSERT INTO alumno VALUES (?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        for(Producto producto : productos){
            ps.setString(1, producto);
            ps.setString(2, producto);
            ps.setInt(3, producto);

            //Añade a la lista de ejecución ese insert
            ps.addBatch();
        }

        //Quito el autocommit por si falla algún insert que no haga ninguno.
        conn.setAutoCommit(false);
        ps.executeBatch();
        conn.setAutoCommit(true);
        
        ps.close();
        return alumnos.size();
        */

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public int insertar(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public int insertar(Empleado[] empleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public int actualizar(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public int actualizar(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public int borrar(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrar'");
    }

    @Override
    public int borrar(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrar'");
    }
    
}
