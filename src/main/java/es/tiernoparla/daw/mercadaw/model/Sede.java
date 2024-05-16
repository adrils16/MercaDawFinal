package es.tiernoparla.daw.mercadaw.model;

import java.util.ArrayList;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;
import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Imprimible;
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
    public int darAlta(Gestionable gestionable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'darAlta'");
    }

    @Override
    public int darAlta(List<Gestionable> gestionables) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'darAlta'");
    }

    @Override
    public String visualizar(Imprimible imprimible) {
        return imprimible.imprimir();
    }

    @Override
    public String visualizar(List<Imprimible> imprimibles) {
        String cadena = "";

        for (Imprimible imprimible : imprimibles) {
            cadena.concat(imprimible.imprimir());
        }

        return cadena;
    }

    @Override
    public String obtenerPrecioVenta(Producto producto) {
        return producto.visualizarPrecioTotal();
    }

    @Override
    public String imprimirEtiqueta(Producto producto) {
        return producto.imprimirEtiqueta();
    }

    @Override
    public double calcularNominas(List<Empleado> empleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularNominas'");
    }

    
}
