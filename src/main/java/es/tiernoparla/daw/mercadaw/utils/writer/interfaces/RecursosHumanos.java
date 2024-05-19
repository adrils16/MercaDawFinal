package es.tiernoparla.daw.mercadaw.utils.writer.interfaces;


import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;

/**
 * TODO Documentar interface y métodos
 */
public interface RecursosHumanos {
    
    /**
     * Calcula las pagas del empleado
     * @param empleado Empleado del que se deasea calcular las pagas.
     */
    public void calcularPagas(Empleado empleado);

    /**
     * Calcula las contingencias del empleado
     * @param empleado Empleado del que se deasea calcular las contingencias.
     */
    public void calcularContingencias(Empleado empleado);

    /**
     * Calcula la formación del empleado
     * @param empleado Empleado del que se deasea calcular la formación.
     */
    public void calcularFormacion(Empleado empleado);

    /**
     * Calcula el desempleo del empleado
     * @param empleado Empleado del que se deasea calcular el desempleo.
     */
    public void calcularDesempleo(Empleado empleado);

    /**
     * Calcula el MEI del empleado
     * @param empleado Empleado del que se deasea calcular el MEI.
     */
    public void calcularMEI(Empleado empleado);

    /**
     * Calcula el salario del empleado
     * @param empleado Empleado del que se deasea calcular el salario.
     */
    public void obtenerSalario(Empleado empleado);

    /**
     * Obtiene el nombre del empleado
     * @param empleado Empleado del que se deasea obtener el nombre.
     */
    public void obtenerNombreEmpleado(Empleado empleado);

    public String calcularImportes(Empleado empleado);

    
}


