package es.tiernoparla.daw.mercadaw.utils.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Cajero;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Encargado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Reponedor;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Alimentacion;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Drogueria;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Cosmetica;


import es.tiernoparla.daw.mercadaw.exception.LectorException;

/**
 * Clase que lee un fichero CSV y devuelve una lista de productos o empleados.
 */
public class LectorCSV extends LectorImp {

    /**
     * Procesa una fila de un fichero CSV y devuelve un objeto Producto.
     * @param fila Fila del fichero CSV.
     * @return Producto.
     */
    public Producto procesarProducto(String fila) {
        final String PROD_ALIMENTACION = "ALIMENTACION";
        final String PROD_DROGUERIA = "DROGUERIA";
        final String PROD_COSMETICA = "COSMETICA";

        String nombre;
        String marca;
        double precio;
        double altura;
        double anchura;
        double peso;
        int numElementos;
        String descripcion;
        String categoria;

        Producto producto = null;

        StringTokenizer st = new StringTokenizer(fila, ",");

        nombre = st.nextToken();
        marca = st.nextToken();
        precio = Double.parseDouble(st.nextToken());
        altura = Double.parseDouble(st.nextToken());
        anchura = Double.parseDouble(st.nextToken());
        peso = Double.parseDouble(st.nextToken());
        numElementos = Integer.parseInt(st.nextToken());
        descripcion = st.nextToken();
        categoria = st.nextToken().toUpperCase();

        switch (categoria) {
            case PROD_ALIMENTACION:
                producto = new Alimentacion(nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);
            
            case PROD_DROGUERIA:
                producto = new Drogueria(nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);

            case PROD_COSMETICA:
                producto = new Cosmetica(nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);
        }

        return producto;
    }

    /**
     * Procesa una fila de un fichero CSV y devuelve un objeto Empleado.
     * @param fila Fila del fichero CSV.
     * @return Empleado.
     */
    public Empleado procesarEmpleado(String fila) {
        final String EMP_CAJERO = "CAJERO";
        final String EMP_ENCARGADO = "ENCARGADO";
        final String EMP_REPONEDOR = "REPONEDOR";
        final String EMP_EMPLEADO = "EMPLEADO";

        String nombre;
        String apellidos;
        int sueldo;
        String categoria;

        Empleado empleado = null;

        StringTokenizer st = new StringTokenizer(fila, ",");

        nombre = st.nextToken();
        apellidos = st.nextToken();
        sueldo = Integer.parseInt(st.nextToken());
        categoria = st.nextToken().toUpperCase();

        switch (categoria) {
            case EMP_CAJERO:
                empleado = new Cajero(nombre, apellidos, sueldo);
            
            case EMP_ENCARGADO:
                empleado = new Encargado(nombre, apellidos, sueldo);

            case EMP_REPONEDOR:
                empleado = new Reponedor(nombre, apellidos, sueldo);
            
            case EMP_EMPLEADO:
                empleado = new Empleado(nombre, apellidos, sueldo);
        }

        return empleado;
    }

    /**
     * Lee un fichero CSV y devuelve una lista de productos.
     * @param cadena Contenido del fichero CSV.
     * @return Lista de productos.
     * @throws LectorException Si hay un error al leer el fichero.
     */
    @Override
    public List<Producto> leerProducto (String cadena) throws LectorException {
        final String MSG_ERROR = "Error al leer el fichero CSV";

        boolean primeraFila = true;
        List<Producto> productos = new ArrayList<>();

        try {
            comprobar(cadena);

            StringTokenizer st = new StringTokenizer(cadena, "\n");
            while (st.hasMoreTokens()) {
                String fila = st.nextToken();

                if (!primeraFila && !"".equals(fila)) {
                    productos.add(procesarProducto(fila));
                } else {
                    primeraFila = false;
                }
            }
        } catch (Exception e) {
            throw new LectorException(MSG_ERROR);
        }

        return productos;
    }

    /**
     * Lee un fichero CSV y devuelve una lista de empleados.
     * @param cadena Contenido del fichero CSV.
     * @return Lista de empleados.
     * @throws LectorException Si hay un error al leer el fichero.
     */
    @Override
    public List<Empleado> leerEmpleado(String cadena) throws LectorException {
        final String MSG_ERROR = "Error al leer el fichero CSV";

        boolean primeraFila = true;
        List<Empleado> empleados = new ArrayList<>();

        try {
            comprobar(cadena);

            StringTokenizer st = new StringTokenizer(cadena, "\n");
            while (st.hasMoreTokens()) {
                String fila = st.nextToken();

                if (!primeraFila && !"".equals(fila)) {
                    empleados.add(procesarEmpleado(fila));
                } else {
                    primeraFila = false;
                }
            }
        } catch (Exception e) {
            throw new LectorException(MSG_ERROR);
        }

        return empleados;
    }
}
