package es.tiernoparla.daw.mercadaw.model.entity.producto.enums;

public enum TipoIVA {
    GENERAL(0.21),
    REDUCIDO(0.1),
    SUPERREDUCIDO(0.04);

    private double valor;

    private TipoIVA(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
    
}
