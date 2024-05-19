package es.tiernoparla.daw.mercadaw.utils.writer;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;

public class CosteLaboralMercaDAW extends RecursosHumanosMercaDAW {

    private final static double CONTINGENCIAS = 0.236;
    private final static double DESEMPLEO = 0.055;
    private final static double FOGASA = 0.002;
    private final static double FORMACION = 0.006;
    private final static double MEI = 0.0058;

    private double fogasa;
    private double costeTotal;

    /**
     * Calcula el fogasa dado un empleado.
     * 
     * @param empleado Empleado del que se deasea calcular el Fogasa.
     */
    public void calcularFogasa(Empleado empleado) {
        calcularPagas(empleado);
        fogasa = (empleado.getSueldo() + pagas) * FOGASA;
    }

    /**
     * Devuelve el valor de la constante CONTINGENCIAS para poder realizar los
     * cálculos en RecursosHumanosMercaDAW
     */
    @Override
    public double getContingencias() {
        return CONTINGENCIAS;
    }

    /**
     * Devuelve el valor de la constante FORMACION para poder realizar los cálculos
     * en RecursosHumanosMercaDAW
     */
    @Override
    public double getFormacion() {
        return FORMACION;
    }

    /**
     * Devuelve el valor de la constante DESEMPLEO para poder realizar los cálculos
     * en RecursosHumanosMercaDAW
     */
    @Override
    public double getDesempleo() {
        return DESEMPLEO;
    }

    /**
     * Devuelve el valor de la constante MEI para poder realizar los cálculos en
     * RecursosHumanosMercaDAW
     */
    @Override
    public double getMEI() {
        return MEI;
    }

    /**
     * Calcula el coste laboral que le cuesta a la empresa mantener a sus empleados.
     * 
     * @param empleado Empleado del que se desea calcular el coste laboral.
     */
    @Override
    public String calcularImportes(Empleado empleado) {
        obtenerSalario(empleado);
        obtenerNombreEmpleado(empleado);
        calcularPagas(empleado);
        calcularContingencias(empleado);
        calcularDesempleo(empleado);
        calcularFormacion(empleado);
        calcularFogasa(empleado);
        calcularMEI(empleado);

        obtenerSalario(empleado);
        costeTotal = empleado.getSueldo() + pagas + mei + contingencias + desempleo + fogasa + formacion;

        return toString();
    }

    /**
     * Plantilla para imprimir el coste laboral.
     */
    @Override
    public String toString() {

        final String CADENA = "# COSTE LABORAL\n"
                + "## APORTE DE SEGURIDAD SOCIAL\n"
                + "### EMPLEADO: %s\n"
                + "\n"
                + "| Concepto                | Valor                  |\n"
                + "|-------------------------|------------------------|\n"
                + "| SALARIO BRUTO           | %s                     |\n"
                + "|                         |                        |\n"
                + "| PAGAS EXTRA             | %s                     |\n"
                + "|                         |                        |\n"
                + "| CONTINGENCIAS COMUNES   | %s                     |\n"
                + "|                         |                        |\n"
                + "| DESEMPLEO               | %s                     |\n"
                + "|                         |                        |\n"
                + "| FORMACION               | %s                     |\n"
                + "|                         |                        |\n"
                + "| FOGASA                  | %s                     |\n"
                + "|                         |                        |\n"
                + "| MEI                     | %s                     |\n"
                + "\n"
                + "#### COSTE TOTAL      %s                      ";

        return String.format(CADENA, nombre, salario, pagas, contingencias, desempleo, formacion, fogasa, mei,
                costeTotal);
    }

}
