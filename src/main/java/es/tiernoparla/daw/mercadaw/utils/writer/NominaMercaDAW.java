package es.tiernoparla.daw.mercadaw.utils.writer;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.enumeracion.CategoriaEmpleado;

public class NominaMercaDAW extends WordUtil implements Nomina {
    
    public final static int NUM_PAGAS=2;
    public final static int MESES=12;
    public final static double IRPF=0.14;
    public final static double CONTIGENCIAS=0.047;
    public final static double FORMACION=0.001;
    public final static double DESEMPLEO=0.014;

    private double irpf;
    private double pagas;
    private double contingencias;
    private double formacion;
    private double desempleo;
    private double liquido;
    
    public double getLiquido() {
        return liquido;
    }
    public void setLiquido() {
        this.liquido = CategoriaEmpleado.EMPLEADO.getSueldo() + pagas - contingencias - irpf - formacion - desempleo;  
    }
    public double getIrpf() {
        return irpf;
    }
    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }
    public double getPagas() {
        return pagas;
    }
    public void setPagas(double pagas) {
        this.pagas = pagas;
    }
    public double getContingencias() {
        return contingencias;
    }
    public void setContingencias(double contingencias) {
        this.contingencias = contingencias;
    }
    public double getFormacion() {
        return formacion;
    }
    public void setFormacion(double formacion) {
        this.formacion = formacion;
    }
    public double getDesempleo() {
        return desempleo;
    }
    public void setDesempleo(double desempleo) {
        this.desempleo = desempleo;
    }
    @Override
    public void calcularIRPF(Empleado empleado) {

        irpf=IRPF*CategoriaEmpleado.EMPLEADO.getSueldo();
    }
    @Override
    public void calcularPagas(Empleado empleado) {
        
        pagas = (NUM_PAGAS * CategoriaEmpleado.EMPLEADO.getSueldo())/MESES;
    }
    @Override
    public void calcularContingencias(Empleado empleado) {
        contingencias = CategoriaEmpleado.EMPLEADO.getSueldo()*CONTIGENCIAS;
    }
    @Override
    public void calcularFormacion(Empleado empleado) {
        formacion = CategoriaEmpleado.EMPLEADO.getSueldo()*FORMACION;
    }
    @Override
    public void calcularDesempleo(Empleado empleado) {
        desempleo = CategoriaEmpleado.EMPLEADO.getSueldo()*DESEMPLEO;
    }

    @Override
    public String toString() {
        final String cadena = "CUANTIA \t  CONCEPTO \t \t DEVENGOS \t DEDUCCIONES \n 30 \t  SALARIO BASE \t \t %s \n 30 \t PAGAS EXTRA \t \t %s \n \t \t CONTIGENCIAS COMUNES 4.70%  \t  \t %s \n \t \t FORMACION 0.10 \t \t %s \n \t \t  DESEMPLEO 1.55%  \t \t %s \n \t \t IRPF 14% \t \t %s \n \n \n LIQUIDO A PERCIBIR: %s ";

        return String.format(cadena, CategoriaEmpleado.EMPLEADO.getSueldo(),pagas, contingencias,  formacion , desempleo , irpf , liquido );
    }
}
