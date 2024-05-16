package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;

public class NominaMercaDAW implements Nomina, Documento {
    
    private final static int NUM_PAGAS=2;
    private final static int MESES=12;
    private final static double IRPF=0.14;
    private final static double CONTIGENCIAS=0.047;
    private final static double FORMACION=0.001;
    private final static double DESEMPLEO=0.014;
    private final static double MEI=0.012;

    public double irpf;
    public double pagas;
    public double contingencias;
    public double formacion;
    public double desempleo;
    public double liquido;
    public double mei;
    public double salario;

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
    
        final String CADENA = "|CUANTIA|        CONCEPTO|                 DEVENGOS|      DEDUCCIONES|\n"
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

}
