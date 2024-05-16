package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;

public class NominaMercaDAW implements Nomina, Documento {
    
    public final static int NUM_PAGAS=2;
    public final static int MESES=12;
    public final static double IRPF=0.14;
    public final static double CONTIGENCIAS=0.047;
    public final static double FORMACION=0.001;
    public final static double DESEMPLEO=0.014;
    public final static double MEI=0.012;

    private double irpf;
    private double pagas;
    private double contingencias;
    private double formacion;
    private double desempleo;
    private double liquido;
    private double mei;
    private double salario;

    public NominaMercaDAW(double irpf, double pagas, double contingencias, double formacion, double desempleo,
            double liquido, double mei) {
        this.irpf = irpf;
        this.pagas = pagas;
        this.contingencias = contingencias;
        this.formacion = formacion;
        this.desempleo = desempleo;
        this.liquido = liquido;
        this.mei = mei;
    }

    public double getMei() {
        return mei;
    }
    public void setMei(double mei) {
        this.mei = mei;
    }
    public double getLiquido() {
        return liquido;
    }
    public void setLiquido() {
        this.liquido = liquido;
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
        irpf=(empleado.getSueldo()+pagas) * IRPF;
    }
    @Override
    public void calcularPagas(Empleado empleado) {
        pagas = (NUM_PAGAS * empleado.getSueldo())/MESES;
    }
    @Override
    public void calcularContingencias(Empleado empleado) {
        contingencias = (empleado.getSueldo()+pagas)*CONTIGENCIAS;
    }
    @Override
    public void calcularFormacion(Empleado empleado) {
        formacion = (empleado.getSueldo()+pagas)*FORMACION;
    }
    @Override
    public void calcularDesempleo(Empleado empleado) {
        desempleo = (empleado.getSueldo()+pagas)*DESEMPLEO;
    }
    @Override
    public void calcularMEI(Empleado empleado) {
        mei = (empleado.getSueldo()+pagas)*MEI;
    }
    public void obtenerSalario(Empleado empleado){
        salario = empleado.getSueldo();
    }
    /**
     * Genera una nomina a mostrar en un mensaje de aviso
     */
    @Override 
    public String toString() {
    
        final String CADENA = "CUANTIA        CONCEPTO                 DEVENGOS     DEDUCCIONES \n"
                            + "\n"
                            + "  30         SALARIO BRUTO                  %s \n" 
                            + "  30         PAGAS EXTRA                    %s \n" 
                            + "             CONTIGENCIAS COMUNES 4.70                    %s \n " 
                            + "             FORMACION 0.10                               %s \n" 
                            + "             DESEMPLEO 1.55                               %s \n " 
                            + "             IRPF 14                                      %s \n " 
                            + "             MEI 0,12                                     %s \n "
                            + " \n "
                            + "#### LIQUIDO A PERCIBIR: %s ";
        
        return String.format(CADENA,salario,pagas, contingencias,  formacion , desempleo , irpf , mei , liquido );
    }
    
    @Override
    public String calcularNomina(Empleado empleado){
        obtenerSalario(empleado);
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
    /**
      * Convierte el docx nomina en un documento pdf
      */
    public void imprimirNomina(){

        String comando = "docker run --rm \\\n" + //
                        "       --volume \"$(pwd):/data\" \\\n" + //
                        "       --user $(id -u):$(id -g) \\\n" + //
                        "       pandoc/extra nomina.docx -o nomina.pdf";

        try {
            @SuppressWarnings("deprecation")
            Process process = Runtime.getRuntime().exec(comando);
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println(output);
                System.exit(0);
            } else {
                System.exit(1);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.exit(34);
        }
    }
    public static int getNumPagas() {
        return NUM_PAGAS;
    }
    public static int getMeses() {
        return MESES;
    }
    public static double getContigencias() {
        return CONTIGENCIAS;
    }
    public void setLiquido(double liquido) {
        this.liquido = liquido;
    }

}
