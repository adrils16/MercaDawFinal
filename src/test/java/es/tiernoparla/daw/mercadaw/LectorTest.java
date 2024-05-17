package es.tiernoparla.daw.mercadaw;

import java.io.File;
import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.utils.reader.Lector;
import es.tiernoparla.daw.mercadaw.utils.reader.LectorFactory;
import es.tiernoparla.daw.mercadaw.utils.reader.enumeracion.TipoLector;
import es.tiernoparla.daw.mercadaw.model.Sede;
import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAO;
import es.tiernoparla.daw.mercadaw.model.dao.MercaDawDAOFactory;
import es.tiernoparla.daw.mercadaw.model.dao.enums.TipoDB;

public class LectorTest {

    Sede mercadaw = new Sede();
    MercaDawDAO dao = MercaDawDAOFactory.crear(TipoDB.MOCK);
    Lector lectorCSV = LectorFactory.obtenerLector(TipoLector.CSV);
    Lector lectorJSON = LectorFactory.obtenerLector(TipoLector.JSON);

    @Test
    public void LectorCSVTest() throws Exception {
        File fichero = new File("productos.csv");
        mercadaw.darAlta(lectorCSV.leerProducto(lectorCSV.cargar(fichero)));
        dao.insertarProductos(mercadaw.getProductos());
    }

    @Test
    public void lectorCSVEmpleadosTest() throws Exception {
        File fichero = new File("empleados.csv");
        mercadaw.darAlta(lectorCSV.leerEmpleado(lectorCSV.cargar(fichero)));
        dao.insertarEmpleados(mercadaw.getEmpleados());
    }

    @Test
    public void LectorJSONTest() throws Exception {
        File fichero = new File("empleados.json");
        mercadaw.darAlta(lectorJSON.leerEmpleado(lectorJSON.cargar(fichero)));
    }

}
