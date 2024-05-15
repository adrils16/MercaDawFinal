package es.tiernoparla.daw.mercadaw;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.utils.reader.Lector;
import es.tiernoparla.daw.mercadaw.utils.reader.LectorFactory;
import es.tiernoparla.daw.mercadaw.utils.reader.LectorImp;
import es.tiernoparla.daw.mercadaw.utils.reader.enumeracion.TipoLector;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public class LectorTest {

    List<Empleado> empleados = new ArrayList<>(); // Initialize the empleados list
    List<Producto> productos = new ArrayList<>(); // Initialize the productos list

    @Test
    public void LectorCSVTest() throws Exception {
        File fichero = new File("productos.csv");
        Lector lector = LectorFactory.obtenerLector(TipoLector.CSV);
        productos.addAll(lector.leerProducto(LectorImp.cargar(fichero)));
    }

    @Test
    public void LectorJSONTest() throws Exception {
        File fichero = new File("empleados.json");
        Lector lector = LectorFactory.obtenerLector(TipoLector.JSON);
        empleados.addAll(lector.leerEmpleado(LectorImp.cargar(fichero)));
    }

}
