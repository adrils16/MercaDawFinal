package es.tiernoparla.daw.mercadaw.utils.writer;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
/**
 * Clase que permite calcular la nómina de un empleado.
 */
public class NominaMercaDAW extends RecursosHumanosMercaDAW{
    
    private final static double IRPF=0.14;
    private final static double CONTIGENCIAS=0.047;
    private final static double FORMACION=0.001;
    private final static double DESEMPLEO=0.014;
    private final static double MEI=0.012;

    private double irpf;
    private double liquido;


    @Override
    public double getContingencias(){
        return CONTIGENCIAS;
    }


    @Override
    public double getFormacion(){
        return FORMACION;
    }

    @Override
    public double getDesempleo(){
        return DESEMPLEO;
    }

    @Override
    public double getMEI(){
        return MEI;
    }

    /**
     * Calcula el IRPF de un empleado.
     * @param empleado Empleado del que se deasea calcular el IRPF.
     */
    public void calcularIRPF(Empleado empleado) {
        irpf=(empleado.getSueldo()+pagas) * IRPF;
    }

    /**
     * Calcula la nomina de un empleado.
     * @param empleado Empleado del que se deasea calcular la nomina.
     */
    @Override
    public String calcularImportes(Empleado empleado){
        obtenerSalario(empleado);
        obtenerNombreEmpleado(empleado);
        calcularPagas(empleado);
        calcularContingencias(empleado);
        calcularDesempleo(empleado);
        calcularFormacion(empleado);
        calcularIRPF(empleado);
        calcularMEI(empleado);

        obtenerSalario(empleado);
        liquido=empleado.getSueldo() + pagas - mei - contingencias - desempleo - irpf - formacion;

        return toString();
    }

    /**
     * Genera una nómina a mostrar en un mensaje de aviso.
     */
    @Override 
    public String toString() {
    
        final String CADENA = "# NOMINA\n"
                            + "## EMPLEADO: %s\n"
                            + "|CUANTIA|        CONCEPTO|                 DEVENGOS|      DEDUCCIONES|\n"
                            + "|---|---|---|---|\n"
                            + "|  30 |        SALARIO BRUTO |                   %s|                 |\n" 
                            + "|   |   |   |   |\n"
                            + "|  30 |       PAGAS EXTRA    |                   %s|                 |\n" 
                            + "|   |   |   |   |\n"
                            + "|     |      CONTIGENCIAS COMUNES 4.70 |           |               %s|\n " 
                            + "|   |   |   |   |\n"
                            + "|     |       FORMACION 0.10 |                     |               %s|\n " 
                            + "|   |   |   |   |\n"
                            + "|     |       DESEMPLEO 1.55 |                     |               %s|\n " 
                            + "|   |   |   |   |\n"
                            + "|     |        IRPF 14       |                     |               %s|\n " 
                            + "|   |   |   |   |\n"
                            + "|     |        MEI 0,12      |                     |               %s|\n "
                            + "\n"
                            + "#### LIQUIDO A PERCIBIR: %s \n"
                            + "\n";
        
        return String.format(CADENA,nombre,salario,pagas, contingencias,  formacion , desempleo , irpf , mei , liquido );
    }

}
