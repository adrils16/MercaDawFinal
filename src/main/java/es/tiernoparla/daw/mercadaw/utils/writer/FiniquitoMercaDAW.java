package es.tiernoparla.daw.mercadaw.utils.writer;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;

/**
 * Clase que permite calcular el finiquito de un empleado.
 */
public class FiniquitoMercaDAW {

    private final static int NUM_PAGAS = 2;
    private final static int MESES=12;
    private final static int ANTIGUEDAD = 2;
    private final static int INDEMNIZACION = 20;
    private final static int ANYO = 365;

    private String nombre;
    private double indemnizacion;
    private double salarioAnual;
    private double salarioDiario;


    /**
     * Obtiene el nombre de un empleado.
     * @param empleado Empleado del que se desea obtener el nombre. 
     */
    public void obtenerNombreEmpleado(Empleado empleado){
        nombre = empleado.getNombre();
    }

    /**
     * Calcula el salario anual que cobra un empleado.
     * @param empleado Empleado del que se desea calcular el salario anual. 
     */
    public void calcualarSalarioAnual(Empleado empleado){
        salarioAnual = empleado.getSueldo() * MESES * NUM_PAGAS;
    }

    /**
     * Calcula el salario diario que cobra un empleado.
     * @param empleado Empleado del que se desea calcular el salario diario. 
     */
    public void calcualarSalarioDiario(Empleado empleado){
        salarioDiario = salarioAnual / ANYO;
    }

    /**
     * Calcula la indemnización de un empleado.
     * @param empleado Empleado del que se desea calcular la indemnización. 
     */
    public String calcularIndemnizacion(Empleado empleado){

        obtenerNombreEmpleado(empleado);
        calcualarSalarioAnual(empleado);
        calcualarSalarioDiario(empleado);

        indemnizacion = salarioDiario * INDEMNIZACION * ANTIGUEDAD;

        return toString();
    }

    /**
     * Plantilla para imprimir la indemnización.
     */
    @Override
    public String toString() {
        final String CADENA = "# INDEMNIZACION\n"
                            + "## EMPLEADO: %s\n"
                            + "\n"
                            + "| Concepto                | Valor                  |\n"
                            + "|-------------------------|------------------------|\n"
                            + "| SALARIO DIARIO          | %s                     |\n"
                            + "|                         |                        |\n"
                            + "| INDEMNIZACION LEGAL     | %s                     |\n"
                            + "|                         |                        |\n"
                            + "| ANTIGÜEDAD              | %s                     |\n"
                            + "\n"
                            + "#### INDEMNIZACION        %s                \n";
        
        return String.format(CADENA, nombre, salarioDiario, INDEMNIZACION, ANTIGUEDAD, indemnizacion);
    }
    
    
}
