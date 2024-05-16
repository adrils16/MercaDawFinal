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

        int numActualizados = 0;

        if (gestionable instanceof Producto) {
            productos.add((Producto)gestionable);
            numActualizados++; 
        }else if (gestionable instanceof Empleado) {
            empleados.add((Empleado)gestionable);
            numActualizados++;
        }

        return numActualizados;
    }

    @Override
    public int darAlta(List<Gestionable> gestionables) {
        
        int numActualizados = 0;

        for (Gestionable gestionable : gestionables) {
            if (gestionable instanceof Producto) {
                productos.add((Producto)gestionable);
                numActualizados++; 
            }else if (gestionable instanceof Empleado) {
                empleados.add((Empleado)gestionable);
                numActualizados++;
            }
        }

        return numActualizados;

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
        // TODO implementar calcularNominas
        throw new UnsupportedOperationException("Unimplemented method 'calcularNominas'");
    }

}
