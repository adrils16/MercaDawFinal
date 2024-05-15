package es.tiernoparla.daw.mercadaw.model.entity.producto;

public class Caracteristica {

    protected double altura;
    protected double anchura;
    protected double peso;
    protected int numElementos;

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

    //TODO public double calcularRecargoPeso()
    //TODO public double calcularRecargoAltura()
    //TODO public double calcularRecargoAnchura()
    //TODO public double calcularRecargoNumElementos()
}


