package es.tiernoparla.daw.mercadaw.utils.writer.interfaces;

import java.util.Map;

/**
 * TODO Documentar interface y métodos
 */
public interface Documento {
    public Map<String, Object[]> getContenido();
    public String getTitulo();
    public String getPie();
}
