package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase que permite transformar un docuento Markdown en PDF..
 */
public class PDFUtil {
    
    /**
     * Este metodo exporta la nomina a PDF a traves de un comando de docker que llama a un sistema con pandoc, es necesario tener el otro fichero creado previmente para que funcione.
     * @throws IOException
     */
    public static void exportarNominaPDF() throws IOException{

        //! Comando para exportar a PDF desde un script de bash
        final String [] COMANDO = {"./scriptNomina.sh"};

        try {
            Process process = Runtime.getRuntime().exec(COMANDO);
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este metodo exporta los costes a PDF a traves de un comando de docker que llama a un sistema con pandoc, es necesario tener el otro fichero creado previmente para que funcione.
     * @throws IOException
     */
    public static void exportarCostesPDF() throws IOException{

        //! Comando para exportar a PDF desde un script de bash
        final String [] COMANDO = {"./scriptCostes.sh"};


            Process process = Runtime.getRuntime().exec(COMANDO);
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        }

    /**
     * Este metodo exporta el finiquito a PDF a traves de un comando de docker que llama a un sistema con pandoc, es necesario tener el otro fichero creado previmente para que funcione.
     * @throws IOException
     */
    public static void exportarFiniquitoPDF() throws IOException{

        //! Comando para exportar a PDF desde un script de bash
        final String [] COMANDO = {"./scriptFiniquito.sh"};

        try {
            Process process = Runtime.getRuntime().exec(COMANDO);
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            int exitVal = process.waitFor();
            if (exitVal == 0) {
            } else {
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.exit(34);
        }
    }

    /**
     * Este metodo exporta a PDF a traves de un comando de docker que llama a un sistema con pandoc, es necesario tener el otro fichero creado previmente para que funcione
     * @throws IOException
     */
    public static void exportarEtiquetaPDF() throws IOException {
            
            //! Comando para exportar a PDF desde un script de bash
            final String [] COMANDO = {"./scriptEtiqueta.sh"};
    
            
            Process process = Runtime.getRuntime().exec(COMANDO);
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
                //int exitVal = process.waitFor();
             
    }
}
