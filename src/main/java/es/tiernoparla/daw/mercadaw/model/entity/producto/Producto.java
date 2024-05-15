package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Imprimible;
import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.TipoIVA;

public abstract class Producto implements Imprimible {

    public final static TipoIVA IVA = TipoIVA.GENERAL;

    protected String nombre;
    protected String marca;
    protected double precio;
    protected Caracteristica caracteristica;
    protected String descripcion;
    protected double valorIVA;

    public Producto(String nombre, String marca, double precio, Caracteristica caracteristica, String descripcion) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
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

    /**
     * Calcula el precio de venta del producto, añadiendo un 25% del precio original. 
     * @return Precio de venta del Producto.
     */
    public double calcularPrecioVenta() {

        final double COMISION = 0.25;

        double precioVenta = precio+(precio*COMISION);

        return precioVenta;

    }

    /**
     * Calcula el precio total del producto sumando al precio de venta todos los recargos correspondientes.
     * @return Precio total del Producto.
     */
    public double calcularPrecioTotal() {

        double precioTotal =  calcularPrecioVenta()+caracteristica.calcularRecargoTotal(calcularPrecioVenta());

        return precioTotal;

    }

    /**
     * Calcula el precio en dolares, con una relación de 1 $ por 0,90 €.
     * @return Precio total en dolares del Producto.
     */
    public double calcularPrecioEnDolares() {

        final double CONVERSOR_DOLAR = 0.9;

        double precioEnDolares = calcularPrecioTotal()/CONVERSOR_DOLAR;

        return precioEnDolares;

    }

    /**
     * Calcula que cantidad del precio total corresponde al IVA
     * @param precioTotal Precio total del Producto.
     * @return Valor correspondiente al IVA.
     */
    public double calcularValorIVA(double precioTotal) {

        double valorIVA = precioTotal*this.valorIVA;

        return valorIVA;

    }

    public String imprimir() {

        final String PLANTILLA = "* Nombre: %s\n"
                            +"* Marca: %s\n"
                            +"* Precio: %s €\n"
                            +"* Altura: %s m\n"
                            +"* Anchura: %s m\n"
                            +"* Peso: %s kg\n"
                            +"* Número de elementos: %s\n"
                            +"* Descripción: %s\n"; 

        String cadena = String.format(PLANTILLA, nombre, marca, precio, caracteristica.getAltura(), caracteristica.getAnchura(), caracteristica.getPeso(), caracteristica.getNumElementos(), descripcion);

        return cadena;
    }

    public String visualizarPrecioTotal()  {

        final String PLANTILLA = "* PRECIO TOTAL: %s € / %s $\n"
                                +"* IVA (%s): %s";

        String textoPT = String.format(PLANTILLA, calcularPrecioTotal(), calcularPrecioEnDolares(), valorIVA, calcularValorIVA(calcularPrecioTotal()));

        String cadena = imprimir()+caracteristica.visualizarRecargos(calcularPrecioVenta())+textoPT;

        return cadena;

    }

    //TODO public String imprimirEtiqueta() 


}
