package es.tiernoparla.daw.mercadaw.model.entity.producto;


/**
 * Esta clase separa ciertos atributos de la clase Producto, de tal forma que esta tenga menos atributos.
 * Además realiza operaciones sobre sobre los diferentes recargos del Producto, delegando esa funcionalidad
 * a esta clase.
 */
public class Caracteristica {

    public static final double RECARGO_MAX = 0.15;
    public static final double RECARGO_MED = 0.1;
    public static final double RECARGO_MIN = 0.05;
    public static final double RECARGO_ELEM = 0.1;

    private double altura;
    private double anchura;
    private double peso;
    private int numElementos;

    public Caracteristica(double altura, double anchura, double peso, int numElementos) {
        this.altura = altura;
        this.anchura = anchura;
        this.peso = peso;
        this.numElementos = numElementos;
    }
    
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getAnchura() {
        return anchura;
    }
    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getNumElementos() {
        return numElementos;
    }
    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    /**
     * Calcula el tipo de recargo que se aplica en función del peso.
     * Si el peso es superior a 5 kg, se cobra un 15%.
     * Si es superior a 1 kg, se cobra un 10%. 
     * En caso contrario solo el 5%.
     * @return Tipo de recargo a aplicar al precio de venta.
     */
    public double calcularTipoRecargoPeso() {

        final int PESO_MAX = 5;
        final int PESO_MED = 1;
        
        double tipoRecargo = RECARGO_MIN;

        if (peso > PESO_MAX) {
            tipoRecargo = RECARGO_MAX;
        }else if (peso > PESO_MED) {
            tipoRecargo = RECARGO_MED;
        }

        return tipoRecargo;
    }

    /**
     * Calcula el valor del recargo sobre el precio de venta en función del peso.
     * @param precioVenta Precio de venta del producto.
     * @return Recargo en función del peso.
     */
    public double calcularValorRecargoPeso(double precioVenta) {
    
        double recargoPeso = 0;

        recargoPeso = precioVenta*(calcularTipoRecargoPeso()*numElementos);

        return recargoPeso;
    }

    /**
     * Calcula el tipo de recargo que se aplica en función a la altura o a la anchura.
     * Si la dimension es mayor a 0.5 m, se cobra un 10%.
     * En caso contrario solo el 5%.
     * @param dimension Altura o anchura del producto.
     * @return Tipo de recargo a aplicar al precio de venta.
     */
    public double calcularTipoRecargoDimension(double dimension) {

        final double DIMENSION_MAX = 0.5;

        double tipoRecargo = RECARGO_MIN;

        if (dimension > DIMENSION_MAX) {
            tipoRecargo = RECARGO_MED;
        } 

        return tipoRecargo;
    }

    /**
     * Calcula el recargo en función de la altura o la anchura, ya que el calculo es igual para ambas dimensiones.
     * @param dimension Altura o anchura del producto
     * @param precioVenta Precio de venta del producto
     * @return Recargo en función de la altura o la anchura.
     */
    public double calcularValorRecargoDimension(double dimension, double precioVenta) {

        double recargoDimension = 0;

        recargoDimension = precioVenta*(calcularTipoRecargoDimension(dimension)*numElementos);

        return recargoDimension;
    }

    /**
     * Calcula el recargo en función del número de elementos.
     * Si el producto tiene más de 2 elementos, se cobra 0.1 € por elemento.
     * @return Recargo en función del número de elementos.
     */
    public double calcularRecargoNumElementos() {

        final int NUM_ELEMENTOS_MAX = 2;

        double recargoNumElementos = 0;

        if (numElementos > NUM_ELEMENTOS_MAX) {
            recargoNumElementos = RECARGO_ELEM*numElementos;
        }

        return recargoNumElementos;

    }

    /**
     * Calcula el valor total del recargo.
     * @param precioVenta Precio de venta del producto.
     * @return Suma del valor de todos los recargos.
     */
    public double calcularRecargoTotal(double precioVenta) {

        double recargoTotal = 0;

        recargoTotal = calcularValorRecargoPeso(precioVenta)
                    +calcularValorRecargoDimension(altura, precioVenta)
                    +calcularValorRecargoDimension(anchura, precioVenta)
                    +calcularRecargoNumElementos();

        return recargoTotal;
        
    }

    /**
     * Crea una String formateado con los tipos y valores de todos los recargos.
     * @param precioVenta Precio de venta del producto.
     * @return Devuelve un String con todos los recargos.
     */
    public String visualizarRecargos(double precioVenta) {

        final String TEXTO = "* Recargo por peso (%s): %s\n"
                        +"* Recargo por altura (%s): %s\n"
                        +"* Recargo por anchura (%s): %s\n"
                        +"* Recargo por número de piezas (%s pieza/s): %s\n";
        
        String cadena;

        cadena = String.format(TEXTO, calcularTipoRecargoPeso(), calcularValorRecargoPeso(precioVenta), calcularTipoRecargoDimension(altura), calcularValorRecargoDimension(altura, precioVenta), calcularTipoRecargoDimension(anchura), calcularValorRecargoDimension(anchura, precioVenta), numElementos, calcularRecargoNumElementos());
        
        return cadena;

    }
}


