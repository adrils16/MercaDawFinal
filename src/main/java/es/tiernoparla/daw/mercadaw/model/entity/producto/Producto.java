package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;

public abstract class Producto implements Gestionable {

    protected String nombre;
    protected String marca;
    protected double precio;
    protected Caracteristica caracteristica;
    protected String descripcion;

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

    //TODO public double calcularPrecio()
}
