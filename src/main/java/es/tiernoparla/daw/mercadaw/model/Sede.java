package es.tiernoparla.daw.mercadaw.model;

import java.util.ArrayList;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public class Sede implements MercaDaw {

    private List<Producto> productos = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();


    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public int darAlta(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'darAlta'");
    }

    @Override
    public int darAlta(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'darAlta'");
    }

    @Override
    public void visualizar(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarProductos'");
    }

    @Override
    public void visualizar(List<Empleado> empleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarEmpleados'");
    }

    @Override
    public String obtenerPrecioVenta(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPrecioVenta'");
    }

    @Override
    public String imprimirEtiqueta(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimirEtiqueta'");
    }

    @Override
    public double calcularNominas(List<Empleado> empleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularNominas'");
    }

    
}
