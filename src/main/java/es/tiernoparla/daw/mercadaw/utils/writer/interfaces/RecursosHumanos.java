package es.tiernoparla.daw.mercadaw.utils.writer.interfaces;


import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;

/**
 * TODO Documentar interface y métodos
 */
public interface RecursosHumanos {
    
    public void calcularPagas(Empleado empleado);
    public void calcularContingencias(Empleado empleado);
    public void calcularFormacion(Empleado empleado);
    public void calcularDesempleo(Empleado empleado);
    public void calcularMEI(Empleado empleado);
    public void obtenerSalario(Empleado empleado);
    public void obtenerNombreEmpleado(Empleado empleado);
    public String calcularImportes(Empleado empleado);
    
}


