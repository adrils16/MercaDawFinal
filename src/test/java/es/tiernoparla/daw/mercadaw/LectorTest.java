package es.tiernoparla.daw.mercadaw;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.utils.reader.Lector;
import es.tiernoparla.daw.mercadaw.utils.reader.LectorFactory;
import es.tiernoparla.daw.mercadaw.utils.reader.LectorImp;
import es.tiernoparla.daw.mercadaw.utils.reader.enumeracion.TipoLector;
import es.tiernoparla.daw.mercadaw.model.Sede;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public class LectorTest {

    Sede mercadaw = new Sede();

    @Test
    public void LectorCSVTest() throws Exception {
        File fichero = new File("productos.csv");
        Lector lector = LectorFactory.obtenerLector(TipoLector.CSV);
        //productos = lector.leerProducto(LectorImp.cargar(fichero));
        //System.out.println(productos);
    }

    @Test
    public void lectorCSVEmpleadosTest() throws Exception {
        File fichero = new File("emplados.csv");
        Lector lector = LectorFactory.obtenerLector(TipoLector.CSV);
        String codigo = lector.cargar(fichero);
        mercadaw.darAlta(lector.leerEmpleado(codigo));
    }
    @Test
    public void LectorJSONTest() throws Exception {
        File fichero = new File("empleados.json");
        Lector lector = LectorFactory.obtenerLector(TipoLector.JSON);
        //empleados.addAll(lector.leerEmpleado(LectorImp.cargar(fichero)));
    }

}
