package es.tiernoparla.daw.mercadaw.model.entity.producto;

public abstract class Producto {

    protected String nombre;
    protected String marca;
    protected double precio;
    protected double altura;
    protected double anchura;
    protected double peso;
    protected int numElementos;
    protected String descripcion;

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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //TODO public double calcularPrecio()
    //TODO public double calcularRecargoPeso()
    //TODO public double calcularRecargoAltura()
    //TODO public double calcularRecargoAnchura()
    //TODO public double calcularRecargoNumElementos()
    //TODO public ProductoBuilder builder()
}
