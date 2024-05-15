package es.tiernoparla.daw.mercadaw.utils.writer;


import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;

public interface Nomina {
    
    public void calcularIRPF(Empleado empleado);
    public void calcularPagas(Empleado empleado);
    public void calcularContingencias(Empleado empleado);
    public void calcularFormacion(Empleado empleado);
    public void calcularDesempleo(Empleado empleado);
    public void calcularMEI();
}


