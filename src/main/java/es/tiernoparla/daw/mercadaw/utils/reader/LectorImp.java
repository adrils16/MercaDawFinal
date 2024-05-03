package es.tiernoparla.daw.mercadaw.utils.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import es.tiernoparla.daw.mercadaw.exception.FicheroException;


public abstract class LectorImp implements Lector{

    final String MSG_ERROR = "Fichero no válido";

    /**
     * Comprueba si un código es válido.
     * @param codigo Código a comprobar.
     * @throws Exception Si el código no es válido.
     */
    public void comprobar(String codigo) throws Exception {
        if (codigo.equals(null) && codigo.equals("")) {
            throw new FicheroException(MSG_ERROR);
        }
    }

    /**
     * Carga el contenido de un fichero.
     * @param file Fichero a cargar.
     * @return Contenido del fichero.
     * @throws FicheroException Si hay un error al cargar el fichero.
     */
    public String cargar(File file) throws FicheroException{
        final String MSG_ERROR = "Error al cargar el fichero";

        StringBuilder contenido = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            br.close();
        } catch (Exception e) {
            throw new FicheroException(MSG_ERROR);
        }
        return contenido.toString();
    }

}
