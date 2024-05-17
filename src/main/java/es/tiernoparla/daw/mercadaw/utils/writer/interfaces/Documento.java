package es.tiernoparla.daw.mercadaw.utils.writer.interfaces;

import java.util.Map;

public interface Documento {
    public Map<String, Object[]> getContenido();
    public String getTitulo();
    public String getPie();
}
