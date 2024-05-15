package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import es.tiernoparla.daw.mercadaw.model.Sede;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;

public class NominaMercaDAW implements Nomina, Documento {
    
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
    private Sede sede;
    
    public Sede getSede() {
        return sede;
    }
    public void setSede(Sede sede) {
        this.sede = sede;
    }
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
    /**
     * Genera una nomina a mostrar en un mensaje de aviso
     */
    @Override 
    public String toString() {
    
        final String CADENA = "CUANTIA \t  CONCEPTO \t \t DEVENGOS \t DEDUCCIONES \n 30 \t  SALARIO BASE \t \t %s \n 30 \t PAGAS EXTRA \t \t %s \n \t \t CONTIGENCIAS COMUNES 4.70%  \t  \t %s \n \t \t FORMACION 0.10 \t \t %s \n \t \t  DESEMPLEO 1.55%  \t \t %s \n \t \t IRPF 14% \t \t %s \n \n \n LIQUIDO A PERCIBIR: %s ";
        
        //return String.format(CADENA, CategoriaEmpleado.EMPLEADO.getSueldo(),pagas, contingencias,  formacion , desempleo , irpf , liquido );

        //! Comentado y anyadido return por error en el código
        //! quitar return
        return null;
    }
    /* @Override
    public Map<String, Object[]> getContenido() {

        Empleado[] empleados = new Empleado[Sede.getEmpleados().length];

        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] { "Nombre", "Apellidos", "Edad" });

        for(int i=0; i<empleados.size(); i++){
            Empleado emp = empleados.get(i);
            Object[] empleadoDatos = new Object[] { emp.getNombre(), emp.getApellidos(), emp.CATEGORIA.getSueldo()};
            data.put(String.valueOf(2+i), empleadoDatos);
        }
        return data;
    }
    */
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
      * Convierte el docx en un documento pdf
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
    @Override
    public Map<String, Object[]> getContenido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContenido'");
    }
}
