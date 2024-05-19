package es.tiernoparla.daw.mercadaw.utils.writer;

import java.util.Map;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;

/**
 * TODO Documentar clase
 */
public class CosteLaboralMercaDAW extends RecursosHumanosMercaDAW{

    private final static double CONTINGENCIAS = 0.236;
    private final static double DESEMPLEO = 0.055;
    private final static double FOGASA = 0.002;
    private final static double FORMACION = 0.006;
    private final static double MEI = 0.0058;

    private double fogasa;
    private double costeTotal;

    public void calcularFogasa(Empleado empleado) {
        calcularPagas(empleado);
        fogasa = (empleado.getSueldo() + pagas) * FOGASA;
    }

    @Override
    public double getContingencias() {
        return CONTINGENCIAS;
    }

    @Override
    public double getFormacion() {
        return FORMACION;
    }

    @Override
    public double getDesempleo() {
        return DESEMPLEO;
    }

    @Override
    public double getMEI() {
        return MEI;
    }

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
        costeTotal = empleado.getSueldo() + pagas + mei + contingencias +  desempleo + fogasa + formacion;

        return toString();
    }

    /**
     * Genera el coste total a mostrar en un mensaje de aviso
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
    
    return String.format(CADENA, nombre, salario, pagas, contingencias, desempleo, formacion, fogasa, mei, costeTotal);
}

    // TODO Mira a ver si borramos estos métodos, si no sirven hay que borrarlos también de la interfaz Documento (o la interfaz entera).
    @Override
    public Map<String, Object[]> getContenido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContenido'");
    }

    @Override
    public String getTitulo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitulo'");
    }

    @Override
    public String getPie() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPie'");
    }

}
