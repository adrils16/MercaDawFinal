package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;
import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Imprimible;
import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.TipoIVA;

/**
 * Clase abstracta que representa el estado y comportamiento de un objeto Producto.
 */
public abstract class Producto implements Imprimible, Gestionable {

    public final static TipoIVA IVA = TipoIVA.GENERAL;

    protected String nombre;
    protected String marca;
    protected double precio;
    protected Caracteristica caracteristica;
    protected String descripcion;
    protected double valorIVA = IVA.getValor();
    protected String categoria;

    public Producto(String nombre, String marca, double precio, Caracteristica caracteristica, String descripcion, String categoria) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public static TipoIVA getIva() {
        return IVA;
    }

    public double getValorIVA() {
        return valorIVA;
    }

    public void setValorIVA(double valorIVA) {
        this.valorIVA = valorIVA;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Calcula el precio de venta del producto, añadiendo un 25% del precio original. 
     * @return Precio de venta del Producto.
     */
    private double calcularPrecioVenta() {

        final double COMISION = 0.25;

        double precioVenta = precio+(precio*COMISION);

        return precioVenta;

    }

    /**
     * Calcula el precio total del producto sumando al precio de venta todos los recargos correspondientes.
     * @return Precio total del Producto.
     */
    private double calcularPrecioTotal() {

        double precioTotal =  calcularPrecioVenta()+caracteristica.calcularRecargoTotal(calcularPrecioVenta());

        return precioTotal;

    }

    /**
     * Calcula el precio en dolares, con una relación de 1 $ por 0,90 €.
     * @return Precio total en dolares del Producto.
     */
    private double calcularPrecioEnDolares() {

        final double CONVERSOR_DOLAR = 0.9;

        double precioEnDolares = calcularPrecioTotal()/CONVERSOR_DOLAR;

        return precioEnDolares;

    }

    /**
     * Calcula que cantidad del precio total corresponde al IVA
     * @param precioTotal Precio total del Producto.
     * @return Valor correspondiente al IVA.
     */
    private double calcularValorIVA(double precioTotal) {

        double valor = precioTotal*valorIVA;

        return valor;

    }

    @Override
    public String imprimir() {

        final String PLANTILLA = "* Nombre: %s\n"
                            +"* Marca: %s\n"
                            +"* Precio: %.2f €\n"
                            +"* Altura: %s m\n"
                            +"* Anchura: %s m\n"
                            +"* Peso: %s kg\n"
                            +"* Número de elementos: %s\n"
                            +"* Descripción: %s\n"; 

        String cadena = String.format(PLANTILLA, nombre, marca, precio, caracteristica.getAltura(), caracteristica.getAnchura(), caracteristica.getPeso(), caracteristica.getNumElementos(), descripcion);

        return cadena;
    }

    /**
     * Concatena el String del método imprimir() con el de visualizarRecargos() en Caracteristica, 
     * junto con la información de su precio total.
     * @return String con toda la información del producto y su precio total.
     */
    public String visualizarPrecioTotal()  {

        final String PLANTILLA = "* PRECIO TOTAL: %.2f € / %.2f $\n"
                                +"* IVA (%s): %.2f";

        String textoPT = String.format(PLANTILLA, calcularPrecioTotal(), calcularPrecioEnDolares(), valorIVA, calcularValorIVA(calcularPrecioTotal()));

        String cadena = imprimir()+caracteristica.visualizarRecargos(calcularPrecioVenta())+textoPT;

        return cadena;

    }

    /**
     * Crea un String con una etiqueta que muestra información resumida del Producto
     * @return String de la etiqueta
     */
    public String imprimirEtiqueta() {

        final String PLANTILLA = "* Nombre: %s\n"
                                +"* Marca: %s\n"
                                +"* Categoría: %s\n"
                                +"* Descripción: %s\n"; 

        String cadena = String.format(PLANTILLA, nombre, marca, categoria, descripcion);

        return cadena;

    }

}
