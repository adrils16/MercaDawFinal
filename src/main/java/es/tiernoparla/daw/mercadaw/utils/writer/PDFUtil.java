package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PDFUtil extends DocumentoUtil{
    
    /**
     * Este metodo exporta a PDF a traves de un comando de docker que llama a un sistema con pandoc, es necesario tener el otro fichero creado previmente para que funcione
     * @param nombreFichero fichero que queremos exportar a PDF
     */
    public static void exportarPDF() throws IOException{

        //! Comando para exportar a PDF desde un script de bash
        final String [] COMANDO = {"./scrpit.sh"};

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
