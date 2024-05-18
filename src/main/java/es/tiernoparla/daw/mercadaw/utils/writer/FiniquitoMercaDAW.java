package es.tiernoparla.daw.mercadaw.utils.writer;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;

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


    public void obtenerNombreEmpleado(Empleado empleado){
        nombre = empleado.getNombre();
    }

    public void calcualarSalarioAnual(Empleado empleado){
        salarioAnual = empleado.getSueldo() * MESES * NUM_PAGAS;
    }

    public void calcualarSalarioDiario(Empleado empleado){
        salarioDiario = salarioAnual / ANYO;
    }

    public String calcularIndemnizacion(Empleado empleado){

        obtenerNombreEmpleado(empleado);
        calcualarSalarioAnual(empleado);
        calcualarSalarioDiario(empleado);

        indemnizacion = salarioDiario * INDEMNIZACION * ANTIGUEDAD;

        return toString();
    }

    @Override
    public String toString() {
        final String CADENA = "# INDEMNIZACION\n"
                            + "## EMPLEADO: %s\n"
                            + "\n"
                            + "| Concepto                | Valor                  |\n"
                            + "|-------------------------|------------------------|\n"
                            + "| SALARIO DIARIO          | %s                     |\n"
                            + "| INDEMNIZACION LEGAL     | %s                     |\n"
                            + "| ANTIGÜEDAD              | %s                     |\n"
                            + "| **COSTE TOTAL**         | **%s**                 |\n";
        
        return String.format(CADENA, nombre, salarioDiario, INDEMNIZACION, ANTIGUEDAD, indemnizacion);
    }
    
    
}
