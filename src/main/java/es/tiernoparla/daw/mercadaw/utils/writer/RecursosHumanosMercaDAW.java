package es.tiernoparla.daw.mercadaw.utils.writer;


import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.utils.writer.interfaces.RecursosHumanos;


public abstract class RecursosHumanosMercaDAW implements RecursosHumanos{

    public static final int NUM_PAGAS = 2;
    public static final int MESES = 12;

    protected String nombre;
    protected double contingencias;
    protected double desempleo;
    protected double formacion;
    protected double mei;
    protected double salario;
    protected double pagas;


    /**
     * Devuelve el valor de la constante CONTINGENCIAS para poder realizar los cálculos.
     */
    public abstract double getContingencias();

    /**
     * Devuelve el valor de la constante FORMACION para poder realizar los cálculos.
     */
    public abstract double getFormacion();

    /**
     * Devuelve el valor de la constante DESEMPLEO para poder realizar los cálculos.
     */
    public abstract double getDesempleo();

    /**
     * Devuelve el valor de la constante MEI para poder realizar los cálculos.
     */
    public abstract double getMEI();


    @Override
    public void calcularPagas(Empleado empleado) {
        pagas = (NUM_PAGAS * empleado.getSueldo()) / MESES;
    }

    @Override
    public void calcularContingencias(Empleado empleado) {
        contingencias = (empleado.getSueldo() + pagas) * getContingencias();
    }

    @Override
    public void calcularFormacion(Empleado empleado) {
        formacion = (empleado.getSueldo() + pagas) * getFormacion();
    }

    @Override
    public void calcularDesempleo(Empleado empleado) {
        desempleo = (empleado.getSueldo() + pagas) * getDesempleo();
    }

    @Override
    public void calcularMEI(Empleado empleado) {
        mei = (empleado.getSueldo() + pagas) * getMEI();
    }

    @Override
    public void obtenerSalario(Empleado empleado) {
        salario = empleado.getSueldo();
    }

    @Override
    public void obtenerNombreEmpleado(Empleado empleado){
        nombre = empleado.getNombre();
    }
}
