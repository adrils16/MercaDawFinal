package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PDFUtil extends DocumentoUtil{
    
    /**
     * Este metodo exporta a PDF a traves de un comando de docker que llama a un sistema con pandoc, es necesario tener el otro fichero creado previmente para que funcione
     * @param nombreFichero fichero que queremos exportar a PDF
     */
    public static void exportarPDF(String nombreFichero){
        //no funciona ni array ni String
        final String [] COMANDO ={"docker run --rm \\\n"+
                        "       --volume \"$(pwd):/data\" \\\n",
                        "       --user $(id -u):$(id -g) \\\n", 
                        "       pandoc/extra nomina.md -o outfile.pdf"};

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
