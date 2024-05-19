package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import es.tiernoparla.daw.mercadaw.utils.writer.interfaces.Documento;

/**
 * Clase que permite transformar una cadena de texto en documentos Markdown.
 */
public class MarkdownUtil implements Documento{
    
    /**
     * Crea un fichero nomina.md con la cadena pasada por parámetro.
     * @param cadena Etiqueta a escribir en el fichero.
     * @throws IOException 
     */
    public static void crearNominaMd(String cadena) throws IOException {
	    final String NOMBRE_FICHERO = "nomina.md";
        
        FileWriter fichMod = new FileWriter(NOMBRE_FICHERO, true);
        PrintWriter pw = new PrintWriter(fichMod);
        pw.println(cadena);

        pw.close();
        fichMod.close();
    }

    /**
     * Crea un fichero costes.md con la cadena pasada por parámetro.
     * @param cadena Etiqueta a escribir en el fichero.
     * @throws IOException 
     */
    public static void crearCostesMd(String cadena) throws IOException{
        final String NOMBRE_FICHERO = "costes.md";
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

    /**
     * Crea un fichero finiquito.md con la cadena pasada por parámetro.
     * @param cadena Etiqueta a escribir en el fichero.
     * @throws IOException 
     */
    public static void crearFiniquitoMd(String cadena) throws IOException{
        final String NOMBRE_FICHERO = "finiquito.md";
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

    /**
     * Crea un fichero etiqueta.md con la cadena pasada por parámetro.
     * @param cadena Etiqueta a escribir en el fichero.
     * @throws IOException 
     */
    public static void crearEtiqueta(String cadena) throws IOException{
        final String NOMBRE_FICHERO = "etiqueta.md";
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

}
