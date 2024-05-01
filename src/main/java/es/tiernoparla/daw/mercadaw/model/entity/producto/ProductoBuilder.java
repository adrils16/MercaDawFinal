package es.tiernoparla.daw.mercadaw.model.entity.producto;

//De momento no se usa esta clase
public class ProductoBuilder {

    private String nombre;
    private String marca;
    private double precio;
    private double altura;
    private double anchura;
    private double peso;
    private int numElementos;
    private String descripcion;


    ProductoBuilder() {
        
    }
    /*
    public Producto build(CategoriaProducto tipo) {
        //TODO comprobaciones necesarias

        return ProductoFactory.crear());
    }
    */
    
    public ProductoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public ProductoBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoBuilder setAltura(double altura) {
        this.altura = altura;
        return this;
    }

    public ProductoBuilder setAnchura(double anchura) {
        this.anchura = anchura;
        return this;
    }

    public ProductoBuilder setPeso(double peso) {
        this.peso = peso;
        return this;

    }

    public ProductoBuilder setNumElementos(int numElementos) {
        this.numElementos = numElementos;
        return this;
    }

    public ProductoBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public double getAltura() {
        return altura;
    }

    public double getAnchura() {
        return anchura;
    }

    public double getPeso() {
        return peso;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
