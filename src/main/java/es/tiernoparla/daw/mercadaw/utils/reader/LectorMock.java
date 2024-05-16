package es.tiernoparla.daw.mercadaw.utils.reader;

import java.io.File;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public class LectorMock implements Lector{

    @Override
    public List<Gestionable> leerProducto(String cadena) {
        return null;
    }

    @Override
    public List<Gestionable> leerEmpleado(String cadena) {
        return null;
    }

    public Producto procesarProducto(String fila) {
        return null;
    }

    public void comprobar(String codigo) {
    }

    public Empleado procesarEmpleado(String fila) {
        return null;
    }

    @Override
    public String cargar(File fichero) throws Exception {
        return null;
    }
    
}
