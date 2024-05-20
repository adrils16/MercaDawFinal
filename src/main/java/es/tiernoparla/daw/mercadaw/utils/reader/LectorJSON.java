package es.tiernoparla.daw.mercadaw.utils.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import es.tiernoparla.daw.mercadaw.exception.LectorException;
import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Caracteristica;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import es.tiernoparla.daw.mercadaw.model.entity.producto.ProductoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;

/**
 * Clase que lee un fichero JSON y devuelve una lista de productos o empleados.
 */
public class LectorJSON extends LectorImp {

    /**
     * Procesa una pareja clave-valor y devuelve la clave.
     * 
     * @param pareja Pareja clave-valor.
     * @return Devuelve la clave.
     */
    public String procesarValor(String pareja) {
        String valor = null;

        pareja = pareja.trim();

        StringTokenizer st = new StringTokenizer(pareja, ":");
        st.nextToken();

        valor = st.nextToken().trim();
        valor = valor.substring(1, valor.length() - 1);

        return valor;
    }

    /**
     * Procesa una fila de empleados y devuelve un empleado.
     * 
     * @param fila Fila de empleados.
     * @return Devuelve un empleado.
     */
    public Empleado procesarEmpleado(String fila) {

        String nombre;
        String apellidos;
        int id = 0;
        CategoriaEmpleado categoria;

        Empleado empleado = null;

        StringTokenizer st = new StringTokenizer(fila, ",");

        nombre = procesarValor(st.nextToken());
        apellidos = procesarValor(st.nextToken());
        categoria = CategoriaEmpleado.valueOf(procesarValor(st.nextToken()));

        empleado = EmpleadoFactory.crear(categoria, nombre, apellidos, id);

        return empleado;
    }

    /**
     * Procesa una fila de productos y devuelve un producto.
     * 
     * @param fila Fila de productos.
     * @return Devuelve un producto.
     */
    public Producto procesarProducto(String fila) {

        String nombre;
        String marca;
        double precio;
        double altura;
        double anchura;
        double peso;
        int numElementos;
        String descripcion;
        CategoriaProducto categoria;

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
        categoria = CategoriaProducto.valueOf(st.nextToken().toUpperCase());

        Caracteristica caracteristica = new Caracteristica(altura, anchura, peso, numElementos);
        producto = ProductoFactory.crear(categoria, nombre, marca, precio, caracteristica, descripcion);

        return producto;
    }

    @Override
    public List<Gestionable> leerEmpleado(String cadena) throws LectorException {
        final String MSG_ERROR = "Error al leer el fichero JSON";

        List<Gestionable> empleados = new ArrayList<>();
        boolean primeraFila = true;

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

    @Override
    public List<Gestionable> leerProducto(String cadena) throws LectorException {
        final String MSG_ERROR = "Error al leer el fichero JSON";

        boolean primeraFila = true;
        List<Gestionable> productos = new ArrayList<>();

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

    @Override
    public String cargar(File fichero) throws Exception {
        final String MSG_ERROR = "Error al cargar el fichero JSON";

        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (Exception e) {
            throw new Exception(MSG_ERROR);
        }
        return contenido.toString();
    }

}
