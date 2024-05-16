package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;

public class MarkdownUtil implements Documento, Nomina {
    
    public static void crearMd(String cadena) throws IOException{
        final String NOMBRE_FICHERO = "nomina.md";
        FileWriter fich = null;
        PrintWriter pw = null;
        fich = new FileWriter(NOMBRE_FICHERO);

        pw = new PrintWriter(fich);

        pw.close();
        fich.close();

        FileWriter fichMod = new FileWriter(new File(NOMBRE_FICHERO),true);
        fichMod.write(cadena);
        fichMod.close();
    }

    @Override
    public void calcularIRPF(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularIRPF'");
    }

    @Override
    public void calcularPagas(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPagas'");
    }

    @Override
    public void calcularContingencias(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularContingencias'");
    }

    @Override
    public void calcularFormacion(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularFormacion'");
    }

    @Override
    public void calcularDesempleo(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularDesempleo'");
    }

    @Override
    public void calcularMEI(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularMEI'");
    }

    @Override
    public String calcularNomina(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularNomina'");
    }

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
